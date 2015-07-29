function GetDateStr(AddDayCount) {
	var dd = new Date();
	dd.setDate(dd.getDate() + AddDayCount);// 获取AddDayCount天后的日期
	var y = dd.getFullYear();
	var m = dd.getMonth() + 1;// 获取当前月份的日期
	var d = dd.getDate();
	return y + "-" + m + "-" + d;
}

function GetTimeStr(millisecond) {
	var dd = new Date(millisecond);
	return dd.getFullYear() + "-" + (dd.getMonth() + 1) + "-" + dd.getDate() + " " + dd.getHours() + ":" + dd.getMinutes() + ":" + dd.getSeconds();
}

function timeToString(date) {
	var str = date.getFullYear() + '-'
	        + (date.getMonth() + 1) + '-'
	        + date.getDate() + ' '
	        + date.getHours() + ':'
	        + date.getMinutes()
	return str;
}


function stringToTime(timeStr){
	if(timeStr.length==19){
	var datearr = timeStr.split(' ')[0].split('-');
	var timearr = timeStr.split(' ')[1].split(':');
	var d = new Date();
	d.setFullYear(parseInt(datearr[0]));
	d.setMonth(parseInt(datearr[1]-1));
	d.setDate(parseInt(datearr[2]));
	d.setHours(parseInt(timearr[0]));
	d.setMinutes(parseInt(timearr[1]));
	d.setSeconds(0);
	return d;
	}
}

function page(n, s) {
	$("#pageNo").val(n);
	$("#pageSize").val(s);
	$("#searchForm").submit();
	return false;
}

function showLineContainer(url) {
	$
			.getJSON(
					url,
					function(data) {
						var yesterday = new Array();
						var today = new Array();
						for (var i = 0; i < data.length; i++) {
							if (new Date(GetDateStr(0)) > new Date(
									data[i].inDate)) {
								yesterday.push(data[i].num);
							} else {
								today.push(data[i].num);
							}
						}
						$('#lineContainer')
								.highcharts(
										{
											chart : {
												zoomType : 'x',
												spacingRight : 20
											},
											title : {
												text : '昨日与今日PV对比'
											},
											subtitle : {
												text : document.ontouchstart === undefined ? '单击图形并拖动可以放大'
														: 'Pinch the chart to zoom in'
											},
											xAxis : {
												type : 'datetime',
												maxZoom : 288, // 即24 * 60 / 5
												title : {
													text : null
												}
											},
											yAxis : {
												title : {
													text : 'Exchange rate'
												}
											},
											tooltip : {
												shared : true
											},
											legend : {
												enabled : false
											},
											plotOptions : {
												area : {
													fillColor : {
														linearGradient : {
															x1 : 0,
															y1 : 0,
															x2 : 0,
															y2 : 1
														},
														stops : [
																[
																		0,
																		Highcharts
																				.getOptions().colors[0] ],
																[
																		1,
																		Highcharts
																				.Color(
																						Highcharts
																								.getOptions().colors[0])
																				.setOpacity(
																						0)
																				.get(
																						'rgba') ] ]
													},
													lineWidth : 1,
													marker : {
														enabled : false
													},
													shadow : false,
													states : {
														hover : {
															lineWidth : 1
														}
													},
													threshold : null
												}
											},

											series : [
													{
														type : 'line',
														name : '今日',
														pointInterval : 60 * 1000 * 5,// 时间间隔5分钟
														pointStart : Date.UTC(
																2015, 06, 07),
														data : today
													},
													{
														type : 'line',
														name : '昨日 ',
														pointInterval : 60 * 1000 * 5,// 5分钟
														pointStart : Date.UTC(
																2015, 06, 07),
														data : yesterday
													} ]
										});
					})
}

function showPieContainer(url) {
	$
			.getJSON(
					url,
					function(data) {
						$('#pieContainer')
								.highcharts(
										{
											chart : {
												plotBackgroundColor : null,
												plotBorderWidth : null,
												plotShadow : false
											},
											title : {
												text : '入口来源分析'
											},
											tooltip : {
												pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
											},
											plotOptions : {
												pie : {
													allowPointSelect : true,
													cursor : 'pointer',
													dataLabels : {
														enabled : true,
														color : '#000000',
														connectorColor : '#000000',
														format : '<b>{point.name}</b>: {point.percentage:.1f} %'
													}
												}
											},
											series : [ {
												type : 'pie',
												name : 'Browser share',
												data : [ [ 'Firefox', 50 ],
														[ 'IE', 20 ] ]
											} ]
										});

					})
}
