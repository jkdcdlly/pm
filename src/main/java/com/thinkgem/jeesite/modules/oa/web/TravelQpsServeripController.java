/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.web;

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
import com.thinkgem.jeesite.modules.oa.entity.TravelQpsServerip;
import com.thinkgem.jeesite.modules.oa.service.TravelQpsServeripService;

/**
 * 主机分析Controller
 * 
 * @author chenzhilei
 * @version 2015-07-08
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/travelQpsServerip")
public class TravelQpsServeripController extends BaseController {

	@Autowired
	private TravelQpsServeripService travelQpsServeripService;

	@ModelAttribute
	public TravelQpsServerip get(@RequestParam(required = false) String id) {
		TravelQpsServerip entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = travelQpsServeripService.get(id);
		}
		if (entity == null) {
			entity = new TravelQpsServerip();
		}
		return entity;
	}

	@RequiresPermissions("oa:travelQpsServerip:view")
	@RequestMapping(value = { "list", "" })
	public String list(TravelQpsServerip travelQpsServerip, HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("vo", travelQpsServerip);
		return "modules/oa/travelQpsServeripList";
	}

	@ResponseBody
	@RequiresPermissions("oa:travelQpsServerip:view")
	@RequestMapping(value = { "pieChart", "" })
	public String pieChart(TravelQpsServerip travelQpsServerip, HttpServletRequest request, HttpServletResponse response, Model model) {
		return JsonMapper.getInstance().toJson(travelQpsServeripService.pieChart(travelQpsServerip));
	}

	@ResponseBody
	@RequiresPermissions("oa:travelQpsServerip:view")
	@RequestMapping(value = { "lineChart", "" })
	public List<TravelQpsServerip> lineChart(TravelQpsServerip travelQpsServerip, HttpServletRequest request, HttpServletResponse response, Model model) {
		return travelQpsServeripService.lineChart(travelQpsServerip);
	}

	@ResponseBody
	@RequiresPermissions("oa:travelQpsServerip:view")
	@RequestMapping(value = { "findList", "" })
	public List<TravelQpsServerip> findList(TravelQpsServerip travelQpsServerip, HttpServletRequest request, HttpServletResponse response, Model model) {
		return travelQpsServeripService.findList(travelQpsServerip);
	}

	@RequiresPermissions("oa:travelQpsServerip:view")
	@RequestMapping(value = "form")
	public String form(TravelQpsServerip travelQpsServerip, Model model) {
		model.addAttribute("travelQpsServerip", travelQpsServerip);
		return "modules/oa/travelQpsServeripForm";
	}

	@RequiresPermissions("oa:travelQpsServerip:edit")
	@RequestMapping(value = "save")
	public String save(TravelQpsServerip travelQpsServerip, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, travelQpsServerip)) {
			return form(travelQpsServerip, model);
		}
		travelQpsServeripService.save(travelQpsServerip);
		addMessage(redirectAttributes, "保存主机分析成功");
		return "redirect:" + Global.getAdminPath() + "/oa/travelQpsServerip/?repage";
	}

	@RequiresPermissions("oa:travelQpsServerip:edit")
	@RequestMapping(value = "delete")
	public String delete(TravelQpsServerip travelQpsServerip, RedirectAttributes redirectAttributes) {
		travelQpsServeripService.delete(travelQpsServerip);
		addMessage(redirectAttributes, "删除主机分析成功");
		return "redirect:" + Global.getAdminPath() + "/oa/travelQpsServerip/?repage";
	}

}