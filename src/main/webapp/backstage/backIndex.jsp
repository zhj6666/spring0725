<!DOCTYPE html>
<html>
<head>
    <base href="http://localhost:8080/spring0725/"></base>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${userInfo.userName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="nav" id="nav">
               <!-- <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>-->
            </ul>
        </div>
    </div>

    <div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
        <ul class="layui-tab-title">
        </ul>
        <!-- 内容主体区域 -->
        <div style="padding: 15px;"  class="layui-tab-content">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var $=layui.$;
        var element = layui.element;
        $.ajax( {
            url : "menu",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                var menu = "";
                for(var i = 0;i<data.length;i++){
                    menu += "<li class='layui-nav-item '>"
                    if(data[i].perType == 0){
                        menu +=        "<a href='javascript:;'>"+data[i].perName+"</a>"
                        for(var j = 0;j<data.length;j++){

                            if(data[j].perType==data[i].perId){
                                menu +=    "<dl class='layui-nav-child'>"
                                menu +=        "<dd>"
                                menu +=            "<a class=\"site-demo-active\" data-url='"+data[j].perUrl+"' data-title='"+data[j].perName+"'  data-id='"+data[j].perId+"'>"+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data[j].perName+"</a>"
                                menu +=        "</dd>"
                                menu +=    "</dl>"
                            }
                        }
                    }
                    menu +=    "</li>";
                }
                $("#nav").html(menu);

                element.init()
            }
        });
        //触发事件
        var active = {
            tabAdd: function(url,id,name) {
                console.log(url+"="+id+"=="+name);

                element.tabAdd('demo', {
                    title: name,
                    content: '<iframe data-frameid="'+id+'" scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:99%;"></iframe>',
                    id: id
                })
                console.log(2222);
                FrameWH();
            },
            tabChange: function(id) {
                //切换到指定Tab项
                element.tabChange('demo', id);
            },
            tabDelete: function (id) {
                element.tabDelete("demo", id);
            }
            , tabDeleteAll: function (ids) {
                $.each(ids, function (i,item) {
                    element.tabDelete("demo", item);
                })
            }
        };
        $('#nav').on('click',".site-demo-active", function() {
            console.log(111);
            var dataid = $(this);
            console.log(dataid);
            if ($(".layui-tab-title li[lay-id]").length <= 0) {
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
            } else {

                var isData = false;
                $.each($(".layui-tab-title li[lay-id]"), function () {
                    if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                        isData = true;
                    }
                })
                if (isData == false) {
                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
                }
            }
            active.tabChange(dataid.attr("data-id"));
        });
        function FrameWH() {
            var h = $(window).height() -41- 10 - 60 -10-44 -10;
            $("iframe").css("height",h+"px");
        }

        $(window).resize(function () {
            FrameWH();
        })

    })





</script>
</body>
</html>