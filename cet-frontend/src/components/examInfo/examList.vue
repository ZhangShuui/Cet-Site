<template>
  <div style="margin-left: 30px">
    <el-text size="large" style="margin-bottom: 50px">
      <el-icon size="string" style="margin-right: 5px "><Bell/></el-icon><span style="font-size: 20px;font-weight: bold">考试信息</span>
    </el-text>

    <el-table :data="examForm.list"
              style="width: 200%; margin-top: 10px" >
      <el-table-column fixed prop="exam_id" label="考试编号"  />
      <el-table-column prop="start_time" label="考试时间" width="340px"/>
      <el-table-column prop="test_id" label="试题编号" />
      <el-table-column fixed="right" label="操作" >
        <template v-slot="scope">
          <el-button type="danger" size="small" @click="clickDelete(scope.$index)" round >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>



</template>

<script setup>

import {Bell} from "@element-plus/icons-vue";
import {useStore} from "@/stores";
import {onMounted, reactive, ref} from "vue";
import {ElMessage} from "element-plus";
import {get, post} from "@/net";
import router from "@/router";

const store = useStore();

const examForm = reactive({
  list: []
})

const examInfo = reactive({
  exam_id: -1,
  test_id:-1,
})

const refreshData = () => {
  get("/api/examinfo/exam-list", (message)=>{
    examForm.list = []
    examForm.list.push(...message);
    console.log(examForm)
    router.push("/teacher/index/examList");
  }, (message) => {
    console.log(message);
  })
}

onMounted(() => {
  refreshData()
})


const clickDelete = (scope) => {
  examInfo.exam_id = examForm.list[scope].exam_id;
  examInfo.test_id = examForm.list[scope].test_id;
  if (examInfo.exam_id === -1 || examInfo.test_id === -1){
    ElMessage.warning("请选择考试")
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