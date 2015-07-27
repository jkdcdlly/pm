/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.oa.entity.OdsNginxTourism;

/**
 * 旅游项目DAO接口
 * 
 * @author chenzhilei
 * @version 2015-07-26
 */
@MyBatisDao
public interface OdsNginxTourismDao extends CrudDao<OdsNginxTourism> {
	/**
	 * 
	 * @param odsNginxTourism
	 * @return
	 */
	public List<OdsNginxTourism> findListByApp(OdsNginxTourism odsNginxTourism);

	/**
	 * 查询所有应用名称
	 * 
	 * @return
	 */
	public List<String> findAppList(OdsNginxTourism odsNginxTourism);
}