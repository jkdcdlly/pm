/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.oa.entity.Concurrence;
import com.thinkgem.jeesite.modules.oa.dao.ConcurrenceDao;

/**
 * ceshiService
 * 
 * @author chenzhilei
 * @version 2015-07-02
 */
@Service
@Transactional(readOnly = true)
public class ConcurrenceService extends CrudService<ConcurrenceDao, Concurrence> {

	public Concurrence get(String id) {
		return super.get(id);
	}

	public List<Concurrence> findList(Concurrence concurrence) {
		List<Concurrence> list = super.findList(concurrence);
		byte[] bytes = new byte[288];
		List<Concurrence> list2 = new ArrayList<Concurrence>(288);
		for (int i = 0; i < list2.size(); i++) {
			Concurrence c = list.get(i);
			c.getTime();
		}

		return list;

	}

	public Page<Concurrence> findPage(Page<Concurrence> page, Concurrence concurrence) {
		return super.findPage(page, concurrence);
	}

	@Transactional(readOnly = false)
	public void save(Concurrence concurrence) {
		super.save(concurrence);
	}

	@Transactional(readOnly = false)
	public void delete(Concurrence concurrence) {
		super.delete(concurrence);
	}

}