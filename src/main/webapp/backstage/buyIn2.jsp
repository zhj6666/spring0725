<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/7/29
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>采购申请</title>
    <base href="http://localhost:8080/spring0725/"></base>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<button id="submit">提交</button>
<form role="form" class="form-inline">
    <div class="form-group">
        <label for="orderid">流水号</label>
        <input type="text" class="form-control" id="orderid" >
    </div>
    <div class="form-group">
        <label for="caigoudate">申请日期</label>
        <input type="text" class="form-control" id="caigoudate" >
    </div>
    <div class="form-group">
        <label for="caigouperson">申请人</label>
        <input type="text" class="form-control" id="caigouperson" value="${userInfo.userName}">
    </div>
    <div class="form-group">
        <label for="caigoudept">申请部门</label>
        <input type="text" class="form-control" id="caigoudept" >
    </div>
</form>
<button id="btn">添加商品</button>
<table  class="table">
    <thead>
    <tr>
        <th>商品ID</th>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品类别</th>
        <th>规格型号</th>
        <th>采购单价</th>
        <th>销售单价</th>
        <th>数量</th>
        <th>产地</th>
        <th>计量单位</th>
        <th>小计</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="mytbd">


    </tbody>

</table>


</body>
</html>
<script>
    var num=0;//区分到底是第几行
    //点击添加商品时
    $("#btn").click(function(){
        var tr="<tr>"
        tr+="<td></td>";
        tr+="<td></td>";
        tr+="<td><select class='goodsName'><option>--选择商品--</option></select></td>";
        tr+="<td></td>";
        tr+="<td></td>";
        tr+="<td></td>";
        tr+="<td></td>";
        tr+="<td><input></td>";
        tr+="<td></td>";
        tr+="<td></td>";
        tr+="<td>0</td>";

        tr+="<td><button class='btn'>删除</button></td>";
        tr+="</tr>";
        //新增的tr追加到
        $("#mytbd").append(tr)
        getGoods();
    });


    //动态读取商品信息
    var goodsinfo;
    function getGoods(){
        $.ajax({
            url:"selectGoods",
            contextType:"application/json",
            type:"post",
            dataType:"json",
            success:function(data) {
                goodsinfo=data;
                //清空下拉框中的子元素

                for (var i in data) {
                    var option = "<option value='" + data[i].goodsNo + "'>" + data[i].goodsName + "</option>";
                    $("#mytbd .goodsName").eq(num).append(option);//当前行只会影响，不会影响其他行

                }
                num++;//每添一行num自增1

            }
        })
    }
    //因为下拉框时动态生成的，所有不能直接使用change,B必须使用事件绑定
    //下拉框改变时，将对应的商品信息查询出来记载到对应的td中
    $("#mytbd").on("change",".goodsName",function(){
        //循环进行匹配
        for(var i in goodsinfo){
            if($(this).val()==goodsinfo[i].goodsNo){
                //$(this).parent().prev().text();
                // $(this).parent().next().text(goodsinfo[i].typeName);
                $(this).parent().parent().children("td").eq(0).text(goodsinfo[i].goodsId);
                $(this).parent().parent().children("td").eq(1).text(goodsinfo[i].goodsNo);
                $(this).parent().parent().children("td").eq(3).text(goodsinfo[i].goodsTypeName);
                $(this).parent().parent().children("td").eq(4).text(goodsinfo[i].goodsSize);
                $(this).parent().parent().children("td").eq(5).text(goodsinfo[i].proPrice);
                $(this).parent().parent().children("td").eq(6).text(goodsinfo[i].salePrice);
                $(this).parent().parent().children("td").eq(8).text(goodsinfo[i].goodsPlace);
                $(this).parent().parent().children("td").eq(9).text(goodsinfo[i].unit);

            }

        }

    })

    //删除
    $("#mytbd").on("click",".btn",function(){
        if(confirm("是否删除?")) {
            $(this).parent().parent().remove();
            num--;
        }

    })

    $("#mytbd").on("keyup","input",function(){
        var inprice= $(this).parent().prev().text();
        var num= $(this).val();
        $(this).parent().next().next().next().text(inprice*num);
    })



    //提交按钮
    $("#submit").click(function () {
        var orderid=$("#orderid").val();
        var applydate=$("#caigoudate").val();
        var applyperson=$("#caigouperson").val();
        var applydept=$("#caigoudept").val();
        var goodsarr=new Array();
        $("#mytbd tr").each(function () {
            var goods=new Object();
            goods.goodsId=$(this).children("td").eq(0).text();
            goods.orderid=orderid;
            goods.goodsNum=$(this).find("input").val();
            goodsarr.push(goods);
        })
        var jsonstr={"orderid":orderid,"applydate":applydate,"applyperson":applyperson,"applydept":applydept,"goods":goodsarr}
        alert(JSON.stringify(jsonstr))
    })


</script>
