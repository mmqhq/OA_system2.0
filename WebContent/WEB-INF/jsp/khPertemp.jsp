<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考核模板</title>
<link rel="stylesheet" href="../plugs/layui/css/layui.css">
<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
<script src="../plugs/layui/layui.js"></script>

<style>
.khPertempDiv{
	margin:10px;
}
.divInput{
	width:130px;
}
</style>
<script type="text/javascript">
	layui.use([ 'laydate', 'form', 'table' ], function() {
		var laydate = layui.laydate, 
			form = layui.form,
			table=layui.table,
			$ = layui.$;
		laydate.render({
			elem : '#khPertempTime1'
		});
		laydate.render({
			elem : '#khPertempTime2'
		});
		
		// 初始化表头结构
		var tableIns =table.render({
			elem : '#khPertempTab',
			height: "full",
			width : 1120,
			url : 'find_kh_pertemp_list',
			page : true,
			limits:[5,10,15,20,25],
			limit:5,
			cols : [[ 
			{
				field : 'khName',
				title : '考核名称',
				width : 150,
				align : 'center'
			}, {
				field : 'khType',
				title : '类型',
				width : 100,
				align : 'center'
			}, {
				field : 'khPeople',
				title : '创建人',
				width : 120,
				align : 'center'
			}, {
				field : 'khTime',
				title : '创建日期',
				width : 200,
				align : 'center'
			}, {
				field : 'khScore',
				title : '总分数',
				width : 120,
				align : 'center'
			}, {
				field : 'khRemark',
				title : '备注',
				width : 180,
				align : 'center'
			}, {
				title : '操作',
				align : 'center',
				toolbar : '#khPertempBar',
			} 
			]]
		});
		form.verify({
			checkDate:function(value,item){
				if($("#khPertempTime2").val() != null && value < $("#khPertempTime1").val()){
					return "查询结束日期大于开始日期！";
				}
			}
		});
		
		//表格内的工具条的点击事件
		table.on('tool(khPertempTabfilter)', function(obj) {
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值
			/* var tr = obj.tr; */// 获得当前行 tr 的DOM对象
			if(layEvent === 'del') { 	//删除
				layer.confirm('真的删除么？', function(index) {
					//向服务端发送删除指令
					$.post('del_kh_pertemp_list',{da:data.khId},function(){
						obj.del();	//删除对应行（tr）的DOM结构，并更新缓存
						layer.close(index);
						tableIns.reload();
					})  
				});
			} else if (layEvent === 'edit') { 	//编辑
			    //$("[lay-event=edit]").attr("href","to_add_kh_pertemp?khId="+data.khId); 
			}
		});
		
		//"考核模板"-查询
		form.on('submit(chaXunPertemp)', function(data){
			  var f = data.field;	//当前容器的全部表单字段，名值对形式：{name: value}
  				tableIns.reload({
  					page:{curr:1},
  					where:{
  						khName:f.khName,
  						khType:f.khType,
  						khPertempTime1:f.khPertempTime1,
  						khPertempTime2:f.khPertempTime2
  					}  
  				});
  				 return false; //阻止表单跳转。
			});
			form.render();//更新全部
	});
	
</script>
<script type="text/html" id="khPertempBar">
	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</head>
<body>
<div class="khPertempDiv">
	<form class="layui-form" action="#">
	<input id="khId" type="hidden" name="khId"/>
		<div class="layui-inline">
			<label>考核名称：</label>
			<div class="layui-input-inline divInput">
				<input type="text" name="khName" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label>考核类型：</label>
			<div class="layui-input-inline divInput">
				<select class="layui-select" name="khType"
					lay-filter="kh-task-select">
					<option value="">选择类型</option>
					<option value="0">月度考核</option>
					<option value="1">季度考核</option>
					<option value="2">年度考核</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label>创建时间：</label>
			<div class="layui-input-inline divInput">
				<input type="text" name="khPertempTime1" id="khPertempTime1" class="layui-input">
			</div>
			<label>~</label>
			<div class="layui-input-inline divInput">
				<input type="text" name="khPertempTime2" id="khPertempTime2" class="layui-input" lay-verify="checkDate">
			</div>
		</div>
		<div class="layui-inline">
			<div class="layui-input-inline">
				<button lay-submit class="layui-btn"lay-filter="chaXunPertemp" style="margin-left: 10px">查询</button>
				<a href="to_add_kh_pertemp" class="layui-btn" >增加</a>
			</div>
		</div>
	</form>
	<table id="khPertempTab" lay-filter="khPertempTabfilter"></table>
</div>
</body>
</html>