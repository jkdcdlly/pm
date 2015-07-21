<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>ceshi管理</title>
<meta name="decorator" content="default" />
<style type="text/css">
.lineContainer {
	float: left;
	display: inline;
	width: 50%
}

.pieContainer {
	float: right;
	display: inline;
	width: 50%
}
</style>
</head>
<body>
	<div class="content">
		<div id="lineContainer" class="lineContainer "></div>
		<div id="pieContainer" class="pieContainer "></div>
		<div>
			<table id="contentTable"
				class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>序号</th>
						<th>次数</th>
						<th>时间</th>
						<th>评论</th>
						<shiro:hasPermission name="oa:concurrence:edit">
							<th>操作</th>
						</shiro:hasPermission>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.list}" var="concurrence">
						<tr>
							<td>${concurrence.id}</td>
							<td><a
								href="${ctx}/oa/concurrence/form?id=${concurrence.id}">${concurrence.time}</a></td>
							<td>${concurrence.num}</td>
							<%-- 				<td><a href="${ctx}/oa/concurrence/form?id=${concurrence.id}"><fmt:formatDate value="${concurrence.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></a></td> --%>
							<td>${concurrence.remarks}</td>
							<shiro:hasPermission name="oa:concurrence:edit">
								<td><a
									href="${ctx}/oa/concurrence/form?id=${concurrence.id}">修改</a> <a
									href="${ctx}/oa/concurrence/delete?id=${concurrence.id}"
									onclick="return confirmx('确认要删除该ceshi吗？', this.href)">删除</a></td>
							</shiro:hasPermission>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			showLineContainer("http://192.168.6.88:8080/jeesite/a/oa/concurrence/pieChart");
			showPieContainer("http://192.168.6.88:8080/jeesite/a/oa/concurrence/pieChart");
		});
	</script>
</body>
</html>