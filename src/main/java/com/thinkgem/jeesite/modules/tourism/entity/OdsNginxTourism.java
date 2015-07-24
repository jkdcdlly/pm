/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tourism.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 旅游所有项目Entity
 * @author 陈志磊
 * @version 2015-07-24
 */
public class OdsNginxTourism extends DataEntity<OdsNginxTourism> {
	
	private static final long serialVersionUID = 1L;
	private Long txid;		// txid
	private String appName;		// app_name
	private String serverIp;		// server_ip
	private String reqTime;		// req_time
	private String httpStatus;		// http_status
	private String reqUrlPath;		// req_url_path
	private Long counts;		// counts
	private Long preCounts;		// pre_counts
	private String respTime;		// resp_time
	private String preRespTime;		// pre_resp_time
	private Long size;		// size
	private Long preSize;		// pre_size
	private String reqDate;		// req_date
	
	public OdsNginxTourism() {
		super();
	}

	public OdsNginxTourism(String id){
		super(id);
	}

	public Long getTxid() {
		return txid;
	}

	public void setTxid(Long txid) {
		this.txid = txid;
	}
	
	@Length(min=0, max=20, message="app_name长度必须介于 0 和 20 之间")
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	@Length(min=0, max=20, message="server_ip长度必须介于 0 和 20 之间")
	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
	@Length(min=0, max=20, message="req_time长度必须介于 0 和 20 之间")
	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	
	@Length(min=0, max=20, message="http_status长度必须介于 0 和 20 之间")
	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	@Length(min=0, max=255, message="req_url_path长度必须介于 0 和 255 之间")
	public String getReqUrlPath() {
		return reqUrlPath;
	}

	public void setReqUrlPath(String reqUrlPath) {
		this.reqUrlPath = reqUrlPath;
	}
	
	public Long getCounts() {
		return counts;
	}

	public void setCounts(Long counts) {
		this.counts = counts;
	}
	
	public Long getPreCounts() {
		return preCounts;
	}

	public void setPreCounts(Long preCounts) {
		this.preCounts = preCounts;
	}
	
	public String getRespTime() {
		return respTime;
	}

	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}
	
	public String getPreRespTime() {
		return preRespTime;
	}

	public void setPreRespTime(String preRespTime) {
		this.preRespTime = preRespTime;
	}
	
	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	
	public Long getPreSize() {
		return preSize;
	}

	public void setPreSize(Long preSize) {
		this.preSize = preSize;
	}
	
	@Length(min=0, max=20, message="req_date长度必须介于 0 和 20 之间")
	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	
}