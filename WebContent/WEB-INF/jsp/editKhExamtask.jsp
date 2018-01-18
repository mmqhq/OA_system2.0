<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑考核任务</title>
<link rel="stylesheet" href="../plugs/layui/css/layui.css">
<script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
<script src="../plugs/layui/layui.js"></script>

<style>
#tableLast-tr {
	background: rgb(239, 239, 243);
}

.bigone {
	width: 1080px;
	margin-left:20px;
}
.tab-btn-last{
 	margin-left:460px;
 }
</style>
<script type="text/javascript">
	layui.use([ 'laydate', 'form', 'table' ], function() {
		var laydate = layui.laydate, form = layui.form;
		laydate.render({
			elem : '#edit-kh-examtask-year',
		});
	});
</script>
</head>
<body>
	<div class="bigone">
		<form class="layui-form" action="#">
			<table class="layui-table">
				<thead>
					<tr>
						<td colspan="4">考核信息</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="100" align="right">考核名称：</td>
						<td width="200"><input type="text" disabled="disabled"
							value="2018年员工绩效"></td>
						<td width="100" align="right">考核模板：</td>
						<td width="200"><input type="text" disabled="disabled"
							value="员工绩效"></td>
					</tr>
					<tr>
						<td width="100" align="right">考核类型：</td>
						<td><input type="text" disabled="disabled" value="月度考核">
						</td>
						<td width="100" align="right">考核分数：</td>
						<td><input type="text" disabled="disabled" value="100">
						</td>
					</tr>
					<tr>
						<td width="100" align="right">考核年份：</td>
						<td><input type="text" disabled="disabled" value="2018">
						</td>
						<td align="right">考核期次：</td>
						<td>1</td>
					</tr>
					<tr>
						<td width="100" align="right">评分开始日期：</td>
						<td><input type="text" disabled="disabled" value="2018-01-01">
						</td>
						<td width="100" align="right">评分结束日期：</td>
						<td><input type="text" id="edit-kh-examtask-year"
							class="layui-input"></td>
					</tr>
					<tr>
						<td width="100" align="right">考核管理人：</td>
						<td colspan="3">
							<input type="text" disabled="disabled" style="width: 80%" value="黄琼">
						</td>
					</tr>
					<tr>
						<td width="100" align="right">被考核人：</td>
						<td colspan="3">
							<textarea id="" style="height: 40px; width: 80%" onclick="" >邓晓晓
							</textarea>
						</td>
					</tr>
					<tr>
						<td width="100" align="right">备注：</td>
						<td colspan="3">
							<textarea id="" style="height: 40px; width: 80%">
								
							</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="layui-table table-last">
				<tr>
					<td colspan="4" align="center"
						style="color: rgb(0, 150, 140); font-size: 18px;">考核步骤</td>
				</tr>

				<tbody>
					<tr align="center" id="tableLast-tr">
						<td>步骤名称</td>
						<td>步骤</td>
						<td>权重</td>
						<td>考核人</td>
					</tr>
					<tr align="center">
						<td>自评</td>
						<td>1</td>
						<td>50%</td>
						<td>本人</td>
					</tr>
					<tr align="center">
						<td>指定人评</td>
						<td>2</td>
						<td>50%</td>
						<td>部门经理</td>
					</tr>
				</tbody>
			</table>
			
			<div class="layui-inline tab-btn-last" >
				<button class="layui-btn" style="margin-left: 10px">保存</button>
				<button class="layui-btn">返回</button>
			</div>
		</form>
	</div>
</body>
</html>