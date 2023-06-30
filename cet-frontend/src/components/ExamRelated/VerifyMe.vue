<script setup >
import {reactive} from "vue";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import {useStore} from "@/stores";
import router from "@/router";
import { computed, ref } from 'vue'
import {
  Iphone,
Location,
    OfficeBuilding,
    Tickets,
    User,
} from '@element-plus/icons-vue'

const size = ref('')
const iconStyle = computed(() => {
  const marginMap = {
    large: '8px',
    default: '6px',
    small: '4px',
  }
  return {
    marginRight: marginMap[size.value] || marginMap.default,
  }
})
const blockMargin = computed(() => {
  const marginMap = {
    large: '32px',
    default: '28px',
    small: '24px',
  }
  return {
    marginTop: marginMap[size.value] || marginMap.default,
  }
})




const store = useStore()

const form = reactive({
  id: -1,
  email: '',
  username: '',
  exam_id: -1,
})

const VerifyMe = () => {
  get('/api/user/me', (message) => {
    form.id = message.id
    form.email = message.email
    form.username = message.username
  }, () => {
    ElMessage.error("获取用户信息出错")
  })
  get('/get-act-exam', (message) => {
    form.exam_id = message.exam_id
  },() => {
    ElMessage.error("当前无考试")
  })
  // post('/find-apply-info', {
  //   exam_id: form.exam_id,
  // }, (message) => {
  //
  // })
  post('/api/examinee/check-eligibility', {
    user_id:form.id,
    exam_id:form.exam_id,
  }, (message) => {
    ElMessage.success("检测到您具备考试资格,请进入考试")
  })
}

</script>

<template>
  <el-radio-group v-model="size">
    <el-radio label="large">Large</el-radio>
    <el-radio>Default</el-radio>
    <el-radio label="small">Small</el-radio>
  </el-radio-group>

  <el-descriptions
      class="margin-top"
      title="With border"
      :column="3"
      :size="size"
      border
  >
    <template #extra>
      <el-button type="primary">Operation</el-button>
    </template>
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <user />
          </el-icon>
          Username
        </div>
      </template>
      kooriookami
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <iphone />
          </el-icon>
          Telephone
        </div>
      </template>
      18100000000
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <location />
          </el-icon>
          Place
        </div>
      </template>
      Suzhou
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <tickets />
          </el-icon>
          Remarks
        </div>
      </template>
      <el-tag size="small">School</el-tag>
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div class="cell-item">
          <el-icon :style="iconStyle">
            <office-building />
          </el-icon>
          Address
        </div>
      </template>
      No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province
    </el-descriptions-item>
  </el-descriptions>

  <el-descriptions
      class="margin-top"
      title="Without border"
      :column="3"
      :size="size"
      :style="blockMargin"
  >
    <template #extra>
      <el-button type="primary">Operation</el-button>
    </template>
    <el-descriptions-item label="Username">kooriookami</el-descriptions-item>
    <el-descriptions-item label="Telephone">18100000000</el-descriptions-item>
    <el-descriptions-item label="Place">Suzhou</el-descriptions-item>
    <el-descriptions-item label="Remarks">
      <el-tag size="small">School</el-tag>
    </el-descriptions-item>
    <el-descriptions-item label="Address"
    >No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province
    </el-descriptions-item>
  </el-descriptions>
</template>


<style scoped>
.el-descriptions {
  margin-top: 20px;
}
.cell-item {
  display: flex;
  align-items: center;
}
.margin-top {
  margin-top: 20px;
}
</style>

