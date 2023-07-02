<script setup>

import {onMounted, reactive} from "vue";
import {post} from "@/net";
import router from "@/router";
import {useStore} from "@/stores";
import {ElMessage} from "element-plus";

const store = useStore()

const examResult = reactive({
  list: []
})



const form = reactive({
  exam_id: '',
  start_time: '',
  score:-1,
  apply_time: '',
  test_id: '',
})

onMounted(()=> {
  post("/api/examinee/query-results", {
    user_id:store.auth.user.id
  }, (message) => {
    examResult.list = []
    for (let i in message){
      if (message[i].score === -1){
        message[i].score = "未评分"
      }
    }
    examResult.list.push(...message)


    console.log(examResult.list)
  }, () => {
    ElMessage.error("查询失败")
  })
})

const goback = () => {
  router.push('/index/queryresult')
}

const isShowReal = () => {

}

</script>

<template>
  <div style="font-size: 15px;margin-top: 10px; font-weight: bold">姓名: {{store.auth.user.username}}</div>
  <div style="font-size: 15px;margin-top: 10px; font-weight: bold">证件号码:{{store.auth.user.id}}</div>
  <div align=center>
    <el-table :data="examResult.list" border stripe style="width: 1100px;margin-top: 10px">
      <el-table-column  prop="exam_id" label="考试编号" width="180px" />
      <el-table-column  prop="start_time" label="考试时间" width="280px" />
      <el-table-column prop="score" label="笔试总分" width="180px" filter-method="filter"/>
      <el-table-column prop="test_id" label="试卷编号" width="180px" />
      <el-table-column prop="application_time" label="报名时间" width="280px" />
      <!--    <el-table-column prop="score" label="操作">-->
      <!--      <el-button @click="showDetail">查看详情</el-button>-->
      <!--    </el-table-column>-->
    </el-table>
    <el-button @click="goback" style="font-weight: bold; margin-top: 10px; width: 100px; height: 50px; background-color: dodgerblue;color: white">返回上一页</el-button>
  </div>

</template>

<style scoped>

</style>