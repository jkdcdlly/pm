/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tourism.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.tourism.entity.OdsNginxTourism;
import com.thinkgem.jeesite.modules.tourism.dao.OdsNginxTourismDao;

/**
 * 旅游所有项目Service
 * @author 陈志磊
 * @version 2015-07-24
 */
@Service
@Transactional(readOnly = true)
public class OdsNginxTourismService extends CrudService<OdsNginxTourismDao, OdsNginxTourism> {

	public OdsNginxTourism get(String id) {
		return super.get(id);
	}
	
	public List<OdsNginxTourism> findList(OdsNginxTourism odsNginxTourism) {
		return super.findList(odsNginxTourism);
	}
	
	public Page<OdsNginxTourism> findPage(Page<OdsNginxTourism> page, OdsNginxTourism odsNginxTourism) {
		return super.findPage(page, odsNginxTourism);
	}
	
	@Transactional(readOnly = false)
	public void save(OdsNginxTourism odsNginxTourism) {
		super.save(odsNginxTourism);
	}
	
	@Transactional(readOnly = false)
	public void delete(OdsNginxTourism odsNginxTourism) {
		super.delete(odsNginxTourism);
	}
	
}