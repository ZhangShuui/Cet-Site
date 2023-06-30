<template>
  <div class="common-layout">
    <el-container style="margin-left: 100px; margin-right: 100px; margin-top: 50px; min-height: 95vh">
      <el-header>
        <div >
          <el-menu
              class="el-menu-demo"
              mode="horizontal"
              :ellipsis="false"
              @select="handleSelect"
          >
            <el-image src="src/figs/cetlogo.png" style="width: 58px; height: 58px"/>
            <el-text style="margin-left: 10px; font-size: 18px">
              大学生六级考试
            </el-text>
            <div class="flex-grow" />
            <el-menu-item index="1">首页</el-menu-item>
            <el-menu-item index="2">联系我们</el-menu-item>
            <el-sub-menu index="3" style="width:fit-content">
              <template #title>{{ store.auth.user.username }}</template>
              <el-menu-item index="3-1" @click="logout()" >
                <span>退出登录</span>
              </el-menu-item>
              <el-menu-item index="3-2">个人信息</el-menu-item>
            </el-sub-menu>
          </el-menu>

        </div>
      </el-header>
      <el-main>
        <router-view>
        </router-view>
      </el-main>
      <el-footer >
        <el-affix position="bottom" offset="10px">
          <el-link :icon="Link" :href="'https://github.com/ZhangShuui/Cet-Site'">
            GitHub
          </el-link>
        </el-affix>
      </el-footer>
    </el-container>
  </div>
</template>


<script setup>
import {get} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";
import {ref} from 'vue'
import {Bell, EditPen, Link, Service} from "@element-plus/icons-vue";

const store = useStore()

const logout = () => {
  get('/api/auth/logout', (message) => {
    ElMessage.success(message)
    store.auth.user = null
    router.push('/')
  })
}

const handleSelect = (key) => {
  console.log(key)
}

const activeIndex = ref("1")
</script>

<style scoped>
.button {
  padding: 0;
  min-height: auto;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 275px;
  height: 200px;
}

.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}

.flex-grow {
  flex-grow: 1;
}

.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}


</style>