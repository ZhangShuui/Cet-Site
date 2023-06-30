<template>
  <el-text size="large" style="margin-bottom: 50px">
      <el-icon size="string" style="margin-right: 5px"><Bell/></el-icon><span>待报考的考试</span>
  </el-text>
  <el-table :data="tableData" style="width: 100%; margin-top: 10px">
    <el-table-column fixed prop="date" label="考试编号" width="250" />
    <el-table-column prop="date" label="考试日期" width="250" />
    <el-table-column prop="name" label="报考截止" width="250" />
    <el-table-column fixed="right" label="操作" width="250">
      <template #default>
        <el-button link type="primary" >报考</el-button>
      </template>
    </el-table-column>
  </el-table>



  <el-divider style="visibility: hidden"></el-divider>

  <el-text size="large" style="margin-bottom: 50px">
    <el-icon size="string" style="margin-right: 5px"><Bell/></el-icon><span>已报考的考试</span>
  </el-text>

  <el-table :data="tableData" style="width: 100%; margin-top: 10px">
    <el-table-column fixed prop="date" label="考试编号" width="250" />
    <el-table-column prop="date" label="考试日期" width="250" />
    <el-table-column prop="name" label="报考截止" width="250" />
    <el-table-column fixed="right" label="操作">
      <template v-slot="scope">
        <el-button link type="primary" @click="clickApply(scope.$index)">退考</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>

import {Bell, StarFilled} from "@element-plus/icons-vue";
import {useStore} from "@/stores";
import {reactive} from "vue";
import {ElMessage} from "element-plus";
import {post} from "@/net";

const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    zip: 'CA 90036',
    tag: 'Home',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    zip: 'CA 90036',
    tag: 'Office',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    zip: 'CA 90036',
    tag: 'Home',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    zip: 'CA 90036',
    tag: 'Office',
  },
]
const applyForm = reactive({
  user_id: useStore.$id,
  exam_id: -1,
})

const quitForm = reactive({
  user_id: useStore.$id,
  exam_id: -1,
})

const clickApply = (scope) => {
  console.info(tableData[scope].date)
}

const applyForTest = () => {
  if (applyForm.exam_id === -1){
    ElMessage.warning("请选择考试进行报考")
  } else {
    post('/api/apply/apply-for-test', {
      user_id: applyForm.user_id,
      exam_id: applyForm.exam_id
    }, (message) => {
      if (message.success){
        ElMessage.success(message)
      }else {
        ElMessage.warning("报考失败，请选择其他考试报考")
      }
    })
  }
}

const quitTest = () => {
  if (applyForm.exam_id === -1){
    ElMessage.warning("请选择考试进行退考")
  }else {
    post('/api/apply/delete-apply-info', {
      user_id: quitForm.user_id,
      exam_id: quitForm.exam_id
    }, (message) => {
      if (message.success){
        ElMessage.success(message)
      }else {
        ElMessage.warning("退考失败，请选择其他考试退考")
      }
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