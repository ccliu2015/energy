package com.energy.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.energy.weixin.mapper.UserMapper;

/** 
 * @ClassName: AbsentController 
 * @Description: 请假相关请求处理器
 * @author CCLIU 
 * @date 2015-6-11 上午11:05:22 
 * v1.0
 */
@Controller
@RequestMapping(value = "/weixin")
public class AbsentController {

	private UserMapper userMapper = null;

	@Autowired
	public void setMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		String name = userMapper.getAllUser().get(0).getUserName();
		model.addAttribute("myparam", name);
		return "hello";
	}
	
	@RequestMapping(value = "mypage",method = RequestMethod.GET)
	public String myPage(ModelMap model) {
		model.addAttribute("myparam", "1111");
		return "mypage";
	}

}