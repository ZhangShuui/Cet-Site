<template>
  <div style="margin-left: 30px">
    <el-text size="large" style="margin-bottom: 50px">
      <el-icon size="string" style="margin-right: 5px "><Bell/></el-icon><span style="font-size: 20px;font-weight: bold">考试信息</span>
    </el-text>

    <el-table :data="teacherForm.list"
              style="width: 200%; margin-top: 10px" >
      <el-table-column fixed prop="id" label="用户号"  />
      <el-table-column prop="name" label="教师姓名" width="340px"/>
      <el-table-column prop="teacher_id" label="教师编号" />
      <el-table-column fixed="right" label="操作" >
        <template v-slot="scope">
          <el-button type="danger" size="small" @click="clickDelete(scope.$index)" round >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <div style="margin-top: 50px" align="center">
    <el-button type="primary" @click="onAddTeacher">添加教师信息</el-button>
  </div>

  <el-dialog v-model="dialogFormVisible" title="添加教师信息">
    <el-form :model="addteacherForm">
      <el-form-item label="请输入教师姓名">
        <el-input v-model="addteacherForm.name"/>
      </el-form-item>
      <el-form-item label="请输入六位大写字母构成的教师编号">
        <el-input v-model="addteacherForm.teacher_id" />
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

const addteacherForm = reactive({
  name: "",
  teacher_id: null
})





const store = useStore();

const teacherForm = reactive({
  list: []
})

const testIdOption = reactive({
  list: []
})

const teacherDInfo = reactive({
  id: -1,
})

const refreshData = () => {
  get("/api/teacher/get-all-teacher-info", (message)=>{
    teacherForm.list = []
    teacherForm.list.push(...message);
    console.log(teacherForm)
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

const validateID = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请输入教师编号'))
  } else if(!/^[a-zA-Z]+$/.test(value)){
    callback(new Error('教师编号只能由大小写英文组成'))
  } else {
    callback()
  }
}


const clickDelete = (scope) => {
  teacherDInfo.id = teacherForm.list[scope].id;
  if (teacherDInfo.id === null){
    ElMessage.warning("请选择教师信息")
  } else {
    post('/api/teacher/delete-teacher-info',{
      id: teacherDInfo.id,
    },()=>{
      ElMessage.success("删除教师信息成功");
      refreshData();
    },()=>{
      ElMessage.error("删除教师信息失败");
      refreshData();
    })
  }
}

const submitAdd = () => {
  console.log(addteacherForm)
  if (addteacherForm.name === null || addteacherForm.teacher_id === ""){
    ElMessage.warning("请填写正确教师信息再添加")
  }else {
    post("api/teacher/add-teacher-info",{
      teacher_id: addteacherForm.teacher_id,
      name: addteacherForm.name
    }, (message)=>{
      ElMessage.success(message)
      refreshData()
      dialogFormVisible.value = false;
    }, (message) => {
      ElMessage.warning(message)
    })
  }
}

const onAddTeacher = () => {
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