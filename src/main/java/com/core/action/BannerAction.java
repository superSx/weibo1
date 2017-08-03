package com.core.action;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BannerAction {
	private static Log log=LogFactory.getLog(BannerAction.class);
	@RequestMapping("/homePage")
	public ModelAndView homePage(){
		ModelAndView view=new ModelAndView();
		view.setViewName("/backup/homePage");
		return view;
	}
	@RequestMapping("/404")
	public ModelAndView Page404(){
		ModelAndView view=new ModelAndView();
		view.setViewName("/404");
		return view;
	}
	@RequestMapping("/500")
	public ModelAndView Page500(){
		ModelAndView view=new ModelAndView();
		view.setViewName("/500");
		return view;
	}
	
	@RequestMapping("/systemNotice")
	public ModelAndView systemNotice(){
		ModelAndView view=new ModelAndView();
		view.setViewName("/MyBlot/notice");
		return view;
	}
	@RequestMapping("/privatePage")
	public ModelAndView privatePage(){
		ModelAndView view=new ModelAndView();
		return view;
	}
}
