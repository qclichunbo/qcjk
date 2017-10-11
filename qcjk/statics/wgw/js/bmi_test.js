/**
 * Created by Kith-PC on 2016/10/27.
 */
//获取视口宽度和高度
function view(){
    return{
        w:document.documentElement.clientWidth,
        h:document.documentElement.clientHeight
    };
}
function bind(obj,ev,fn){
    if(obj.addEventListener){
        obj.addEventListener(ev,fn,false);
    }else{
        obj.attachEvent('on' + ev,function (){
            fn.call(obj);
        });
    }
}