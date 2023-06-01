<template>
  <div>
    <el-row>
      <el-col span="4">
        <h5 class="mb-2">Default colors</h5>
        <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
        >
          <el-sub-menu index="1">
            <template #title>
              <el-icon>
                <location/>
              </el-icon>
              <span>Navigator One</span>
            </template>
            <el-menu-item-group title="Group One">
              <el-menu-item index="1-1">item one</el-menu-item>
              <el-menu-item index="1-2">item two</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group Two">
              <el-menu-item index="1-3">item three</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>item four</template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="2">
            <el-icon>
              <icon-menu/>
            </el-icon>
            <span>Navigator Two</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <el-icon>
              <document/>
            </el-icon>
            <span>Navigator Three</span>
          </el-menu-item>
          <el-menu-item index="4">
            <el-icon>
              <setting/>
            </el-icon>
            <span>Navigator Four</span>
          </el-menu-item>
        </el-menu>
      </el-col>
      <!-- SubMenu -->
      <el-col span="18">
        <div class="layout-main" :class="{ 'is-collapse': collapse }">
          <!-- Header -->
          <div class="app-main-container">
            <!-- Main -->
            <!--            <LayoutMain />-->
            <!--            &lt;!&ndash; Footer &ndash;&gt;-->
            <!--            <LayoutFooter />-->
            <div>
              欢迎{{ store.auth.user.username }}老师进入到学习平台
            </div>
            <div>
              <el-button @click="logout()" type="danger" plain>退出登录</el-button>
            </div>
          </div>
        </div>
      </el-col>

    </el-row>
  </div>

</template>

<script setup>
import {get} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";

const store = useStore()
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

const logout = () => {
  get('/api/auth/logout', (message) => {
    ElMessage.success(message)
    store.auth.user = null
    router.push('/')
  })
}
</script>

<style scoped>

</style>