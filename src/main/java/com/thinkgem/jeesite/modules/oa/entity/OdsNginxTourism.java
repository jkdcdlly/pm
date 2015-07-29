/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.entity;

import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 旅游项目Entity
 * 
 * @author chenzhilei
 * @version 2015-07-26
 */
public class OdsNginxTourism extends DataEntity<OdsNginxTourism> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4212646123797380196L;
	private String appName; // app_name
	private String serverIp; // server_ip
	private String reqTime; // req_time
	private String httpStatus; // http_status
	private String reqUrlPath; // req_url_path
	private Long counts; // counts
	private String respTime; // resp_time
	private Long size; // size
	private String reqDate; // req_date
	private String beginDate;
	private String endDate;

	public OdsNginxTourism() {
		super();
	}

	public OdsNginxTourism(String id) {
		super(id);
	}

	@Length(min = 0, max = 20, message = "app_name长度必须介于 0 和 20 之间")
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Length(min = 0, max = 20, message = "server_ip长度必须介于 0 和 20 之间")
	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	@Length(min = 0, max = 20, message = "req_time长度必须介于 0 和 20 之间")
	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	@Length(min = 0, max = 20, message = "http_status长度必须介于 0 和 20 之间")
	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Length(min = 0, max = 255, message = "req_url_path长度必须介于 0 和 255 之间")
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

	public String getRespTime() {
		return respTime;
	}

	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	@Length(min = 0, max = 20, message = "req_date长度必须介于 0 和 20 之间")
	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getBeginDate() {
		if (StringUtils.isBlank(beginDate)) {
			beginDate = DateUtils.getDate();
		}
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		if (StringUtils.isBlank(endDate)) {
			endDate = DateUtils.getDate();
		}
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}