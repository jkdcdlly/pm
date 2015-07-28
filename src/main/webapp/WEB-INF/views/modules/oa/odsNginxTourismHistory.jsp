<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
<title>旅游项目管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
</head>

<body>
	<form:form id="searchForm" modelAttribute="odsNginxTourism"
		action="${ctx}/oa/odsNginxTourism/form" method="post"
		class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label class="control-label">应用名：</label> <select
				name="appName" style="width: 150px">
					<c:forEach items="${appNameList}" var="appName" varStatus="vs">
						<c:if test="${appName==odsNginxTourism.appName}">
							<option value="${appName}" selected>${appName}</option>
						</c:if>
						<c:if test="${appName!=odsNginxTourism.appName}">
							<option value="${appName}">${appName}</option>
						</c:if>
					</c:forEach>
			</select></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="piemain"
		style="width: 40%; height: 300px; display: inline; float: left"></div>
	<div id="linemain"
		style="width: 60%; height: 300px; display: inline; float: right"></div>

	<div id="lineError" style="height: 300px;"></div>


	<!-- ECharts单文件引入 -->
	<script src="${ctxStatic}/chart/chart.js" type="text/javascript"></script>
	<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>

	<script type="text/javascript">
		// 路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});
		require([ 'echarts', 'echarts/chart/pie' //按需加载图表关于线性图、折线图的部分
		],
		//异步加载的回调函数绘制图表
		DrawEChart);
		function DrawEChart(ec) {
			var arr = [];
			$.getJSON("findListByserverIP?reqDate=2015-06-30&appName="
					+ $("select[name=appName]").val(), function(data) {
				// 基于准备好的dom，初始化echarts图表
				var myChart = ec.init(document.getElementById('piemain'),
						'macarons');
				option = {
					title : {
						text : $("select[name=appName]").val(),
						subtext : '服务器访问量',
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {c} ({d}%)"
					},
					legend : {
						orient : 'vertical',
						x : 'left',
						data : (function() {
							var arr = [];
							for (var i = 0; i < data.length; i++) {
								arr.push(data[i].serverIp);
							}
							return arr;
						})()
					},
					toolbox : {
						show : true,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'pie', 'funnel' ],
								option : {
									funnel : {
										x : '25%',
										width : '50%',
										funnelAlign : 'left',
										max : 1548
									}
								}
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					calculable : true,
					series : [ {
						name : '服务器IP',
						type : 'pie',
						data : (function() {
							var arr = [];
							for (var i = 0; i < data.length; i++) {
								arr.push({
									value : data[i].counts,
									name : data[i].serverIp
								});
							}
							return arr;
						})()
					} ]
				};
				// 为echarts对象加载数据 
				myChart.setOption(option);
			})

		}
	</script>

	<script type="text/javascript">
		// 路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});
		require([ 'echarts', 'echarts/chart/line' //按需加载图表关于线性图、折线图的部分
		], DrawEChart //异步加载的回调函数绘制图表
		);

		function DrawEChart(ec) {
			var series = [];
			var keys = [];
			$
					.getJSON(
							"findListByserverIPAndReqTime?reqDate=2015-06-30&appName="
									+ $("select[name=appName]").val(),
							function(data) {
								$
										.each(
												data,
												function(key, values) {
													keys.push(key);
													var vals = [];
													$(values)
															.each(
																	function(
																			val) {
																		vals
																				.push([
																						stringToTime(values[val].reqTime),
																						values[val].counts,
																						key ]);
																	});
													series.push({
														name : key,
														type : 'line',
														showAllSymbol : true,
														data : vals
													})
												});
								// 基于准备好的dom，初始化echarts图表
								var myChart = ec
										.init(document
												.getElementById('linemain'),
												'macarons');

								var option = {
									title : {
										text : '访问量统计',
										subtext : 'dataZoom支持'
									},
									tooltip : {
										trigger : 'item',
										formatter : function(params) {
											return params.value[2]
													+ '<br/>'
													+ timeToString(params.value[0])
													+ "\t 访问量"
													+ params.value[1]
										}
									},
									toolbox : {
										show : true,
										feature : {
											mark : {
												show : true
											},
											dataView : {
												show : true,
												readOnly : false
											},
											restore : {
												show : true
											},
											saveAsImage : {
												show : true
											}
										}
									},
									dataZoom : {
										show : true,
										start : 70
									},
									legend : {
										data : keys
									},
									xAxis : [

									{
										type : 'time',
										splitNumber : 10
									} ],
									yAxis : [ {
										type : 'value',
										min : 0
									} ],
									series : series
								};
								myChart.setOption(option);
							})

		}
	</script>

	<script type="text/javascript">
		// 路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});
		require([ 'echarts', 'echarts/chart/line' //按需加载图表关于线性图、折线图的部分
		], DrawEChart //异步加载的回调函数绘制图表
		);

		function DrawEChart(ec) {
			var series = [];
			var keys = [];
			$
					.getJSON(
							"findListByserverIPAndReqTime?reqDate=2015-06-30&httpStatus=400&appName="
									+ $("select[name=appName]").val(),
							function(data) {
								$
										.each(
												data,
												function(key, values) {
													keys.push(key);
													var vals = [];
													$(values)
															.each(
																	function(
																			val) {
																		vals
																				.push([
																						stringToTime(values[val].reqTime),
																						values[val].counts,
																						key ]);
																	});
													series.push({
														name : key,
														type : 'line',
														showAllSymbol : true,
														data : vals
													})
												});
								// 基于准备好的dom，初始化echarts图表
								var myChart = ec.init(document
										.getElementById('lineError'),
										'macarons');

								var option = {
									title : {
										text : '错误访问量统计',
										subtext : 'dataZoom支持'
									},
									tooltip : {
										trigger : 'item',
										formatter : function(params) {
											return params.value[2]
													+ '<br/>'
													+ timeToString(params.value[0])
													+ "\t 访问量"
													+ params.value[1]
										}
									},
									toolbox : {
										show : true,
										feature : {
											mark : {
												show : true
											},
											dataView : {
												show : true,
												readOnly : false
											},
											restore : {
												show : true
											},
											saveAsImage : {
												show : true
											}
										}
									},
									dataZoom : {
										show : true,
										start : 70
									},
									legend : {
										data : keys
									},
									xAxis : [

									{
										type : 'time',
										splitNumber : 10
									} ],
									yAxis : [ {
										type : 'value',
										min : 0
									} ],
									series : series
								};
								myChart.setOption(option);
							})

		}
	</script>
</body>

</html>