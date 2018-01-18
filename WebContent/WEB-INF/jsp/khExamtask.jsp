<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../plugs/layui/css/layui.css">
<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
<script src="../plugs/layui/layui.js"></script>
<title>考核任务</title>
<style type="text/css">
.khExamtaskDiv{
	margin: 10px;
}
</style>
<script type="text/javascript">
	layui.use([ 'laydate', 'form', 'table' ], function() {
		var laydate = layui.laydate, form = layui.form,$=layui.$;
		//执行一个laydate实例
		laydate.render({
			elem : '#kh-task-year',
			type : 'year'
		});

		//创建数据表格
		var table = layui.table;
		table.render({
			elem : '#khTaskTab',
			height : 320,
			width : 1130,
			url : 'find_kh_examtask_list',
			page : true,
			cols : [[
			{
				field : 'khName',
				title : '考核名称',
				width : 150,
				align : 'center'
			}, {
				field : 'khPertemp',
				title : '考核模板',
				width : 150,
				align : 'center'
			}, {
				field : 'khType',
				title : '考核类型',
				width : 150,
				align : 'center'
			}, {
				field : 'khYear',
				title : '考核年份',
				width : 100,
				align : 'center'
			}, {
				field : 'khIssue',
				title : '期次',
				width : 60,
				align : 'center'
			}, {
				field : 'khTime',
				title : '考核周期',
				width : 190,
				align : 'center'
			}, {
				field : 'khState',
				title : '状态',
				width : 80,
				align : 'center'
			}, {
				title : '操作',
				align : 'center',
				toolbar : '#KhExamtaskBar',
			} 
			]]
		});

		//表格内的工具条的点击事件
		table.on('tool(khTaskTabfilter)', function(obj) {
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值
			/* var tr = obj.tr; */// 获得当前行 tr 的DOM对象
			if (layEvent === 'detail') { 	//查看
				
				//alert($("[lay-event=detail]").attr("href"));
			}else if (layEvent === 'detailed') { 	//明细
			
			} else if (layEvent === 'del') { 	//删除
				layer.confirm('真的删除行么', function(index) {
					obj.del(); 		//删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令
					/*  
					$.post('/delExamtask',obj.data,function(){
					layer.close(index);
					obj.del();
					})  */
				});
			} else if (layEvent === 'edit') { 	//编辑
				//同步更新缓存对应的值
				/* obj.update({
					username : '123',
					title : 'xxx'
				}); */
			}

		});

		//重新渲染表单
		//form.render();
	});
</script>
<script type="text/html" id="KhExamtaskBar">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail" href="to_see_kh_examtask">查看</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detailed" href="">明细</a>
	<a class="layui-btn layui-btn-xs" lay-event="edit" href="to_edit_kh_examtask">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</head>
<body>
<div class="khExamtaskDiv">
	<form class="layui-form" action="#">
		<div class="layui-inline">
			<label>考核年份：</label>
			<div class="layui-input-inline">
				<input type="text" id="kh-task-year" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label>考核类型：</label>
			<div class="layui-input-inline">
				<select class="layui-select" name="kh-task-select"
					lay-filter="kh-task-select">
					<option value="">选择类型</option>
					<option value="yuedu">月度考核</option>
					<option value="jidu">季度考核</option>
					<option value="niandu">年度考核</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<div class="layui-input-inline">
				<button class="layui-btn" style="margin-left: 10px">查询</button>
				<button class="layui-btn">增加</button>
				<button class="layui-btn">批量增加</button>
			</div>
		</div>
	</form>
	<table id="khTaskTab" lay-filter="khTaskTabfilter"></table>
</div>
</body>
</html>