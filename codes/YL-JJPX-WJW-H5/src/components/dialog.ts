import { createApp } from 'vue'
import msg from "./dialog.vue";


interface Obj{
    showMask: boolean,
    msg: string,
    cancel: string,
    confirm: string,
    delay: number
}
export const createMount = (opts?: Obj)=>{
    let app;
    let el = document.getElementById('show_mask_msg');
    if(el)return null
    const div = document.createElement('div')
    div.setAttribute('id', 'show_mask_msg')
    document.body.appendChild(div)
    app =  createApp(msg, { ...opts })
    let $el = app.mount(div).$el;
    return $el;
}



