<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
<title>旅游项目管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
$(document).ready(function() {
	function requireConfig(){
	  require.config({
					paths: {
							echarts: 'http://echarts.baidu.com/build/dist'
							}
					});
        require(
                [
                    'echarts',
                    'echarts/chart/line' //按需加载图表关于线性图、折线图的部分
                ],
                DrawEChart
                );
	}
    requireConfig();
// 	setInterval( requireConfig , 1000 * 60); 
});
</script>
</head>

<body>
<form:form id="searchForm" modelAttribute="odsNginxTourism" action="${ctx}/oa/odsNginxTourism/history" method="post" class="breadcrumb form-search">
	<div>
		<label>应用名称：&nbsp;</label>
		<form:select path="appName" class="input-medium">
			<form:options items="${appNameList}" /> 
		</form:select>
		
		<label>日期：</label> <input id="beginDate" name="beginDate"
			type="text" readonly="readonly" maxlength="20"
			class="input-medium Wdate" style="width: 163px;"
			value="<fmt:formatDate value="${act.beginDate}" pattern="yyyy-MM-dd"/>"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" /> -- <input
			id="endDate" name="endDate" type="text" readonly="readonly"
			maxlength="20" class="input-medium Wdate" style="width: 163px;"
			value="<fmt:formatDate value="${act.endDate}" pattern="yyyy-MM-dd"/>"
			onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" /> &nbsp;<input
			id="btnSubmit" class="btn btn-primary" type="submit" value="查询" />
	</div>
</form:form>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="lineass" style="height: 300px;"></div>

	<div id="lineError" style="height: 300px;"></div>


	<!-- ECharts单文件引入 -->
	<script src="${ctxStatic}/chart/chart.js" type="text/javascript"></script>
	<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
	  <script type="text/javascript">
        // 路径配置
            function DrawEChart(ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('lineass'),'macarons'); 
             		var arr=[];
             		$.getJSON("findListByApp?reqDate=2015-06-30&appName=tourism_b2b",
             				function(data) {
             					for (var i = 0; i < data.length; i++) {
             						     arr.push([stringToTime(data[i].reqTime),data[i].counts,"tourism_b2b"]);	
             						}
                var option = {
                	    title : {
                	        text : '访问量统计',
                	        subtext : 'dataZoom支持'
                	    },
                	    tooltip : {
                	        trigger: 'item',
                	        formatter : function (params) {
                	            return params.value[2] + '<br/>' + timeToString(params.value[0]) + "\t 访问量" + params.value[1]
                	        }
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    dataZoom: {
                	        show: true,
                	        start : 70
                	    },
                	    legend : {
                	        data : ['tourism_b2b']
                	    },
                	    xAxis : [
                	             
                	        {
                	            type : 'time',
                	            splitNumber:10
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value',
                	            min:0
                	        }
                	    ],
                	    series :  [
					                 {
					                     name: 'tourism_b2b',
					                     type: 'line',
					                     showAllSymbol: true,
					                     data:arr
					                }
					             ]
                	};
            	// 为echarts对象加载数据 
            	loadingTicket = setTimeout(function (){
				    myChart.hideLoading();
				    myChart.setOption(option);
				},200);
				})

				// 基于准备好的dom，初始化echarts图表
                var myChart2 = ec.init(document.getElementById('lineError'),'macarons'); 
                var lineErrorArr=[];
                var lineErrorseries=[];
                $.getJSON("findListByApp?reqDate=2015-06-30&appName=tourism_b2b&httpStatus=400",
              				function(data) {
              					for (var i = 0; i < data.length; i++) {
              						lineErrorArr.push([stringToTime(data[i].reqTime),data[i].counts,"tourism_b2b"]);	
              						}
              					lineErrorseries.push({name: 'tourism_b2b',type: 'line',showAllSymbol: true,data:lineErrorArr});
                 				
                var option2 = {
                	    title : {
                	        text : '错误访问数统计',
                	        subtext : 'dataZoom支持'
                	    },
                	    tooltip : {
                	        trigger: 'item',
                	        formatter : function (params) {
                	            return params.value[2] + '<br/>' + timeToString(params.value[0]) + "\t 错误访问量" + params.value[1]
                	        }
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    dataZoom: {
                	        show: true,
                	        start : 70
                	    },
                	    legend : {
                	        data : ['tourism_b2b']
                	    },
                	    xAxis : [
                	        {
                	            type : 'time',
                	            splitNumber:10
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value',
                	            min:0
                	        }
                	    ],
                	    series :  lineErrorseries
                	};
                myChart2.setOption(option2); 	
                })
            
            }
    </script>
    
</body>

</html>