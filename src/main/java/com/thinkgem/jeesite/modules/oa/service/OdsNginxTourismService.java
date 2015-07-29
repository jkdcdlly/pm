/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.oa.dao.OdsNginxTourismDao;
import com.thinkgem.jeesite.modules.oa.entity.OdsNginxTourism;

/**
 * 旅游项目Service
 * 
 * @author chenzhilei
 * @version 2015-07-26
 */
@Service
@Transactional(readOnly = true)
public class OdsNginxTourismService extends CrudService<OdsNginxTourismDao, OdsNginxTourism> {
	@Autowired
	private OdsNginxTourismDao odsNginxTourismDao;

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

	public List<OdsNginxTourism> findListByApp(OdsNginxTourism odsNginxTourism) {
		return odsNginxTourismDao.findListByApp(odsNginxTourism);
	}

	public Map<String, List<OdsNginxTourism>> findMapAllApp(OdsNginxTourism odsNginxTourism) {
		Map<String, List<OdsNginxTourism>> map = new HashMap<String, List<OdsNginxTourism>>();
		List<String> appNames = odsNginxTourismDao.findAppList(odsNginxTourism);
		for (String appName : appNames) {
			odsNginxTourism.setAppName(appName);
			map.put(appName, odsNginxTourismDao.findListByApp(odsNginxTourism));
		}
		return map;
	}

	public List<String> findAppList(OdsNginxTourism odsNginxTourism) {
		return odsNginxTourismDao.findAppList(odsNginxTourism);
	}

	public List<OdsNginxTourism> findListByserverIP(OdsNginxTourism odsNginxTourism) {
		return odsNginxTourismDao.findListByserverIP(odsNginxTourism);
	}

	public Map<String, List<OdsNginxTourism>> findListByserverIPAndReqTime(OdsNginxTourism odsNginxTourism) {
		Map<String, List<OdsNginxTourism>> map = new HashMap<String, List<OdsNginxTourism>>();
		List<String> serverIps = odsNginxTourismDao.findserverIPByAppName(odsNginxTourism);
		for (String serverIp : serverIps) {
			odsNginxTourism.setServerIp(serverIp);
			map.put(serverIp, odsNginxTourismDao.findListByserverIPAndReqTime(odsNginxTourism));
		}
		return map;
	}
}