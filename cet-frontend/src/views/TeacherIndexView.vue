<template>
  <div class="common-layout">
    <el-container style="height: 100vh">
      <el-header height="50px" style="background-color: #475669" >
        <el-container direction="horizontal" style="background-color: white">
          <el-container direction="horizontal" style="background-color: #475669">
            <img src="../figs/cetlogo.png"
                 style="width: 20px; height: 20px; margin-left: 2px;margin-top: 15px;margin-right: 10px" alt="sss"/>
            <el-text style="color: white">
              教师管理系统
            </el-text>
          </el-container>
          <el-container direction="horizontal" style="width: 1113px">
            <el-breadcrumb separator="/" class="header-breadcrumb">
              <el-breadcrumb-item>teacher</el-breadcrumb-item>
              <el-breadcrumb-item>
                <a href="/teacher/index">
                  index
                </a>
              </el-breadcrumb-item>
            </el-breadcrumb>
            <el-menu style="margin-left: auto">
              <el-sub-menu style="background-color: #d3dce6; height: 50px">
                <template #title>
                  {{ store.auth.user.username }}老师
                </template>
                <el-menu-item @click="logout()" style="background-color: #d3dce6">
                  退出登录
                </el-menu-item>
              </el-sub-menu>
            </el-menu>
          </el-container>
        </el-container>
        <el-divider style="margin-top: 0; stroke-dashoffset: 10px" />
      </el-header>
      <el-container style="height: auto;">
        <el-aside width="200px" style="height: 100%; background-color: #475669">
          <SideBar/>
        </el-aside>

        <el-container style="background-color: white">
          <el-main>
            <router-view>
            </router-view>
          </el-main>
          <el-footer>
            <el-affix position="bottom" offset="10px">
              <el-link :icon="Link" :href="'https://github.com/ZhangShuui/Cet-Site'">
                GitHub
              </el-link>
            </el-affix>
          </el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>


<script setup>
import {ref} from 'vue'
import {Link} from '@element-plus/icons-vue'

import {get} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";
import SideBar from "@/components/teacherIndex/sideBar.vue";

const store = useStore()


const logout = () => {
  get('/api/auth/logout', (message) => {
    ElMessage.success(message)
    store.auth.user = null
    router.push('/')
  })
}

</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);

}

.header-breadcrumb {
  margin-top: 16px;
  margin-left: 20px;
  font-size: 20px;
}
</style>




