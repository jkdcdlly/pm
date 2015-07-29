/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.SysDefinedApp;
import com.thinkgem.jeesite.modules.sys.service.SysDefinedAppService;

/**
 * 自定义应用Controller
 * @author 陈志磊
 * @version 2015-07-29
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysDefinedApp")
public class SysDefinedAppController extends BaseController {

	@Autowired
	private SysDefinedAppService sysDefinedAppService;
	
	@ModelAttribute
	public SysDefinedApp get(@RequestParam(required=false) String id) {
		SysDefinedApp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysDefinedAppService.get(id);
		}
		if (entity == null){
			entity = new SysDefinedApp();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysDefinedApp:edit")
	@RequestMapping(value = {"list", ""})
	public String list(SysDefinedApp sysDefinedApp, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysDefinedApp> page = sysDefinedAppService.findPage(new Page<SysDefinedApp>(request, response), sysDefinedApp); 
		model.addAttribute("page", page);
		return "modules/sys/sysDefinedAppList";
	}

	@RequiresPermissions("sys:sysDefinedApp:view")
	@RequestMapping(value = "form")
	public String form(SysDefinedApp sysDefinedApp, Model model) {
		model.addAttribute("sysDefinedApp", sysDefinedApp);
		return "modules/sys/sysDefinedAppForm";
	}

	@RequiresPermissions("sys:sysDefinedApp:edit")
	@RequestMapping(value = "save")
	public String save(SysDefinedApp sysDefinedApp, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysDefinedApp)){
			return form(sysDefinedApp, model);
		}
		sysDefinedAppService.save(sysDefinedApp);
		addMessage(redirectAttributes, "保存自定义应用成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysDefinedApp/?repage";
	}
	
	@RequiresPermissions("sys:sysDefinedApp:edit")
	@RequestMapping(value = "delete")
	public String delete(SysDefinedApp sysDefinedApp, RedirectAttributes redirectAttributes) {
		sysDefinedAppService.delete(sysDefinedApp);
		addMessage(redirectAttributes, "删除自定义应用成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysDefinedApp/?repage";
	}

}