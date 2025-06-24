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
      <el-menu 
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#409eff"
      >
      <!-- 一级菜单 -->
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>导航一</span>
        </template>

          <el-menu-item index="1-1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>导航一</span>
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
  methods: {
    logout() {
      window.sessionStorage.clear();//清除session
      this.$router.push("/login");//回到登录页面
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
  background-color: #a754a0;
}
img {
  width: 55px;
  height: 55px;
}
</style>