/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 旅游qpsEntity
 * @author chenzhilei
 * @version 2015-07-07
 */
public class TravelQpsUrl extends DataEntity<TravelQpsUrl> {
	
	private static final long serialVersionUID = 1L;
	private Date time;		// time
	private String requestUrl;		// request_url
	private Long num;		// num
	
	public TravelQpsUrl() {
		super();
	}

	public TravelQpsUrl(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="time不能为空")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Length(min=1, max=100, message="request_url长度必须介于 1 和 100 之间")
	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}