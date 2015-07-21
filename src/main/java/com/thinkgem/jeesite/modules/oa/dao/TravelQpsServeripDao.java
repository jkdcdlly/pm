/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.oa.entity.TravelQpsServerip;

/**
 * 主机分析DAO接口
 * 
 * @author chenzhilei
 * @version 2015-07-08
 */
@MyBatisDao
public interface TravelQpsServeripDao extends CrudDao<TravelQpsServerip> {
	public List<TravelQpsServerip> pieList(TravelQpsServerip travelQpsServerip);

	public List<TravelQpsServerip> lineChart(TravelQpsServerip travelQpsServerip);
}