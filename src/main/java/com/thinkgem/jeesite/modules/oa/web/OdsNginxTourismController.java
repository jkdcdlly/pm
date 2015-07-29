/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.web;

import java.util.List;
import java.util.Map;

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
		model.addAttribute("appNameList", odsNginxTourismService.findAppList(odsNginxTourism));
		model.addAttribute("ods", odsNginxTourism);
		return "modules/oa/odsNginxTourismList";
	}

	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = "form")
	public String form(OdsNginxTourism odsNginxTourism, Model model) {
		model.addAttribute("appNameList", odsNginxTourismService.findAppList(odsNginxTourism));
		model.addAttribute("ods", odsNginxTourism);
		return "modules/oa/odsNginxTourismForm";
	}

	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = "history")
	public String history(OdsNginxTourism odsNginxTourism, Model model) {
		model.addAttribute("appNameList", odsNginxTourismService.findAppList(odsNginxTourism));
		model.addAttribute("ods", odsNginxTourism);
		return "modules/oa/odsNginxTourismHistory";
	}

	// ===========================================以下为@ResponseBody==========================================
	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = { "findListByApp", "" })
	@ResponseBody
	public Map<String, List<OdsNginxTourism>> findListByApp(OdsNginxTourism odsNginxTourism, HttpServletRequest request, HttpServletResponse response, Model model) {
		return odsNginxTourismService.findMapAllApp(odsNginxTourism);
	}

	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = { "findListByserverIP", "" })
	@ResponseBody
	public List<OdsNginxTourism> findListByserverIP(OdsNginxTourism odsNginxTourism, HttpServletRequest request, HttpServletResponse response, Model model) {
		return odsNginxTourismService.findListByserverIP(odsNginxTourism);
	}

	@RequiresPermissions("oa:odsNginxTourism:view")
	@RequestMapping(value = { "findListByserverIPAndReqTime", "" })
	@ResponseBody
	public Map<String, List<OdsNginxTourism>> findListByserverIPAndReqTime(OdsNginxTourism odsNginxTourism, HttpServletRequest request, HttpServletResponse response, Model model) {
		return odsNginxTourismService.findListByserverIPAndReqTime(odsNginxTourism);
	}

}