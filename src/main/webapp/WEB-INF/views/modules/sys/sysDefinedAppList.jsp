<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>自定义应用管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/sysDefinedApp/">自定义应用列表</a></li>
		<shiro:hasPermission name="sys:sysDefinedApp:edit"><li><a href="${ctx}/sys/sysDefinedApp/form">自定义应用添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysDefinedApp" action="${ctx}/sys/sysDefinedApp/save" method="post" class="breadcrumb form-search">
		<ul class="ul-form">
			<li >
				<label class="control-label">所属项目：</label>
				<form:input path="appType" value="ods_nginx_tourism" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			<li >
			<label class="control-label">应用名称：</label>
			<form:input path="appName" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="添加"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>所属项目</th>
				<th>应用名称</th>
				<shiro:hasPermission name="sys:sysDefinedApp:edit"><th colspan="2">操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysDefinedApp">
			<tr>
				<td>${sysDefinedApp.appType}</td>
				<td>${sysDefinedApp.appName}</td>
				<shiro:hasPermission name="sys:sysDefinedApp:edit">
				<td>
    				<a href="${ctx}/sys/sysDefinedApp/form?id=${sysDefinedApp.id}">修改</a>
					<a href="${ctx}/sys/sysDefinedApp/delete?id=${sysDefinedApp.id}" onclick="return confirmx('确认要删除该自定义应用吗？', this.href)">删除</a>
				</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>