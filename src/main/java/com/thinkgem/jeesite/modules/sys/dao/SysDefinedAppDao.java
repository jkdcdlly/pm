/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.SysDefinedApp;

/**
 * 自定义应用DAO接口
 * @author 陈志磊
 * @version 2015-07-29
 */
@MyBatisDao
public interface SysDefinedAppDao extends CrudDao<SysDefinedApp> {
	
}