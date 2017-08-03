package com.core.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.core.dao.ProfileDao;
import com.core.dao.UserDaoImp;
import com.core.domin.LoginBean;
import com.core.domin.PageBean;
import com.core.domin.Profile;

@Controller
public class LoginAction {
	@Autowired
	private UserDaoImp userDaoImp;
	@Autowired
	private ProfileDao profileDao;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	@RequestMapping("/initLogin")
	public ModelAndView initLogin(){
		List<Map<String, Object>> userList=userDaoImp.queryFirst3();
		List<Map<String, Object>> funnyUser=userDaoImp.queryFunny3();
		List<Map<String, Object>> msgs=userDaoImp.currentMsgs();
		for (Map<String, Object> user : userList) {
			if (user.get("sex").equals("1")) {
				user.put("sex", "boy");
			}else{
				user.put("sex", "girl");
			}
		}
		for (Map<String, Object> user : funnyUser) {
			if (user.get("sex").equals("1")) {
				user.put("sex", "boy");
			}else{
				user.put("sex", "girl");
			}
		}
		ModelAndView view=new ModelAndView();
		view.addObject("userList",userList);
		view.addObject("funnyUser",funnyUser);
		view.addObject("msgs",msgs);
		view.setViewName("/backup/login");
		log.info("加载Login页面完成");
		return view;
		
	}
	
	@RequestMapping("/tag")
	public ModelAndView tag(){
		ModelAndView view=new ModelAndView();
		view.setViewName("/Setting/tag");
		return view;
	}
	private void homePage(ModelAndView view,HttpSession session,HttpServletRequest req){
		LoginBean loginBean =(LoginBean)session.getAttribute("loginUser");
		PageBean pageBean=new PageBean();
		int currentNum=1;
		if (req.getParameter("pageNumber")!=null) {
			currentNum=Integer.parseInt(req.getParameter("pageNumber"));
			if (currentNum==0) {
				currentNum=1;
			}
		}
		pageBean.setTotalPages(profileDao.findAllCount()/20);
		Map<String, Object> userinfo=userDaoImp.findUserMapByName(loginBean.getLoginName());
		long profNum=profileDao.findProfNumById((int) userinfo.get("userId"));
		List<Map<String, Object>> list=profileDao.findAllLimit(currentNum);
		List<Profile> profList=new ArrayList<>();
		for (Map<String, Object> map : list) {
			Profile profile=profileDao.map2Object(map);
			profile.setPublishName(userDaoImp.nickName(profile.getUserId()));
			profList.add(profile);
		}
		log.info(""+profList.size());
		session.setAttribute("uInfo", userinfo);
		view.addObject("profList",profList);
		view.addObject("profNum",profNum);
		view.addObject("userinfo",userinfo);
		view.addObject("pageBean",pageBean);
		view.addObject("pageNumber",currentNum);
		session.setAttribute("userId", userinfo.get("userId"));
	}
	@RequestMapping("/Login")
	public ModelAndView login(HttpServletRequest req,HttpSession session){
		ModelAndView view=new ModelAndView();
		if (session.getAttribute("loginUser")!=null) {
			homePage(view, session,req);
			view.setViewName("/backup/homePage");
			return view;
		}
		String loginName=req.getParameter("loginName");
		String password=req.getParameter("password");
		LoginBean loginBean=new LoginBean();
		loginBean.setLoginName(loginName);
		loginBean.setAssword(password);
		loginBean.setLoginType(0);
		
		if (userDaoImp.login(loginBean)) {
			session.setAttribute("loginUser", loginBean);
			homePage(view, session,req);
			view.setViewName("/backup/homePage");
		}else{
			log.info("登录session消失");
			view.setViewName("/backup/login");
		}
		
		return view;
	}
	public static void main(String[] args) {
	}
	
}
