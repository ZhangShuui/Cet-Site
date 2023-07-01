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

const test = () => {
  router.push('index/apply')
  console.log(router.currentRoute)
}


const verify = () => {
  router.push(('index/verifyme'))
  console.log(router.currentRoute)
}

const QueryResult = () =>{
  router.push(('index/queryresult'))
  console.log(router.currentRoute)
}


</script>



<template>
  <el-carousel :interval="4000" type="card" height="300px">
    <el-carousel-item style="width: auto">
      <img src="../../figs/testpost.png"/>
    </el-carousel-item>
    <el-carousel-item style="width: auto">
      <img src="../../figs/testknow.png"/>
    </el-carousel-item>
    <el-carousel-item style="width: auto">
      <img src="../../figs/teamwork.png">
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
              <el-button class="button" @click="router.push('index/projectInstruction')" text>详细信息</el-button>
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
              <el-text style="margin-right: auto">考试报名</el-text>
              <el-button class="button" @click="test" shadow="shadow">详细信息</el-button>
            </div>
          </template>
          <el-text>
            CET考试每年开考两次，分别于6月和12月举行，具体考试时间我中心将会在每年年初…
          </el-text>
        </el-card>
      </el-col>
      <el-col span="5">
        <el-card class="box-card">
          <template #header>
            <div class="card-header">
              <el-icon><Service/></el-icon>
              <el-text style="margin-right: auto">线上考试</el-text>
              <el-button class="button" @click="router.push('index/cetTestInfo')" text>详细信息</el-button>
            </div>
          </template>
          <el-text>
            CET线上考试每年开考两次，分别于5月和11月举行，具体考试时间我中心将会在每年年初…
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
                <el-button class="button" @click="verify">进入考试</el-button>
              </el-col>
              <el-col>
                <el-button class="button" @click="QueryResult">查询考试结果</el-button>
              </el-col>
            </el-row>
          </template>
        </el-card>
      </el-col>
    </el-space>
  </el-row>

</template>

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