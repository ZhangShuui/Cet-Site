<template>
  <div class="common-layout">
    <el-container style="margin-left: 100px; margin-right: 100px; margin-top: 50px; min-height: 95vh">
      <el-header>
        <div >
          <el-menu
              :default-active="activeIndex"
              class="el-menu-demo"
              mode="horizontal"
              :ellipsis="false"
              @select="handleSelect"
          >
            <el-image src="src/figs/cetlogo.png" style="width: 58px; height: 58px"/>
            <el-text style="margin-left: 10px; font-size: 18px">
              大学生四、六级考试
            </el-text>
            <div class="flex-grow" />
            <el-menu-item index="1">首页</el-menu-item>
            <el-menu-item index="2">联系我们</el-menu-item>
            <el-sub-menu index="3">
              <template #title>{{ store.auth.user.username }}</template>
              <el-menu-item index="3-1" @click="logout()">退出登录</el-menu-item>
              <el-menu-item index="3-2">item two</el-menu-item>
              <el-menu-item index="3-3">item three</el-menu-item>
              <el-sub-menu index="3-4">
                <template #title>item four</template>
                <el-menu-item index="3-4-1">item one</el-menu-item>
                <el-menu-item index="3-4-2">item two</el-menu-item>
                <el-menu-item index="3-4-3">item three</el-menu-item>
              </el-sub-menu>
            </el-sub-menu>
          </el-menu>

        </div>
      </el-header>
      <el-main>
        <el-carousel :interval="4000" type="card" height="200px">
          <el-carousel-item v-for="item in 6" :key="item">
            <h3 text="2xl" justify="center">{{ item }}</h3>
          </el-carousel-item>
        </el-carousel>
        <el-row>
          <el-space wrap>
            <el-col span="5">
              <el-card class="box-card">
                <template #header>
                  <div class="card-header">
                    <el-icon><Bell/></el-icon>
                    <el-text style="margin-right: auto">项目简介</el-text>
                    <el-button class="button" text>详细信息</el-button>
                  </div>
                </template>
                <el-text>
                  全国大学英语四、六级考试(CET)系教育部主办、教育部教育考试院（原教育部考试中…
                </el-text>
              </el-card>
            </el-col>
            <el-col span="5">
              <el-card class="box-card">
                <template #header>
                  <div class="card-header">
                    <el-icon><EditPen /></el-icon>
                    <el-text style="margin-right: auto">笔试报名</el-text>
                    <el-button class="button" text>详细信息</el-button>
                  </div>
                </template>
                <el-text>
                  CET笔试每年开考两次，分别于6月和12月举行，具体考试时间我中心将会在每年年初…
                </el-text>
              </el-card>
            </el-col>
            <el-col span="5">
              <el-card class="box-card">
                <template #header>
                  <div class="card-header">
                    <el-icon><Service/></el-icon>
                    <el-text style="margin-right: auto">口试报名</el-text>
                    <el-button class="button" text>详细信息</el-button>
                  </div>
                </template>
                <el-text>
                  CET口试每年开考两次，分别于5月和11月举行，具体考试时间我中心将会在每年年初…
                </el-text>
              </el-card>
            </el-col>
            <el-col span="5">
              <el-card class="box-card">
                <template #header>
                  <div class="card-header">
                    <el-icon><Bell/></el-icon>
                    <el-text style="margin-right: auto">考生服务</el-text>
                  </div>
                </template>
                <template #default>
                  <el-row>
                    <el-col>
                      <el-button class="button" text>详细信息</el-button>
                    </el-col>
                    <el-col>
                      <el-button class="button" text>详细信息</el-button>
                    </el-col>
                  </el-row>
                </template>
              </el-card>
            </el-col>
          </el-space>
        </el-row>

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