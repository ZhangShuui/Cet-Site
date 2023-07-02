<template>
  <div style="margin-left: 30px">
    <el-text size="large" style="margin-bottom: 50px">
      <el-icon size="string" style="margin-right: 5px "><Bell/></el-icon><span style="font-size: 20px;font-weight: bold">答卷信息</span>
    </el-text>

    <el-table :data="answerForm.list"
              style="width: 200%; margin-top: 10px" >
      <el-table-column fixed prop="exam_id" label="考试编号"  />
      <el-table-column prop="user_id" label="考生编号" />
      <el-table-column prop="grading_status" label="是否完成阅卷" />
      <el-table-column fixed="right" label="操作" >
        <template v-slot="scope">
          <el-button link type="primary" @click="clickGrading(scope.$index)">开始阅卷</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script setup>

import {Bell, StarFilled} from "@element-plus/icons-vue";
import {useStore} from "@/stores";
import {onMounted, reactive, ref} from "vue";
import {ElMessage} from "element-plus";
import {get, post} from "@/net";
import router from "@/router";

const store = useStore();

const answerForm = reactive({
  list: []
})

const answerInfo = reactive({
  exam_id: -1,
  user_id: -1,
  grading_status: "",
})

const refreshData = () => {
  get("/api/examinee/answer-list", (message)=>{
    answerForm.list = []
    answerForm.list.push(...message);
    console.log(answerForm)
    router.push("/teacher/index/answerList");
  }, (message) => {
    console.log(message);
  })
}

onMounted(() => {
  refreshData()
})


const clickGrading = (scope) => {
  answerInfo.exam_id = answerForm.list[scope].exam_id;
  answerInfo.user_id = answerForm.list[scope].user_id;
  answerInfo.grading_status = answerForm.list[scope].grading_status;
  if (answerInfo.exam_id === -1 || answerInfo.user_id === -1){
    ElMessage.warning("请选择答卷")
  } else if(answerInfo.grading_status === "已完成"){
    ElMessage.warning("已完成阅卷");
  } else{
    post('/api/examinee/set-answer-id',{
      exam_id: answerInfo.exam_id,
      user_id: answerInfo.user_id,
      grading_status: answerInfo.grading_status
    },()=>{
      post('api/examinee/auto-grading',{
        exam_id: answerInfo.exam_id,
        user_id: answerInfo.user_id
      },()=>{
        ElMessage.success("已完成客观题自动阅卷");
        router.push("/teacher/index/gradePaper")
      },()=>{
        ElMessage.error("自动阅卷失败");
      })
    })
  }

}

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