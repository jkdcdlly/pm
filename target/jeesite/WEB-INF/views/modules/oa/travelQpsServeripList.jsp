<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>主机分析管理</title>
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
	<form:form id="searchForm" modelAttribute="vo"
		action="${ctx}/oa/travelQpsServerip/list" method="get"
		class="breadcrumb form-search">
		<div>
			<label>日期：</label> <input id="beginDate" name="date" type="text"
				readonly="readonly" maxlength="20" class="input-medium Wdate"
				style="width: 163px;" value="${vo.date}"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" /> <input
				id="btnSubmit" class="btn btn-primary" type="submit" value="查询" />
		</div>
	</form:form>
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
		function showLineContainer(url) {
			$
					.getJSON(
							url,
							function(data) {
								var today = new Array();
								for (var i = 0; i < data.length; i++) {
									today.push(data[i].pv);
								}
								$('#lineContainer')
										.highcharts(
												{
													title : {
														text : '访问量'
													},
													chart : {
														zoomType : 'x',
														spacingRight : 20
													},
													credits : {
														enabled : false
													},
													subtitle : {
														text : '单击拖动并放大'
													},
													tooltip : {
														formatter : function() {
															return new Date(this.x-28800000).toLocaleString().substr(0,17)+ '<br/>访问量'+ this.y;
														}
													},
													xAxis : {
														type : 'datetime',
														maxZoom : 288 // 即24 * 60 / 5
													},
													series : [ {
														type : 'line',
														name : '访问量',
														pointInterval : 10 * 60 * 1000,// 时间间隔5分钟
														pointStart : Date.parse(new Date("${vo.date} 08:00:00")),
														data : today
													} ]
												});
							})
		}

		function showPieContainer(url) {
			$
					.getJSON(
							url,
							function(data) {
								var today = new Array();
								for (var i = 0; i < data.length; i++) {
									today.push(data[i].pv);
								}
								$('#pieContainer')
										.highcharts(
												{
													title : {
														text : '访问量'
													},
													chart : {
														zoomType : 'x',
														spacingRight : 20
													},
													credits : {
														enabled : false
													},
													subtitle : {
														text : '单击拖动并放大'
													},
													tooltip : {
														formatter : function() {
															return new Date(this.x-28800000).toLocaleString().substr(0,17)+ '<br/>访问量'+ this.y;
														}
													},
													xAxis : {
														type : 'datetime',
														maxZoom : 288 // 即24 * 60 / 5
													},
													series : [ {
														type : 'line',
														name : '访问量',
														pointInterval : 60 * 60 * 1000,// 时间间隔5分钟
														pointStart : Date.parse(new Date("${vo.date} 08:00:00")),
														data : today
													} ]
												});
							})
		}

		$(document)
				.ready(
						function() {
							showLineContainer("http://192.168.6.88:8080/jeesite/a/oa/travelQpsServerip/lineChart?date=${vo.date}");
							showPieContainer("http://192.168.6.88:8080/jeesite/a/oa/travelQpsServerip/findList?date=${vo.date}");
						});
	</script>
</body>
</html>