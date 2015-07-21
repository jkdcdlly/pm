/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.oa.entity.Concurrence;

/**
 * ceshiDAO接口
 * @author chenzhilei
 * @version 2015-07-02
 */
@MyBatisDao
public interface ConcurrenceDao extends CrudDao<Concurrence> {
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public List<Concurrence> findChart(Concurrence entity);
}