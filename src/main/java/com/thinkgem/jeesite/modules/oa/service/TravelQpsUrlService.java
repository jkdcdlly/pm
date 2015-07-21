/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.oa.entity.TravelQpsUrl;
import com.thinkgem.jeesite.modules.oa.dao.TravelQpsUrlDao;

/**
 * 旅游qpsService
 * 
 * @author chenzhilei
 * @version 2015-07-07
 */
@Service
@Transactional(readOnly = true)
public class TravelQpsUrlService extends CrudService<TravelQpsUrlDao, TravelQpsUrl> {

	public TravelQpsUrl get(String id) {
		return super.get(id);
	}

	public List<TravelQpsUrl> findList(TravelQpsUrl travelQpsUrl) {
		return super.findList(travelQpsUrl);
	}

	public Page<TravelQpsUrl> findPage(Page<TravelQpsUrl> page, TravelQpsUrl travelQpsUrl) {
		return super.findPage(page, travelQpsUrl);
	}

	@Transactional(readOnly = false)
	public void save(TravelQpsUrl travelQpsUrl) {
		super.save(travelQpsUrl);
	}

	@Transactional(readOnly = false)
	public void delete(TravelQpsUrl travelQpsUrl) {
		super.delete(travelQpsUrl);
	}

}