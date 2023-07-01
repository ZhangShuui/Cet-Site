import { createRouter, createWebHistory } from 'vue-router'
import {useStore} from "@/stores";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'welcome',
      component: () => import('@/views/WelcomeView.vue'),
      children: [
        {
          path: '',
          name: 'welcome-login',
          component: () => import('@/components/welcome/LoginPage.vue')
        }, {
          path: 'register',
          name: 'welcome-register',
          component: () => import('@/components/welcome/RegisterPage.vue')
        }, {
          path: 'forget',
          name: 'welcome-forget',
          component: () => import('@/components/welcome/ForgetPage.vue')
        }
      ]
    }, {
      path: '/index',
      name: 'index',
      component: () => import('@/views/IndexView.vue'),
      children: [
        {
          path: '',
          name: 'stu-index',
          component: () => import('@/components/index/firstTab.vue')

        },
        {
          path: 'apply',
          name: 'stu-apply',
          component: () => import('@/components/apply/ApplyPage.vue')
        },
        {
          path:'verifyme',
          name:'verify-me',
          component:() => import('@/components/ExamRelated/VerifyMe.vue')
        },
        {
          path:'takeexam',
          name:'take-exam',
          component:() => import('@/components/ExamRelated/TakeExam.vue')
        },
        {
          path:'queryresult',
          name:'query-exam-result',
          component:() => import('@/components/ExamRelated/QueryResult.vue')
        }, {
          path:'showresult',
          name:'show-result',
          component:() => import('@/components/ExamRelated/ShowResult.vue')
        }
      ]
    },
    {
      path: '/teacher/index',
      name: "teacher-index",
      component: () => import('@/views/TeacherIndexView.vue'),
      children:[
        {
          path: 'createPaper',
          name: 'create-paper',
          component: () => import('@/components/paperCreate/createPaper.vue')
        },
        {
          path: 'applyInfo',
          name: 'apply-info',
          component: () => import('@/components/apply/ApplyInfoShow.vue')
        },
        {
          path: 'paperList',
          name: 'paper-list',
          component: () => import('@/components/paperCreate/paperList.vue')
        }
      ]
    }
  ]
})

router.beforeEach((to, from, next) => {
  const store = useStore()
  if(store.auth.user != null && to.name.startsWith('welcome-')) {
    if (store.auth.user.isStu === 1)
      next('/index')
    else
      next('/teacher/index')
  } else if(store.auth.user == null && to.fullPath.startsWith('/index')) {
    next('/')
  } else if(to.matched.length === 0){
    next('/index')
  } else {
    next()
  }
})

export default router
