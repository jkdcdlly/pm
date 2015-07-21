/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.oa.entity.Pie;
import com.thinkgem.jeesite.modules.oa.entity.TravelQpsServerip;
import com.thinkgem.jeesite.modules.oa.dao.TravelQpsServeripDao;

/**
 * 主机分析Service
 * 
 * @author chenzhilei
 * @version 2015-07-08
 */
@Service
@Transactional(readOnly = true)
public class TravelQpsServeripService extends CrudService<TravelQpsServeripDao, TravelQpsServerip> {

	public TravelQpsServerip get(String id) {
		return super.get(id);
	}

	public List<TravelQpsServerip> findList(TravelQpsServerip travelQpsServerip) {
		return super.findList(travelQpsServerip);
	}

	public List<TravelQpsServerip> lineChart(TravelQpsServerip travelQpsServerip) {
		return dao.lineChart(travelQpsServerip);
	}

	public List<Pie> pieChart(TravelQpsServerip travelQpsServerip) {
		List<TravelQpsServerip> list = dao.pieList(travelQpsServerip);
		List<Pie> newList = new ArrayList<Pie>();
		for (TravelQpsServerip tqs : list) {
			Pie pie = new Pie();
			pie.setName(tqs.getServerip());
			pie.setY(tqs.getPv());
			newList.add(pie);
		}
		return newList;
	}

	public Page<TravelQpsServerip> findPage(Page<TravelQpsServerip> page, TravelQpsServerip travelQpsServerip) {
		return super.findPage(page, travelQpsServerip);
	}

	@Transactional(readOnly = false)
	public void save(TravelQpsServerip travelQpsServerip) {
		super.save(travelQpsServerip);
	}

	@Transactional(readOnly = false)
	public void delete(TravelQpsServerip travelQpsServerip) {
		super.delete(travelQpsServerip);
	}

}