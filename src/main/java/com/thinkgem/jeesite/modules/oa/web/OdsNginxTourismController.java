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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.oa.entity.OdsNginxTourism;
import com.thinkgem.jeesite.modules.oa.service.OdsNginxTourismService;

/**
 * 旅游项目Controller
 * 
 * @author chenzhilei
 * @version 2015-07-26
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/odsNginxTourism")
public class OdsNginxTourismController extends BaseController {

	@Autowired
	private OdsNginxTourismService odsNginxTourismService;

	@ModelAttribute
	public OdsNginxTourism get(@RequestParam(required = false) String id) {
		OdsNginxTourism entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = odsNginxTourismService.get(id);
		}
		if (entity == null) {
			entity = new OdsNginxTourism();
		}
		return entity;
	}

	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = { "list", "" })
	public String list(OdsNginxTourism odsNginxTourism, HttpServletRequest request, HttpServletResponse response, Model model) {
		// Page<OdsNginxTourism> page = odsNginxTourismService.findPage(new
		// Page<OdsNginxTourism>(request, response), odsNginxTourism);
		// model.addAttribute("page", page);
		return "modules/oa/odsNginxTourismList";
	}

	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = { "findListByApp", "" })
	@ResponseBody
	public List<OdsNginxTourism> findListByApp(OdsNginxTourism odsNginxTourism, HttpServletRequest request, HttpServletResponse response, Model model) {
		return odsNginxTourismService.findListByApp(odsNginxTourism);
	}

	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = "form")
	public String form(OdsNginxTourism odsNginxTourism, Model model) {
		if (StringUtils.isBlank(odsNginxTourism.getReqDate()))
			odsNginxTourism.setReqDate("2015-06-30");
		model.addAttribute("appNameList", odsNginxTourismService.findAppList(odsNginxTourism));
		return "modules/oa/odsNginxTourismForm";
	}

	@RequiresPermissions("oa:odsNginxTourism:edit")
	@RequestMapping(value = "save")
	public String save(OdsNginxTourism odsNginxTourism, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, odsNginxTourism)) {
			return form(odsNginxTourism, model);
		}
		odsNginxTourismService.save(odsNginxTourism);
		addMessage(redirectAttributes, "保存旅游项目成功");
		return "redirect:" + Global.getAdminPath() + "/oa/odsNginxTourism/?repage";
	}

	@RequiresPermissions("oa:odsNginxTourism:edit")
	@RequestMapping(value = "delete")
	public String delete(OdsNginxTourism odsNginxTourism, RedirectAttributes redirectAttributes) {
		odsNginxTourismService.delete(odsNginxTourism);
		addMessage(redirectAttributes, "删除旅游项目成功");
		return "redirect:" + Global.getAdminPath() + "/oa/odsNginxTourism/?repage";
	}

}