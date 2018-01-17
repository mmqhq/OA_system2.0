<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的绩效</title>
<link rel="stylesheet" href="../plugs/layui/css/layui.css">
<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
<script src="../plugs/layui/layui.js"></script>
 <style>
.myJxDiv{
	margin:10px;
}
</style>
 
 <script  type="text/javascript">
 layui.use(['laydate','form','table'], function(){
	  var laydate = layui.laydate,
	  form = layui.form;
	  //执行一个laydate实例
	  laydate.render({
	    elem: '#year1' //指定元素
	   ,type: 'year'
	  });
		
	  //级联选择
	  var $ = layui.$;
	  form.on('select(filter-myjx-select)',function(data){
	        $.getJSON("../json/myJxSelect.json",function(da){
	        	var optionstring = "";
		          $.each(da.data,function(i,item){
					if(data.value=="niandu"){
						 $(".dd").hide();
					}else if(item.province == data.value){
						$(".dd").show();
			            optionstring += "<option value=\"" + item.code + "\" >" + item.name + "</option>";
			            $("[name=season]").html('<option value=""></option>' + optionstring);
			            form.render('select'); 
					}
		          });
	        }); 
	   }); 
	  var table = layui.table;
	   table.render({
		    elem: '#myjx-table'
		    ,height: 315
		    ,width:1100
		    ,url: 'myJx_list'
		     ,page: true 
		    ,cols: [[
		      {field: 'issue', title: '期次', width:100,align: 'center'}
		      ,{field: 'levelName', title: '考核等级', width:150,align: 'center'}
		      ,{field: 'allScore', title: '总评分', width:100,align: 'center'} 
		      ,{field: 'score', title: '自评', width: 100,align: 'center'}
		      ,{field: 'scoreByPeople', title: '指定人评', width: 150,align: 'center'}
		      ,{field: 'comment', title: '综合评语',align: 'center'}
		    ]]
		  });  
	  
	  
    }); 
	  
 </script>
</head>
<body>

<div class="myJxDiv">
<form class="layui-form" action="#">
<div class="layui-inline">
 	<div class="layui-input-inline">
	 	<input type="text" id="year1" class="layui-input">
	</div>
</div>
 	
 <div class="layui-inline">
  <div class="seasons">
   <label>年</label>
	    <div class="layui-input-inline">
	       <select class="layui-select" name="filter-myjx-select" lay-filter="filter-myjx-select">
	        	<option value="yuedu">月度考核</option>
	        	<option value="jidu">季度考核</option>
	        	<option value="niandu">年度考核</option>
      	  </select>
	    </div>
	    <div class="layui-input-inline dd" >
	    	<select class="layui-select" name="season" id="season2">
	    	   <option >请选择</option>
		       <option value="yuedu1">一月</option>
		       <option value="yuedu2">二月</option>
		       <option value="yuedu3">三月</option>
		       <option value="yuedu4">四月</option>
		       <option value="yuedu5">五月</option>
		       <option value="yuedu6">六月</option>
		       <option value="yuedu7">七月</option>
		       <option value="yuedu8">八月</option>
		       <option value="yuedu9">九月</option>
		       <option value="yuedu10">十月</option>
		       <option value="yuedu11">十一月</option>
		       <option value="yuedu12">十二月</option>
	       </select>
	    </div>
  </div>
</div>
  <div class="layui-inline">
	<button class="layui-btn" style="margin-left:10px">查询</button>
  </div>
</form>

<table id="myjx-table" lay-filter="test-myjx-table"></table>
</div>

</body>
</html>