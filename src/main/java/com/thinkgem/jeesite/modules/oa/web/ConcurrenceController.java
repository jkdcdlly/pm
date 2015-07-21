/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.oa.entity.Concurrence;
import com.thinkgem.jeesite.modules.oa.service.ConcurrenceService;

/**
 * ceshiController
 * 
 * @author chenzhilei
 * @version 2015-07-02
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/concurrence")
public class ConcurrenceController extends BaseController {

	@Autowired
	private ConcurrenceService concurrenceService;

	@ModelAttribute
	public Concurrence get(@RequestParam(required = false) String id) {
		Concurrence entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = concurrenceService.get(id);
		}
		if (entity == null) {
			entity = new Concurrence();
		}
		return entity;
	}

	@RequiresPermissions("oa:concurrence:view")
	@RequestMapping(value = { "list", "" })
	public String list(Concurrence concurrence, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "modules/oa/concurrenceList";
	}

	@ResponseBody
	@RequiresPermissions("oa:concurrence:view")
	@RequestMapping(value = { "lineChart", "" })
	public List<Concurrence>  lineChart(Concurrence concurrence, HttpServletRequest request, HttpServletResponse response, Model model) {
		return concurrenceService.findList(concurrence);
	}
	@ResponseBody
	@RequiresPermissions("oa:concurrence:view")
	@RequestMapping(value = { "pieChart", "" })
	public List<Concurrence>  pieChart(Concurrence concurrence, HttpServletRequest request, HttpServletResponse response, Model model) {
		return concurrenceService.findList(concurrence);
	}
	
	private String getJson(List<Concurrence> list) {
		List<Integer> nums = new ArrayList<Integer>(24 * 60 / 5);
		for (int i = 0; i < list.size(); i++) {
			nums.add(list.get(i).getNum());
		}
		return JsonMapper.nonDefaultMapper().toJson(nums);
	}

	@RequiresPermissions("oa:concurrence:view")
	@RequestMapping(value = "form")
	public String form(Concurrence concurrence, Model model) {
		model.addAttribute("concurrence", concurrence);
		return "modules/oa/concurrenceForm";
	}

	@RequiresPermissions("oa:concurrence:edit")
	@RequestMapping(value = "save")
	public String save(Concurrence concurrence, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, concurrence)) {
			return form(concurrence, model);
		}
		concurrenceService.save(concurrence);
		addMessage(redirectAttributes, "保存ceshi成功");
		return "redirect:" + Global.getAdminPath() + "/oa/concurrence/?repage";
	}

	@RequiresPermissions("oa:concurrence:edit")
	@RequestMapping(value = "delete")
	public String delete(Concurrence concurrence, RedirectAttributes redirectAttributes) {
		concurrenceService.delete(concurrence);
		addMessage(redirectAttributes, "删除ceshi成功");
		return "redirect:" + Global.getAdminPath() + "/oa/concurrence/?repage";
	}

}