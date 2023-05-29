/**
 * 登录
 */
$(function(){
     layui.use(['form' ,'layer'], function() {
         var form = layui.form;
         var layer = layui.layer;
         form.on("submit(login)",function () {
             login();
             return false;
         });
         var path=window.location.href;
         if(path.indexOf("kickout")>0){
             layer.alert("您的账号已在别处登录；若不是您本人操作，请立即修改密码！",function(){
                 window.location.href="/login";
             });
         }
     })
 })

function login(){
    var username=$("#username").val();
    var password=$("#password").val();
    var rememberMe = $("#rememberMe").val();
    var data = $("#useLogin").serializeJSON();
    $.ajax({
        type: "POST",
        dataType: "json",
        data: JSON.stringify(data),
        contentType: 'application/json',
        url: "/authentication",
        success: function (data) {
            localStorage.setItem('token', data.token);
            window.location.href = "/home";
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
            });
        }
    });
}
