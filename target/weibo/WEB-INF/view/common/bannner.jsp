<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title></title>  
</head>  
<body>
			<div class="tsina_gnbarea" id="WB_box_1318070134145">
				<div class="bg_gnbarea">&nbsp;</div>
				<div id="" class="tsina_gnb">
					<ul class="gnb_r">
						<li><a href="${rootpath }/homePage" id="">${userinfo.get("nickName")}</a>
						</li>
						<li><a href="${rootpath }/privateMsg">私信</a></li>
						<li><a href="${rootpath }/systemNotice">通知</a></li>
						<li><a href="${rootpath }/setting">帐号设置</a></li>
						<li class="line">|</li>
						<li><a id="" href="login.html">退出</a></li>
					</ul>
				</div>
			</div>
			<div class="header">
				<div class="head_menu">
					<span class="menu_l">&nbsp;</span>
					<div class="menu_c">
						<div class="bg_menu_c">&nbsp;</div>
						<ul>
							<li class="cur"><a href="privatePage?pageNumber=1">我的首页</a></li>
							<li class="line">|</li>
							<li><a href="myProfPage.action?pageNumber=1">我的微博</a></li>
							<li class="line">|</li>
							<li><a href="follow.html">好友</a></li>
						</ul>
						<div class="search" id="m_search">
							<input type="text" id="m_keyword" autocomplete="off"
								dycolor="false" title="搜索微博、找人" accesskey="3" /> <a
								class="submit" href="search.html" id="m_submit">搜索</a>
						</div>
					</div>
					<span class="menu_r">&nbsp;</span>
				</div>
				<div id="m_keyword_tip" class="resultTip" style="display: none"></div>
			</div>
</body>
</html>