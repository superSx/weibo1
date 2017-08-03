package com.core.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.core.dao.FollowDao;
import com.core.dao.ProfileDao;
import com.core.dao.UserDaoImp;
import com.core.domin.LoginBean;
import com.core.domin.Profile;

@Controller
public class ProfileAction {
	private static final Log log=LogFactory.getLog(ProfileAction.class);
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private UserDaoImp userDao;
	@Autowired
	private FollowDao followDao;
	@RequestMapping("/subProfile")
	public ModelAndView subProfile(HttpServletRequest req,HttpSession session){
		ModelAndView view=new ModelAndView();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginUser");
		String profContent=req.getParameter("profContent");
		Map<String, Object> map=new HashMap<>();
		map.put(ProfileDao.PROF_CONTENT, profContent);
		log.info(loginBean);
		map.put(ProfileDao.USER_ID,userDao.findUserMapByName(loginBean.getLoginName()).get("userId"));
		Date now=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format( now ); 
		map.put(ProfileDao.Prof_TIME, time);
		map.put(ProfileDao.TC_ID, 0);
		map.put(ProfileDao.IMAGE_REF, "");
		log.info(map);
		profileDao.save(map);
		log.info(profContent);
		view.setViewName("redirect:/Login");
		return view;
	}
	@RequestMapping("/profile")
	public ModelAndView profile(HttpSession session){
		ModelAndView view=new ModelAndView();
		int userId=(int) session.getAttribute("userId");
		Long fansCount=followDao.getFansCount(userId);
		Long followCount=followDao.getFollowCount(userId);
		Long profileCount=profileDao.findProfNumById(userId);
		Map<String, Object> map=new HashMap<>();
		map.put("userId", userId);
		String sql="SELECT profId,profTime,tcId,ImageRef,profContent,nickName as publishName\n"+
				"FROM `profile`  JOIN userinfo\n"+
				"ON `profile`.userId=userinfo.userId and `profile`.userId=?\n"
				+ "order by profTime desc";
		List<Map<String, Object>> profileList=profileDao.findBySQL(sql, userId);
		
		view.addObject("follows",followCount);
		view.addObject("fans",fansCount);
		view.addObject("profiles",profileCount);
		view.addObject("profList",profileList);
		view.setViewName("/backup/profile");
		return view;
	}
}
