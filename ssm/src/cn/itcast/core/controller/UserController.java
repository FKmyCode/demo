package cn.itcast.core.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.pojo.User;
import cn.itcast.core.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@RequestMapping("/list")
	public String list(){
		return "list";
	}*/
	@RequestMapping("goInsert")
	public String goInsert(){
		return "insert";
	}
	
	@RequestMapping("/insert.action")
	public String save(String name,String birthday) throws Exception{
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sim.parse(birthday);
		User user = new User();
		user.setName(name);
		user.setBirthday(date);
		userService.save(user);
		return "success";
	}
	
	@RequestMapping("/goSearch")
	public String goSearch(){
		return "list";
	}
	@RequestMapping("/search")
	public String search(String searchString,Model model) throws Exception{
		List<User> list = userService.search(searchString);
		model.addAttribute("userList", list);
		return "list";
	}
}
