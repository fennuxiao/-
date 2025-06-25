<template>
  <!-- 引入container布局 -->
  <el-container class="home-container"> 
    <!-- 头部 -->
    <el-header>
      <div> 
<img src="../assets/logo.jpg" alt/> 
      </div>
      <span>
        个人运动平台
      </span>
    <el-button type="info" @click="logout">安全退出</el-button>
   </el-header>
   <!-- 主体 -->
    <el-container>
      <!-- 侧边栏 -->
    <el-aside width="200px">
      <el-menu background-color="#545c64"  text-color="#fff"  active-text-color="#409eff"
      font-size:14px>
      <!-- 一级菜单 -->
      <el-submenu index="item.id+''" v-for="item in menuList" :key="item.id">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>{{item.title}}</span>
        </template>
      <!-- 二级菜单 -->
          <el-menu-item index="it.id+''" v-for="it in item.sList" :key="it.id">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span style="color:white">{{it.title}}</span>
            </template>
          </el-menu-item>
        </el-submenu>
    </el-menu>
    </el-aside>
    <!-- 主体 -->
    <el-main>
      main

    </el-main>
    </el-container>
  </el-container>

</template>
<script>
export default {
  data() {
    return {
      //菜单列表
      menuList:[],
    }
  },
  created() {
    //onload事件,页面一加载就实现
    this.getMenuList();
  },
  methods: {
    logout() {
      window.sessionStorage.clear();//清除session
      this.$router.push("/login");//回到登录页面
    },
    //获取导航菜单方法
    async getMenuList() {
      const {data:res}=await this.$http.get("menus");
      console.log(res);
      if(res.flag!=200) return this.$message.error("获取菜单列表失败");//访问失败
      this.menuList=res.menus;//访问成功数据回填
    }
  }

}
</script>
<style lang="less" scoped>
//布局器样式
.home-container {
  height: 100vh; // 100% 视口高度
}
//头样式
.el-header {
  background-color: #5685c2;
  display: flex;
  justify-content: space-between; // 左右贴边
  padding-left: 0%;//左边界
  color:#fff;
  font-size:20px;
  div{
    display: flex;
    align-items: center;
    span{
    margin-left: 15px;
    }
  }
  
}
//侧边栏样式
.el-aside {
  background-color: #4fb96d;

}

//主体样式
.el-main {
  background-color: #d896d2;
}
img {
  width: 55px;
  height: 55px;
}
</style>​