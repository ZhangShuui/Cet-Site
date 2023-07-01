<script setup xmlns="http://www.w3.org/1999/html">

import router from "@/router";
</script>

<template>
  <el-card style="margin-left: 100px;margin-right: 100px">
    <template #header>
      <el-text style="font-size: larger; color: black">
        CET考试信息
      </el-text>
    </template>
    2023年上半年考试笔试及口试将分别于6月17日，5月20至21日举行，各地报名工作陆续启动。
    <br/>
    　　一、开考时间及科目
    <br/>
    　　1.笔试考试时间（6月17日）
    <br/>
    　　上午：英语四级、日语四级、德语四级、俄语四级、法语四级
    <br/>
    　　下午：英语六级、日语六级、德语六级、俄语六级
    <br/>
    　　2.口试考试时间（5月20-21日）
    <br/>
    　　5月20日：英语四级口语考试
    <br/>
    　　5月21日：英语六级口语考试
    <br/>
    　　二、报名方式
    <br/>
    　　请考生按所在学校规定时间登录CET全国网上报名系统（cet-bm.neea.edu.cn）完成资格审核、笔试报名缴费及口试报名缴费。
    <br/>
    　　三、成绩报告单
    <br/>
    　　成绩发布10个工作日后，考生可登录中国教育考试网（www.neea.edu.cn）查看并下载电子成绩报告单（小语种科目为电子证书），电子成绩报告单与纸质成绩报告单同等效力。
    <br/>
    　　纸质成绩报告单依申请发放，考生可在报名期间或成绩发布后规定时间内登录CET报名网站（cet-bm.neea.edu.cn）自主选择是否需要纸质成绩报告单，选择纸质的考生应按考点规定时间及地点免费领取，成绩发布半年后未领取的视为自动放弃，不再补发。
  </el-card>
  <el-divider style="visibility: hidden"/>
  <div align="center">
    <el-button size="large" @click="router.push('/index')">
      返回
    </el-button>
  </div>

</template>

<style scoped>

</style>