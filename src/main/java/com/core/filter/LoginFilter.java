package com.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoginFilter implements Filter{
	private Log log=LogFactory.getLog(LoginFilter.class);
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)srequest;
        HttpServletResponse response = (HttpServletResponse)sresponse;
        String requestURI = request.getRequestURI();
//        String remoteUser=request.getRemoteHost();
        
        //过滤登录action
        if(requestURI.contains("initLogin")||requestURI.equals("/weibo/")||requestURI.contains("css")||
        		requestURI.contains("js")||requestURI.contains("/Images")||requestURI.contains("regist")){
            chain.doFilter(request, response);
        }
        else if (requestURI.equals("/weibo/Login")) {
        	log.info("loginfilter:"+requestURI);
			if (request.getParameter("loginName")==null) {
				if(doMenuChain(request, response)){
	                //设置选择菜单
	                chain.doFilter(request, response);
	            }
			}else{
				chain.doFilter(request, response);
			}
		}
        else{
        	log.info("loginfilter:"+requestURI);
            //是否登录
            if(doMenuChain(request, response)){
                //设置选择菜单
                chain.doFilter(request, response);
            }
        }
	}
	public boolean doMenuChain(HttpServletRequest request,HttpServletResponse response){
        if(request.getSession().getAttribute("loginUser")==null){
            try {
            	log.info("登录已经退出！");
                response.sendRedirect("/weibo/initLogin");
                return false;
            } catch (IOException e) {
                log.error("重定向失败！",e);
                return true;
            }
        }else{
            return true;
        }
    }
    
    //设置 选择 菜单
//    public void doSelMenuChain(HttpServletRequest request,HttpServletResponse response){
//        String parameter = request.getParameter();
//        if (parameter!=null) {
//            request.getSession().setAttribute(SysEnv.SEL_MENU, parameter);
//        }
//    }
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
