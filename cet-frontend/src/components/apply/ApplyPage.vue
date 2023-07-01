<template>
  <el-text size="large" style="margin-bottom: 50px">
      <el-icon size="string" style="margin-right: 5px"><Bell/></el-icon><span>待报考的考试</span>
  </el-text>
  <el-table :data="applyForm" style="width: 100%; margin-top: 10px" key="itemKey.v">
    <el-table-column fixed prop="exam_id" label="考试编号" width="250" />
    <el-table-column prop="start_time" label="考试日期" width="250" />
    <el-table-column prop="ddl" label="报考截止" width="250" />
    <el-table-column fixed="right" label="操作" width="250">
      <template v-slot="scope">
        <el-button link type="primary" @click="clickApply(scope.$index)">报考</el-button>
      </template>
    </el-table-column>
  </el-table>



  <el-divider style="visibility: hidden"></el-divider>

  <el-text size="large" style="margin-bottom: 50px">
    <el-icon size="string" style="margin-right: 5px"><Bell/></el-icon><span>已报考的考试</span>
  </el-text>

  <el-table :data="quitForm" style="width: 100%; margin-top: 10px">
    <el-table-column fixed prop="exam_id" label="考试编号" width="250" />
    <el-table-column prop="start_time" label="考试日期" width="250" />
    <el-table-column prop="" label="支付状态" width="200"/>
    <el-table-column prop="ddl" label="退考截止" width="250" />

    <el-table-column label="操作">
      <template v-slot="scope">
        <el-button link type="primary" @click="clickQuit(scope.$index)">退考</el-button>
        <el-button link type="primary">支付</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>

import {Bell, StarFilled} from "@element-plus/icons-vue";
import {useStore} from "@/stores";
import {onMounted, reactive, ref} from "vue";
import {ElMessage} from "element-plus";
import {get, post} from "@/net";

const store = useStore();
const itemKey = ref({v: Math.random()});
const tableData = [
  {
    exam_id: 1,
    test_date: "2023-10-23",
    ddl: "",
  },
]
const applyForm = reactive(
  [])

const quitForm = reactive(
    [])

const applyInfo = ref({
  user_id: store.auth.user.id,
  exam_id: -1,
})

const quitInfo = ref({
  user_id: store.auth.user.id,
  exam_id: -1,
})

const refreshData = () => {
  post("/api/examinfo/test/canTake", {
    user_id: store.auth.user.id
  }, (message) => {
    console.log(store.auth.user)
    console.log(message);
    applyForm.value = []
    applyForm.push(...message);
    // console.log(applyForm)
    post("api/examinfo/test/canQuit", {
      user_id: store.auth.user.id
    }, (message) => {
      console.log(message);
      quitForm.value = []
      quitForm.push(...message);
      itemKey.v = Math.random();
    }, (message) => {
      console.log(message);
    })
  }, (message) => {
    console.log(message);
  })
}

onMounted(() => {
  refreshData()
})


const clickApply = (scope) => {
  //console.info(tableData[scope].date)
  applyInfo.exam_id = applyForm[scope].exam_id
  applyForTest()
}

const clickQuit = (scope) => {
  //console.info(tableData[scope].date)
  quitInfo.exam_id = quitForm[scope].exam_id
  quitTest()
}

const applyForTest = () => {
  if (applyInfo.exam_id === -1){
    ElMessage.warning("请选择考试进行报考")
  } else {
    post('/api/apply/apply-for-test', {
      user_id: store.auth.user.id,
      exam_id: applyInfo.exam_id
    }, (message) => {
      ElMessage.success(message);
      refreshData()
    })
  }
}

const quitTest = () => {
  if (quitInfo.exam_id === -1){
    ElMessage.warning("请选择考试进行退考")
  }else {
    post('/api/apply/delete-apply-info', {
      user_id: store.auth.user.id,
      exam_id: quitInfo.exam_id
    }, (message) => {
      ElMessage.success(message)
      refreshData()
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