<script setup>

import {reactive} from "vue";
import {useStore} from "@/stores";
import {post} from "@/net";
import router from "@/router";


const store = useStore()

const query = () => {
  post("/api/examinee/query-results", {
    user_id:store.auth.user.id
  }, (message) => {
    ElMessage.success("查询成功")
    router.push('/index/showresult')
  }, () => {
    ElMessage.error("查询失败")
  })
}

</script>

<template>
  <div align="center">
    <el-card style="align-self: center;width:500px; margin-top: 50px" >
      <template #header>
        <div class="card-header">
          <span style="font-size: 40px; font-weight: bold">全国大学英语六级考试历史成绩查询</span>
        </div>
      </template>
        <el-text>注册在线报名系统账号，查询2005年6月及以后考试成绩，下载2021年6月及以后考试电子成绩报告单（证书）。</el-text>
        <div style="margin-top: 20px">
          <el-button @click="query" style="height: 40px; width: 100px; background-color: darkseagreen; color: white;font-weight: bold;font-size: 16px">确认查询</el-button>
        </div>
    </el-card>
  </div>

</template>

<style>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

</style>
