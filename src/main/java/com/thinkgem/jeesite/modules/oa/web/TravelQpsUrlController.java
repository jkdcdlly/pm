/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.oa.web;

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
import com.thinkgem.jeesite.modules.oa.entity.TravelQpsUrl;
import com.thinkgem.jeesite.modules.oa.service.TravelQpsUrlService;

/**
 * 旅游qpsController
 * @author chenzhilei
 * @version 2015-07-07
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/travelQpsUrl")
public class TravelQpsUrlController extends BaseController {

	@Autowired
	private TravelQpsUrlService travelQpsUrlService;
	
	@ModelAttribute
	public TravelQpsUrl get(@RequestParam(required=false) String id) {
		TravelQpsUrl entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = travelQpsUrlService.get(id);
		}
		if (entity == null){
			entity = new TravelQpsUrl();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:travelQpsUrl:view")
	@RequestMapping(value = {"list", ""})
	public String list(TravelQpsUrl travelQpsUrl, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TravelQpsUrl> page = travelQpsUrlService.findPage(new Page<TravelQpsUrl>(request, response), travelQpsUrl); 
		model.addAttribute("page", page);
		return "modules/oa/travelQpsUrlList";
	}

	@RequiresPermissions("oa:travelQpsUrl:view")
	@RequestMapping(value = "form")
	public String form(TravelQpsUrl travelQpsUrl, Model model) {
		model.addAttribute("travelQpsUrl", travelQpsUrl);
		return "modules/oa/travelQpsUrlForm";
	}

	@RequiresPermissions("oa:travelQpsUrl:edit")
	@RequestMapping(value = "save")
	public String save(TravelQpsUrl travelQpsUrl, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, travelQpsUrl)){
			return form(travelQpsUrl, model);
		}
		travelQpsUrlService.save(travelQpsUrl);
		addMessage(redirectAttributes, "保存旅游qps成功");
		return "redirect:"+Global.getAdminPath()+"/oa/travelQpsUrl/?repage";
	}
	
	@RequiresPermissions("oa:travelQpsUrl:edit")
	@RequestMapping(value = "delete")
	public String delete(TravelQpsUrl travelQpsUrl, RedirectAttributes redirectAttributes) {
		travelQpsUrlService.delete(travelQpsUrl);
		addMessage(redirectAttributes, "删除旅游qps成功");
		return "redirect:"+Global.getAdminPath()+"/oa/travelQpsUrl/?repage";
	}

}