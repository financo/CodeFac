//------------------------------------------------------------------------------
// <auto-generated>
//     此代码由模板自动生成 - 2016-03-25 15:47:32
//     对此文件的更改可能会导致不正确的行为，并且如果 重新生成代码，这些更改将会丢失。
// </auto-generated>
//------------------------------------------------------------------------------
package com.bonc.quickframework.web.action.original;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bonc.quickframework.bean.GenControlerMethodBean;
import com.bonc.quickframework.bean.ResultInfo;
import com.bonc.quickframework.entity.GenControlerMethod;
import com.bonc.quickframework.service.IGenControlerMethodService;
import com.bonc.quickframework.util.*;

import java.util.*;

/**
 * @author dguanlin email:dguanlin(a)163.com
 * @version 1.0
 * @since 1.0
 */
 
public class AbstractGenControlerMethodAction extends BaseAction {
	
	GenControlerMethodBean bean=new GenControlerMethodBean();
	
	@Resource(name = "genControlerMethodService")
	protected IGenControlerMethodService genControlerMethodService;


	public GenControlerMethodBean getBean() {
		return bean;
	}

	public void setBean(GenControlerMethodBean bean) {
		this.bean = bean;
	}
	
	public String list() {
		List dataList = this.genControlerMethodService.findList(this.getBean());
		this.getBean().setObjectList(dataList);
		return "list";
	}
	public String add() {
		return "add";
	}
	public String addDo() {
		this.genControlerMethodService.saveOrUpdate(this.getBean().getGenControlerMethod());
		return SUCCESS;
	}
	public String edit() {
		GenControlerMethod genControlerMethod=this.genControlerMethodService.findById(this.getBean().getGenControlerMethod().getId());
		this.getBean().setGenControlerMethod(genControlerMethod);
		return "edit";
	}
	public String editDo() {
		this.genControlerMethodService.saveOrUpdate(this.getBean().getGenControlerMethod());
		return SUCCESS;
	}
	public String delete() {
		this.genControlerMethodService.delete(this.getBean().getGenControlerMethod().getId());
		return SUCCESS;
	}
	
	/**
	 * 异步删除
	 */
	public void asyncDeleteAll() {
		try {
			String idString = this.getBean().getIdList();
			if(idString == null || "".endsWith(idString.trim())){
				ServletUtil.sendAsJson(response,new ResultInfo(false,"id is null").toJSONString() );
			}else{
				List<Long> ids = new ArrayList<Long>();
				String[] tmps = idString.split(",");
				for (String tmp : tmps) {
					if(tmp!=null && !"".equals(tmp.trim())){
						ids.add(Long.parseLong(tmp));
					}
				}
				this.genControlerMethodService.deleteByCollection(this.genControlerMethodService.findList(ids));
			}
			ServletUtil.sendAsJson(response,new ResultInfo(true,"删除成功").toJSONString() );
		} catch (Exception e) {
			e.printStackTrace();
			ServletUtil.sendAsJson(response,new ResultInfo(false,e.getMessage()).toJSONString() );
		}
	}
	
}
