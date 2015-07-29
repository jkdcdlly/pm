/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SysDefinedApp;
import com.thinkgem.jeesite.modules.sys.dao.SysDefinedAppDao;

/**
 * 自定义应用Service
 * @author 陈志磊
 * @version 2015-07-29
 */
@Service
@Transactional(readOnly = true)
public class SysDefinedAppService extends CrudService<SysDefinedAppDao, SysDefinedApp> {

	public SysDefinedApp get(String id) {
		return super.get(id);
	}
	
	public List<SysDefinedApp> findList(SysDefinedApp sysDefinedApp) {
		return super.findList(sysDefinedApp);
	}
	
	public Page<SysDefinedApp> findPage(Page<SysDefinedApp> page, SysDefinedApp sysDefinedApp) {
		return super.findPage(page, sysDefinedApp);
	}
	
	@Transactional(readOnly = false)
	public void save(SysDefinedApp sysDefinedApp) {
		super.save(sysDefinedApp);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysDefinedApp sysDefinedApp) {
		super.delete(sysDefinedApp);
	}
	
}