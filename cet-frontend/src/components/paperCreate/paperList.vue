<template>
  <div style="margin-left: 30px">
    <el-text size="large" style="margin-bottom: 50px">
      <el-icon size="string" style="margin-right: 6px "><Edit/></el-icon><span style="font-size: 20px;font-weight: bold">试题信息</span>
    </el-text>
    <el-table :data="paperForm.list"
              style="width: 100%; margin-top: 10px" stripe>
      <el-table-column fixed prop="test_id" label="试题编号" />
      <el-table-column fixed="right" label="操作">
        <template v-slot="scope">
          <el-button link type="primary"  @click="clickPreview(scope.$index)">查看</el-button>
          <el-button link type="primary" @click="clickDelete(scope.$index)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <div style="margin-top: 50px" align="center">
    <el-button type="primary" @click="onAddPaper">添加试卷</el-button>
  </div>

</template>

<script setup>

import {Edit} from "@element-plus/icons-vue";
import {useStore} from "@/stores";
import {onMounted, reactive, ref} from "vue";
import {ElMessage} from "element-plus";
import {get, post} from "@/net";
import router from "@/router";

const store = useStore();

const paperForm = reactive({
  list: []
})

const paperInfo = reactive({
  test_id: -1,
})

const refreshData = () => {
  get("/api/paper/paper-list", (message)=>{
    paperForm.list = []
    paperForm.list.push(...message);
    console.log(paperForm)
    router.push("/teacher/index/paperList");
  }, (message) => {
    console.log(message);
  })
}

onMounted(() => {
  refreshData()
})


const clickPreview = (scope) => {
  paperInfo.test_id = paperForm.list[scope].test_id;
  if (paperInfo.test_id === -1){
    ElMessage.warning("请选择试题")
  } else {
    post('/api/paper/set-preview-id',{
      test_id: paperInfo.test_id
    },()=>{
      // router
      router.push("/teacher/index/showPaper")
    })
  }

}

const clickDelete = (scope) =>{
  paperInfo.test_id = paperForm.list[scope].test_id;
  if (paperInfo.test_id === -1){
    ElMessage.warning("请选择试题")
  } else {
    post('/api/paper/delete-paper',{
      test_id: paperInfo.test_id
    },(message)=>{
      ElMessage.success(message);
      refreshData();
    },(message)=>{
      ElMessage.error(message);
      refreshData();
    })
  }
}

const onAddPaper =()=>{
  router.push("/teacher/index/createPaper");
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