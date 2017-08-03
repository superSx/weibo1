package com.core.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.core.dao.UserDaoImp;
import com.core.domin.LoginBean;
import com.core.domin.RegistBean;
import com.core.domin.User;
import com.core.json.ValidPswJson;
import com.core.util.DateUtil;

@Controller
public class UserAction {
	@Autowired
	private UserDaoImp userDao;
	private static Log log=LogFactory.getLog(BannerAction.class);
	@RequestMapping("/setting")
	public ModelAndView settinggs(HttpSession session){
		ModelAndView view=new ModelAndView();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginUser");
		Map<String, Object> userinfo=userDao.findUserMapByName(loginBean.getLoginName());
		List<String> sexList=new ArrayList<>();
		sexList.add("男");
		sexList.add("女");
		view.addObject("userInfo",userinfo);
		view.addObject("sexList",sexList);
		view.addObject("user",userDao.mapToObj(userinfo));
		view.setViewName("/Setting/user");
		return view;
	}
	@RequestMapping("/editWorkinfo")
	public ModelAndView editWorkinfo(HttpSession session){
		ModelAndView view=new ModelAndView();
		List<Integer> years=getYears();
		User user=getUser(session);
		view.addObject("user",user);
		view.addObject("years",years);
		view.setViewName("/Setting/workinfo");
		return view;
	}
	@RequestMapping("/updateWorkinfo")
	public ModelAndView updateWorkinfo(User user,HttpSession session){
		ModelAndView view=new ModelAndView();
		
		user.setUserId((Integer) session.getAttribute("userId"));
		userDao.update(user);
		view.setViewName("/Setting/workinfo");
		return view;
		
	}
	@RequestMapping("/editEducationinfo")
	public ModelAndView editEducationinfo(HttpSession session){
		ModelAndView view=new ModelAndView();
		List<Integer> years=getYears();
		User user=getUser(session);
		Map<String, Integer> types=schoolTypes();
		view.addObject("types",types);
		view.addObject("user",user);
		view.addObject("years",years);
		view.setViewName("Setting/educationinfo");
		return view;
	}
	@RequestMapping("/updateEducationinfo")
	public ModelAndView updateEducationinfo(User user,HttpSession session){
		ModelAndView view=new ModelAndView();
		Map<String, Integer> types=schoolTypes();
		view.addObject("types",types);
		log.info("当前user内容:"+user);
		user.setUserId((Integer) session.getAttribute("userId"));
		userDao.update(user);
		view.setViewName("Setting/educationinfo");
		return view;
	}
	@RequestMapping("/editPassword")
	public ModelAndView editPassword(){
		ModelAndView view=new ModelAndView();
		view.setViewName("/Setting/editpassword");
		return view;
	}
	@RequestMapping(value={"/validateOldPassword"})
	@ResponseBody
	public String validateOldPassword(HttpServletRequest req,HttpSession session){
		LoginBean loginBean=(LoginBean) session.getAttribute("loginUser");
		String old=req.getParameter("oldpassword");
		ValidPswJson vJson=new ValidPswJson();
		
		log.info(old);
		if (old.equals(loginBean.getAssword())) {
			vJson.setIsPass(true);
		}else{
			vJson.setIsPass(false);
		}
		return JSONObject.toJSONString(vJson);
	}
	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(HttpServletRequest req,HttpSession session){
		ModelAndView view=new ModelAndView();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginUser");
		String password=req.getParameter("confirmpasswprd");
		loginBean.setAssword(password);
		userDao.updateLogin(loginBean);
		view.setViewName("/Setting/editpassword");
		return view;
	}
	@RequestMapping("/updateUser")
	public ModelAndView settingSave(User user,HttpSession session){
		ModelAndView view=new ModelAndView();
		user.setUserId((int)session.getAttribute("userId"));
		userDao.update(user);
		view.setViewName("Setting/user");
		return view;
	}
	
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public ModelAndView registerForm(){
		ModelAndView view=new ModelAndView();
		RegistBean registBean=new RegistBean();
		List<String> sexList=new ArrayList<>();
		sexList.add("男");
		sexList.add("女");
		view.addObject("sexList",sexList);
		view.addObject("registBean",registBean);
		view.setViewName("regist");
		return view;
	}
	@RequestMapping("/regist")
	public ModelAndView regist(RegistBean registBean,HttpServletRequest req,HttpSession session){
		ModelAndView view=new ModelAndView();
		System.out.println(registBean);
		if (userDao.regist(registBean)) {
			view.setViewName("/backup/login");
		}else{
			String errMsg="注册失败，请重新注册";
			view.addObject("errMsg", errMsg);
			view.setViewName("/regist");
		}
		return view;
	}
	@RequestMapping("/otherProfile")
	public ModelAndView profile(HttpServletRequest req){
		ModelAndView view=new ModelAndView();
		String loginName=req.getParameter("loginName");
		userDao.queryUserByName(loginName);
		view.setViewName("/Others/othersProfile");
		return view;
	}
	public User getUser(HttpSession session){
		LoginBean loginBean=(LoginBean) session.getAttribute("loginUser");
		Map<String, Object> userinfo=userDao.findUserMapByName(loginBean.getLoginName());
		return userDao.mapToObj(userinfo);
	}
	public List<Integer> getYears(){
		int year=DateUtil.getYear();
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<=100;i++){
			list.add(year-i);
		}
		return list;
	}
	public Map<String, Integer> schoolTypes(){
		Map<String, Integer> map=new HashMap<>();
		map.put("大学",1);
		map.put("高中",2);
		map.put("初中",3);
		map.put("小学",4);
		map.put("中专", 5);
		return map;
		
	}
}
