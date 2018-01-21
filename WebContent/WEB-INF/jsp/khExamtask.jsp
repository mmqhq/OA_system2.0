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
var layer,index;
	layui.use([ 'laydate', 'form', 'table','layer' ], function() {
		var laydate = layui.laydate,
			form = layui.form,
			$=layui.$,
			table = layui.table;
		layer = layui.layer;
		//执行一个laydate实例
		laydate.render({
			elem : '#kh-task-year',
			type : 'year'
		});

		//创建数据表格
		var examtaskTab=table.render({
			elem : '#khTaskTab',
			height : "full",
			width : 1120,
			url : 'find_kh_examtask_list',
			page : true,
			limits:[5,10,15,20,25],
			limit:5,
			cols : [[
			{
				field : 'etName',
				title : '考核名称',
				width : 150,
				align : 'center'
			}, {
				field : 'khName',
				title : '考核模板',
				width : 150,
				align : 'center'
			}, {
				field : 'khType',
				title : '考核类型',
				width : 150,
				align : 'center'
			}, {
				field : 'etYear',
				title : '考核年份',
				width : 100,
				align : 'center'
			}, {
				field : 'etIssue',
				title : '期次',
				width : 60,
				align : 'center'
			}, {
				field : 'etTime',
				title : '考核周期',
				width : 190,
				align : 'center'
			}, {
				field : 'etFbState',
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
			if (layEvent === 'detail') { 	//查看
				$("[lay-event=detail]").attr("href","to_see_kh_examtask?etId="+data.etId); 
			}else if (layEvent === 'detailed') { 	//明细
				layer.open({
					  type:2
					  ,title: '考核任务'
					  ,area: ['640px', '200px']
					  ,skin:'layui-layer-molv'
					  ,content: '/to_detail_kh_examtask?etId='+data.etId
					  ,anim:4
					  ,shade: [0.8, '#393D49']
					  ,resize:false
				});
				//$("[lay-event=detailed]").attr("href","to_detail_kh_examtask?etId="+data.etId); 
			} else if (layEvent === 'del') { 	//删除
				layer.confirm('真的删除行么', function(index) {
					obj.del(); 	
					layer.close(index);
					//向服务端发送删除指令
					$.post('/delExamtask',{da:data.etId},function(){
						obj.del();
						layer.close(index);
					})  
				});
			} else if (layEvent === 'edit') { 	//编辑
				//同步更新缓存对应的值
				/* obj.update({
					username : '123',
					title : 'xxx'
				}); */
			}

		});
		
		//"考核任务"-查询
		form.on('submit(chaXunExamtask)', function(data){
			  var f = data.field;	//当前容器的全部表单字段，名值对形式：{name: value}
  				examtaskTab.reload({
  					page:{curr:1},
  					where:{
  						taskyear:f.taskyear,
  						taskType:f.taskType
  					}  
  				});
  				 return false; //阻止表单跳转。
			});
		//重新渲染表单
		form.render();
	});
	
	function addPertempLayer(){
		layui.use(['layer','table'], function() {
			var layer=layui.layer,
				table = layui.table;
			index=layer.open({
				  type:2
				  ,title: '选择考核模板'
				  ,area: ['600px', '450px']
				  ,skin:'layui-layer-molv'
				  ,content: 'to_kh_addPertempLayer'
				  ,anim:4
				  ,shade: [0.8, '#393D49']
				  ,resize:false
			}); 
		});
	}
	function close(a){
		layer.close(index);
		window.location = "/to_add_kh_examtask?ptId="+a;
	}
	
</script>
<script type="text/html" id="KhExamtaskBar">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detailed">明细</a>
	<a class="layui-btn layui-btn-xs" lay-event="edit" href="to_edit_kh_examtask">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</head>
<body>
<div class="khExamtaskDiv">
	<form class="layui-form" action="#">
	<input id="etId" type="hidden" name="etId"/>
		<div class="layui-inline">
			<label>考核年份：</label>
			<div class="layui-input-inline">
				<input type="text" id="kh-task-year" class="layui-input" name="taskyear">
			</div>
		</div>
		<div class="layui-inline">
			<label>考核类型：</label>
			<div class="layui-input-inline">
				<select class="layui-select" name="taskType"
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
				<button lay-submit class="layui-btn" style="margin-left: 10px" lay-filter="chaXunExamtask">查询</button>
				<a class="layui-btn" onclick="addPertempLayer()">增加</a>
			</div>
		</div>
	</form>
	<table id="khTaskTab" lay-filter="khTaskTabfilter"></table>
</div>
</body>
</html>