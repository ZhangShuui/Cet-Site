<template>
  <el-card>
    <el-icon><User></User></el-icon>
    学生报考信息一览
  </el-card>
  <el-table :data="applyFormInfo.list" style="width: 100%" stripe>
    <el-table-column label="考试编号" prop="exam_id"/>
    <el-table-column label="用户编号" prop="user_id" />
    <el-table-column label="试题编号" prop="test_id" />
    <el-table-column label="申请时间" prop="application_time" />
    <el-table-column label="支付状态" prop="payment_status" />
    <el-table-column align="right">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index)">
          Edit
        </el-button>
        <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index)">
          Delete
        </el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-divider style="visibility: hidden"/>
  <div align="center">
    <el-row gutter="50">
      <el-col span="12">
        <el-card>
          <template #header><span>查询考试信息</span></template>
          <el-col>
            <el-text style="margin-right: 5px">考试编号</el-text>
            <el-input v-model="searchExamId" size="small" placeholder="e_id" style="width: auto" />
          </el-col>
          <el-col style="margin-top: 10px">
            <el-text style="margin-right: 5px">用户编号</el-text>
            <el-input v-model="searchUserId" size="small" placeholder="u_id" style="width: auto"/>
          </el-col>

          <el-button type="primary" size="small" @click="handleSearch()" style="margin-top: 10px;float: right;margin-bottom: 10px">search</el-button>
        </el-card>
      </el-col>
      <el-col span="12">
        <el-card>
          <template #header><span>添加考试信息</span></template>
          <el-col>
            <el-text style="margin-right: 5px">考试编号</el-text>
            <el-input v-model="addExamId" size="small" placeholder="e_id" style="width: auto"/>
          </el-col>
          <el-col style="margin-top: 10px">
            <el-text style="margin-right: 5px">用户编号</el-text>
            <el-input v-model="addUserId" size="small" placeholder="u_id" style="width: auto"/>
          </el-col>

          <el-button type="primary" size="small" @click="handleAdd()" style="margin-top: 10px;float: right;margin-bottom: 10px">add</el-button>
        </el-card>
      </el-col>
    </el-row>
  </div>



  <el-dialog v-model="dialogFormVisible" title="修改报考信息">
    <el-form :model="editForm">
      <el-form-item label="考试编号">
        <el-input v-model="editForm.exam_id" autocomplete="off" />
      </el-form-item>
      <el-form-item label="用户编号">
        <el-input v-model="editForm.user_id" autocomplete="off" />
      </el-form-item>
      <el-form-item label="支付状态">
        <el-input v-model="editForm.payment_status" autocomplete="off" />
      </el-form-item>
      <el-form-item label="试题编号">
        <el-input v-model="editForm.test_id" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="handleEditSubmit">
          Confirm
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import {onMounted, reactive, ref} from 'vue'
import {User} from "@element-plus/icons-vue";
import {useStore} from "@/stores";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";

const store = useStore();


const searchExamId = ref(-1)
const searchUserId = ref(-1)

const addExamId = ref(-1)
const addUserId = ref(-1)

const applyFormInfo = reactive({
  list: []
})



const editForm = reactive({
  exam_id: -1,
  user_id: -1,
  payment_status: "",
  test_id: -1
})




const handleEdit = (index) => {
  editForm.exam_id = applyFormInfo.list[index].exam_id;
  editForm.user_id = applyFormInfo.list[index].user_id;
  editForm.test_id = applyFormInfo.list[index].test_id;
  editForm.payment_status = applyFormInfo.list[index].payment_status;
  dialogFormVisible.value = true
}


const handleEditSubmit = () => {
  if (editForm.exam_id !== -1
      &&editForm.user_id !== -1){
    post("api/apply/update-apply-info", {
      exam_id: editForm.exam_id,
      user_id: editForm.user_id,
      payment_status: editForm.payment_status,
      test_id: editForm.test_id
    }, (message) => {
      ElMessage.success(message);
      reFreshData();
      dialogFormVisible.value =false;
    })
  }
}

const handleDelete = (index) => {
  post("api/apply/delete-apply-info", {
    exam_id: applyFormInfo.list[index].exam_id,
    user_id: applyFormInfo.list[index].user_id
  }, (message) => {
    ElMessage.success(message);
    reFreshData()
  }, (message) => {
    ElMessage.warning(message)
  })
}

const handleSearch = () => {
  console.log(searchExamId.value)
  console.log(searchUserId)
  post("api/apply/find-apply-info", {
    exam_id: searchExamId.value,
    user_id: searchUserId.value
  },(message) => {
    applyFormInfo.list = []
    applyFormInfo.list.push(...message)
    ElMessage.success("查询信息成功")
  }, (message) => {
    ElMessage.warning("查询信息失败")
  })
}

const handleAdd = () => {
  post("api/apply/apply-for-test-back", {
    exam_id: addExamId.value,
    user_id: addUserId.value
  }, (message) => {
    ElMessage.success(message);
    reFreshData();
  }, (message) => {
    ElMessage.warning(message)
  })
}

onMounted(() => {
  reFreshData();
  ElMessage.success("获取报考信息成功")
})

const reFreshData = () => {
  get("api/apply/all-apply-info", (message) => {
    applyFormInfo.list = []
    applyFormInfo.list = message;
    console.log(applyFormInfo.list);
  }, (message) => {
    ElMessage.warning(message)
  })
}

const dialogFormVisible = ref(false)
const formLabelWidth = '140px'

</script>


<style scoped>
.el-button--text {
  margin-right: 15px;
}
.el-select {
  width: 300px;
}
.el-input {
  width: 300px;
}
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>