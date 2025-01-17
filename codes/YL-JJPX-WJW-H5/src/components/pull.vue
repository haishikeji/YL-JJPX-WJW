<script lang="ts" setup>
const loading = defineProps(['loading'])
const emit = defineEmits(['handler'])
function handler(){
    emit('handler')
}

</script>
<template>
    <div class="nodeobserber">
        <slot />
        <div v-if="loading" v-scroll='{handler}' class="sentinels isLoadMore">{{ loading.loading }}</div>
    </div>
</template>
<style lang="less" scoped> 
.isLoadMore{
    padding: 20px 0;
    text-align: center;
}
</style>