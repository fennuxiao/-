<template>
    <div class="login_contrainer">
        <!-- 登录块 -->
        <div class=" login_box">
            <!-- 头像 -->
            <div class="avatar_box">
                <img src="../assets/logo.png" alt="头像">
            </div>
            <!-- 表单区域 -->
            <el-form ref="loginFormRef" :rules="loginRules" :model="loginForm" class="login_form" label-width="0">
                <!-- 用户名 -->
                <el-form-item prop="username">
                    <el-input v-model="loginForm.username" prefix-icon="iconfont icon-denglu"></el-input>
                </el-form-item>
                <!-- 密码 -->
                <el-form-item prop="password">
                    <el-input v-model="loginForm.password" prefix-icon="iconfont icon-mima" type="password"></el-input>
                </el-form-item>
                <!-- 按钮 -->
                <el-form-item class="btns">
                    <el-button type="primary" @click="login">提交</el-button>
                    <el-button type="info" @click="resetLoginForm">重置</el-button>
                </el-form-item>
            </el-form>

        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            //表单数据
            loginForm: {
                username: 'admin',
                password: '123456'
            },
            //验证对象
            loginRules: {
                //校验用户名
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },//是必填项,触发事件
                    { min: 3, max: 10, message: '长度在3到10个字符', trigger: 'blur' }//长度验证
                ],
                //校验密码
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 5, max: 10, message: '长度在5到10个字符', trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        //重置表单
        resetLoginForm() {
            this.$refs.loginFormRef.resetFields();
        },
        //处理登录请求
        async login() {
            try {
                const valid = await new Promise(resolve => {
                    this.$refs.loginFormRef.validate(resolve);
                });
                if (!valid) return;

                console.log('发送的登录数据:', this.loginForm); // 打印发送的数据
                const { data: res } = await this.$http.post("/login", this.loginForm, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
                if (res.flag === "ok") {
                    this.$message.success("登录成功");
                    this.$router.push({ path: "/home" });
                    window.sessionStorage.setItem("user",res.user);//存储user对象
                } else {
                    this.$message.error("登录失败");
                }
            } catch (error) {
                if (error.response && error.response.status === 500) {
                    this.$message.error('服务器内部错误，请稍后再试');
                } else {
                    this.$message.error('请求出错，请检查网络连接');
                }
                console.error('请求错误:', error);
            }
        }
    }
}
</script>
<style lang="less" scoped>
//根节点样式
.login_contrainer {
    background-color: #2b4b6b;
    height: 100%;

}

.login_box {
    width: 450px;
    height: 300px;
    background-color: #fff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);

    .avatar_box {
        width: 130px;
        height: 130px;
        border: 1px solid #eee;
        border-radius: 50%;
        padding: 10px;
        box-shadow: 0 0 5px #ddd;
        position: absolute;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #0ee;

        img {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background-color: #eee;
        }
    }

}

.btns {
    display: flex;
    justify-content: flex-end;

}

.login_form {
    position: absolute;
    bottom: 0%;
    width: 100%;
    padding: 0 10px;
    box-sizing: border-box;
}
</style>