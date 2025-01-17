import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  let timer:any=null;
  let t_remain:number=0
  let t_total:number=-1
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment,timer,t_remain,t_total }
})
