/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 自定义应用Entity
 * 
 * @author 陈志磊
 * @version 2015-07-29
 */
public class SysDefinedApp extends DataEntity<SysDefinedApp> {

	private static final long serialVersionUID = 1L;
	private String appType; // app_type
	private String appName; // app_name

	public SysDefinedApp() {
		super();
	}

	public SysDefinedApp(String id) {
		super(id);
	}

	@Length(min = 0, max = 20, message = "app_type长度必须介于 0 和 20 之间")
	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	@Length(min = 0, max = 20, message = "app_name长度必须介于 0 和 20 之间")
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}