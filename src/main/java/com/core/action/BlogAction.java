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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.core.dao.BlogDao;
import com.core.dao.UserDaoImp;
import com.core.domin.Blog;
import com.core.domin.PageBean;
import com.core.json.ValidPswJson;

@Controller
public class BlogAction {
	@Autowired
	BlogDao blogDao;
	@Autowired
	UserDaoImp userDao;
	Log log=LogFactory.getLog(BlogAction.class);
	@RequestMapping("/privateMsg")
	public ModelAndView privateMsg(HttpServletRequest req,HttpSession session){
		ModelAndView view=new ModelAndView();
		PageBean pageBean=new PageBean();
		int pageNum=getPageNum(req);
		
		
		Map<String, Object> map=new HashMap<>();
		map.put(BlogDao.MSG_FROM, session.getAttribute("userId"));
		List<Blog> blogs=blogDao.findObjsByFieldsLimit(map,pageNum);
		int pagePosts=blogDao.findByFields(map).size();
		pageBean.setTotalPages(pagePosts%20==0? pagePosts/20:pagePosts/20+1);
		pageBean.setTotalPosts(pagePosts);
		view.addObject("pageBean",pageBean);
		view.addObject("blogs",blogs);
		view.setViewName("/MyBlog/messages");
		return view;
	}
	@RequestMapping("/sendMessage")
	public ModelAndView message(HttpServletRequest req,HttpSession session){
		ModelAndView view=new ModelAndView();
		Map<String, Object> blog=new HashMap<>();
		String msgToName=req.getParameter("msgToName");
		
		String msgContent=req.getParameter("msgContent");
		log.info(msgContent);
		int msgTo=userDao.getIdByNickName(msgToName);
		blog.put(BlogDao.MSG_CONTENT, msgContent);
		blog.put(BlogDao.MSG_TO, msgTo);
		blog.put(BlogDao.MSG_FROM, (int)session.getAttribute("userId"));
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		blog.put(BlogDao.MSG_TIME, sdf.format(d));
		blog.put(BlogDao.MSG_TYPE, 5);
		blog.put(BlogDao.MSG_READ, false);
		log.info(blog);
		blogDao.save(blog);
		
		view.setViewName("redirect:/privateMsg");
		return view;
	}
	@RequestMapping("/validatemsgtoName/{msgToName}")
	@ResponseBody
	public String validate(@PathVariable String msgToName,HttpServletRequest req){
		boolean isPass=userDao.existNickName(msgToName);
		System.out.println(isPass);
		ValidPswJson json=new ValidPswJson();
		json.setIsPass(isPass);
		return JSONObject.toJSONString(json);
	}
	public int getPageNum(HttpServletRequest req){
		String page=req.getParameter("pageNumber");
		if (page!=null) {
			return Integer.parseInt(page);
		}else{
			return 1;
		}
	}
}
