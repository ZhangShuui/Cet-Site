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

  <div style="margin-top: 50px" align="center">
    <el-button type="primary" @click="onAddExam">添加考试</el-button>
  </div>

  <el-dialog v-model="dialogFormVisible" title="Shipping address">
    <el-form :model="addExamForm">
      <el-form-item label="请选择考试开始日期">
        <el-calendar v-model="addExamForm.start_time">
          <template #date-cell="{ data }">
            <p :class="data.isSelected ? 'is-selected' : ''">
              {{ data.day.split('-').slice(1).join('-') }}
              {{ data.isSelected ? '✔️' : '' }}
            </p>
          </template>
        </el-calendar>
      </el-form-item>
      <el-form-item label="请选择试题编号">
        <el-select v-model="addExamForm.test_id" placeholder="Please select a zone">
          <el-option
              v-for="item in testIdOption.list"
              :key="item.test_id"
              :value="item.test_id"
          />
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="submitAdd">
          Confirm
        </el-button>
      </span>
    </template>
  </el-dialog>

</template>

<script setup>

import {Bell} from "@element-plus/icons-vue";
import {useStore} from "@/stores";
import {onMounted, reactive, ref} from "vue";
import {ElMessage} from "element-plus";
import {get, post} from "@/net";
import router from "@/router";
import {formattedDate} from '@/format'

const dialogFormVisible = ref(false);

const addExamForm = reactive({
  start_time: "",
  test_id: null
})





const store = useStore();

const examForm = reactive({
  list: []
})

const testIdOption = reactive({
  list: []
})

const examInfo = reactive({
  exam_id: -1,
  test_id:-1,
})

const refreshData = () => {
  get("/api/examinfo/exam-list", (message)=>{
    examForm.list = []
    for (let i in message){
      message[i].start_time = formattedDate(message[i].start_time)
    }
    examForm.list.push(...message);
    console.log(examForm)
    router.push("/teacher/index/examList");
  }, (message) => {
    console.log(message);
  })
}

const getOption = () => {
  get("api/paper/paper-list", (message) => {
    testIdOption.list = []
    console.log("sdsdasd")
    console.log(message)
    testIdOption.list.push(...message)
    console.log(testIdOption.list)
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
  } else {
    post('/api/examinfo/delete-exam',{
      exam_id: examInfo.exam_id,
    },()=>{
      ElMessage.success("删除考试信息成功");
      refreshData();
    },()=>{
      ElMessage.error("删除考试失败");
      refreshData();
    })
  }
}

const submitAdd = () => {
  console.log(addExamForm)
  if (addExamForm.test_id === null || addExamForm.start_time === ""){
    ElMessage.warning("请填写正确考试信息再添加考试")
  }else {
    post("api/examinfo/add-exam-info",{
      start_time: addExamForm.start_time,
      test_id: addExamForm.test_id
    }, (message)=>{
      ElMessage.success(message)
      refreshData()
      dialogFormVisible.value = false;
    }, (message) => {
      ElMessage.warning(message)
    })
  }
}

const onAddExam = () => {
  getOption()
  dialogFormVisible.value = true;
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

.is-selected {
  color: #1989fa;
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