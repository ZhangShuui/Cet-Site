<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <div>
          欢迎{{ store.auth.user.username }}进入到学习平台
        </div>
        <div>
          <el-button @click="logout()" type="danger" plain>退出登录</el-button>
        </div>
      </el-header>
      <el-main>
        <el-row>
          <el-col
              v-for="(o, index) in 2"
              :key="o"
              :span="8"
              :offset="index > 0 ? 2 : 0"
          >
            <el-card :body-style="{ padding: '0px' }">
              <img
                  src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                  class="image"
              />
              <div style="padding: 14px">
                <span>Yummy hamburger</span>
                <div class="bottom">
                  <time class="time">{{ currentDate }}</time>
                  <el-button text class="button">Operating</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>


<script setup>
import {get} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";
import {ref} from 'vue'

const currentDate = ref(new Date())
const store = useStore()

const logout = () => {
  get('/api/auth/logout', (message) => {
    ElMessage.success(message)
    store.auth.user = null
    router.push('/')
  })
}
</script>

<style scoped>
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}
</style>