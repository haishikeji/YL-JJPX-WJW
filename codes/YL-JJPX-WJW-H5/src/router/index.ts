import {
  createRouter,
  createWebHistory,
  createWebHashHistory,
} from "vue-router";
import Index from "../views/index.vue";
import { componentRouter } from "./compoent";

const router = createRouter({
  history: createWebHashHistory("/"),
  routes: [
    {
      path: "/",
      name: "index",
      component: Index,
      meta: { title: "急救培训管理系统" },
    },
    {
      path: "/my",
      name: "my",
      component: () => import("../views/my.vue"),
      meta: { title: "急救培训管理系统" },
    },
    {
      path: "/studyLaw",
      name: "studyLaw",
      component: () => import("../views/studyLaw.vue"),
      meta: { title: "学习列表" },
    },
    {
      path: "/test",
      name: "test",
      component: () => import("../views/ctest.vue"),
      meta: { title: "考试" },
    },
    {
      path: "/csign",
      name: "csign",
      component: () => import("../views/csign.vue"),
      meta: { title: "救在身边急救知识培训", all: true },
    },
    {
      path: "/cdes",
      name: "cdes",
      component: () => import("../views/cdes.vue"),
      meta: { title: "开始考试", all: true },
    },
    {
      path: "/list",
      name: "list",
      component: () => import("../views/list.vue"),
      meta: { title: "考题" },
    },
    {
      path: "/score",
      name: "score",
      component: () => import("../views/score.vue"),
      meta: { title: "分数" },
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../views/login.vue"),
      meta: { title: "急救培训管理系统" },
    },
    {
      path: "/pwd",
      name: "pwd",
      component: () => import("../views/pwd.vue"),
      meta: { title: "急救培训管理系统" },
    },
    {
      path: "/ana",
      name: "ana",
      component: () => import("../views/analysis.vue"),
      meta: { title: "考试记录" },
    },
    {
      path: "/alist",
      name: "alist",
      component: () => import("../views/alist.vue"),
      meta: { title: "题目解析" },
    },
    {
      path: "/test",
      name: "test",
      component: () => import("../views/test.vue"),
      meta: { title: "测试" },
    },
    {
      path: "/studyLawdetail",
      name: "studyLawdetail",
      component: () => import("../views/studyLawdetail.vue"),
      meta: { title: "学习详情" },
    },
    {
      path: "/scanCodeExam",
      name: "scanCodeExam",
      component: () => import("../views/scanCodeExam.vue"),
      meta: { title: "现场考试" },
    },
    {
      path: "/cdess",
      name: "cdess",
      component: () => import("../views/cdess.vue"),
      meta: { title: "全民现场考试" },
    },
    ...componentRouter,
  ],
});
router.beforeEach(async (to, from) => {
  let _c_z_t = window.localStorage.getItem("_c_z_t");
  const all = ["login", "csign", "ana", "scanCodeExam"];
  if (to.meta.title) {
    document.title = to.meta.title as string;
  }
  if (!all.includes(to.name as string) && !_c_z_t?.trim()) {
    return { path: "/login", replace: true, query: { fullpath: to.fullPath } };
    // return { path: '/login', replace: true}
  }
  return;
});

export default router;
