/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * ceshiEntity
 * @author chenzhilei
 * @version 2015-07-02
 */
public class Concurrence extends DataEntity<Concurrence> {
	
	private static final long serialVersionUID = 1L;
	private String time;		// time
	private Integer num;		// num
	private String inDate;		// in_date
	
	public Concurrence() {
		super();
	}

	public Concurrence(String id){
		super(id);
	}

	@Length(min=0, max=64, message="time长度必须介于 0 和 64 之间")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	@Length(min=0, max=64, message="in_date长度必须介于 0 和 64 之间")
	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	
}