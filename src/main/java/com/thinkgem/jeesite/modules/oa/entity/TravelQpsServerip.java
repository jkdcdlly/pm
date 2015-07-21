/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.entity;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.DateUtils;

/**
 * 主机分析Entity
 * 
 * @author chenzhilei
 * @version 2015-07-08
 */
public class TravelQpsServerip extends DataEntity<TravelQpsServerip> {

	private static final long serialVersionUID = 1L;
	private String serverip; // serverIP
	private Long pv; // 访问量
	private String time; // 访问时间，格式：2015-07-08 10:02:10
	private String date; // 访问日期，格式：2015-07-06

	public TravelQpsServerip() {
		super();
	}

	public TravelQpsServerip(String id) {
		super(id);
	}

	@Length(min = 0, max = 20, message = "serverIP长度必须介于 0 和 20 之间")
	public String getServerip() {
		return serverip;
	}

	public void setServerip(String serverip) {
		this.serverip = serverip;
	}

	public Long getPv() {
		return pv;
	}

	public void setPv(Long pv) {
		this.pv = pv;
	}

	@Length(min = 0, max = 20, message = "访问时间，格式：2015-07-08 10:02:10长度必须介于 0 和 20 之间")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Length(min = 0, max = 10, message = "访问日期，格式：2015-07-06长度必须介于 0 和 10 之间")
	public String getDate() {
		if (StringUtils.isBlank(date)) {
			return DateUtils.getDate();
		}
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}