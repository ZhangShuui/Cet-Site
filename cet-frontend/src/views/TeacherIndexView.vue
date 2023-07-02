<template>
  <div class="common-layout">
    <el-container style="height: 100vh">
      <el-aside width="200px" style="height: 100%; background-color: #475669">
        <SideBar/>
      </el-aside>
      <el-container style="height: auto; background-color: white">
        <el-header height="45px" style="background-color: #606266; margin-left: 0px" >
          <el-container direction="horizontal" style="height:44px ;background-color: white; margin-left: 0px">
              <el-breadcrumb separator="/" class="header-breadcrumb">
                <el-breadcrumb-item>teacher</el-breadcrumb-item>
                <el-breadcrumb-item>
                  <a href="/teacher/index">
                    index
                  </a>
                </el-breadcrumb-item>
              </el-breadcrumb>
              <el-menu style="height:44px; margin-left: auto">
                <el-sub-menu style="background-color: #d3dce6; height: 44px">
                  <template #title>
                    {{ store.auth.user.username }}老师
                  </template>
                  <el-menu-item @click="logout()" style="height: 44px; background-color: #d3dce6">
                    退出登录
                  </el-menu-item>
                </el-sub-menu>
              </el-menu>
          </el-container>
          <el-divider style="margin-top: 0; stroke-dashoffset: 10px" />
        </el-header>
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
  font-size: 15px;
}
</style>




