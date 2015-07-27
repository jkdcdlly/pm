<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>旅游项目管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<form:form id="searchForm" modelAttribute="odsNginxTourism" action="${ctx}/oa/odsNginxTourism/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	
	  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
   
    <script src="${ctxStatic}/chart/chart.js" type="text/javascript"></script>
     <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
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
                DrawEChart //异步加载的回调函数绘制图表
                );
            function DrawEChart(ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'),'macarons'); 
                
                var option = {
                	    title : {
                	        text : '时间坐标折线图',
                	        subtext : 'dataZoom支持'
                	    },
                	    tooltip : {
                	        trigger: 'item',
                	        formatter : function (params) {
                	            var date = new Date(params.value[0]);
                	            return timeToString(date) + '<br/>' + params.value[1] 
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
                	        data : ['tourism_b2b','tourism','tourism_crm']
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
					                     data:(function(){
					                 		var arr=[];
					                 		$.getJSON("findListByApp?reqDate=2015-06-30&appName=tourism_b2b",
					                 				function(data) {
					                 					for (var i = 0; i < data.length; i++) {
					                 						     arr.push([stringToTime(data[i].reqTime),data[i].counts]);	
					                 						}
					                 					// 为echarts对象加载数据 
					                 					myChart.setOption(option); 	
					                 				})
					                       return arr;
					                 })()
					                },
					                {
					                     name: 'tourism',
					                     type: 'line',
					                     showAllSymbol: true,
					                     data:(function(){
					                 		var arr=[];
					                 		$.getJSON("findListByApp?reqDate=2015-06-30&appName=tourism",
					                 				function(data) {
					                 					for (var i = 0; i < data.length; i++) {
					                 						     arr.push([stringToTime(data[i].reqTime),data[i].counts]);	
					                 						}
					                 					// 为echarts对象加载数据 
					                 					myChart.setOption(option); 	
					                 				})
					                       return arr;
					                 })()
					                },
					                {
					                     name: 'tourism_crm',
					                     type: 'line',
					                     showAllSymbol: true,
					                     data:(function(){
					                 		var arr=[];
					                 		$.getJSON("findListByApp?reqDate=2015-06-30&appName=tourism_crm",
					                 				function(data) {
					                 					for (var i = 0; i < data.length; i++) {
					                 						     arr.push([stringToTime(data[i].reqTime),data[i].counts]);	
					                 						}
					                 					// 为echarts对象加载数据 
					                 					myChart.setOption(option); 	
					                 				})
					                       return arr;
					                 })()
					                }
					             ]
                	};
                  
            	
            }
    </script>
</body>
</html>