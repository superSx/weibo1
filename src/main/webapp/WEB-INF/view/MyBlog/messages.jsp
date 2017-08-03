<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>我的私信</title>

<link rel="shortcut icon" href="css/img/v.png" />
<link href="css/privatemsg.css" type="text/css" rel="stylesheet" />
<link href="/css/skin.css" type="text/css" rel="stylesheet" />
<link href="css/sendMsg.css" type="text/css" rel="stylesheet" />
<link href="css/faces.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/msg_manage.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/editor_manage.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
</head>

<body onload="refreshCount();">
	<div class="MIB_bloga">
		<div class="MIB_blogb">
			<%@include file="../common/bannner.jsp"%>
			<!-- /小黄签 -->

			<div class="MIB_blogbody">
				<div class="MIB_mblogbgr">
					<div class="MIB_mblogbgl">
						<!--右栏内容 -->
						<div class="mainR MIB_200 MIB_txtar MIB_linkar">
							<!--个人信息-->
							<div class="userinfo">
								<div class="user_head">
									<div class="picborder_r lf" id="pop_1">
										<a href=""><img class="person_icon"
											src="${sessionScope.uInfo.myFace}"  pop="true" alt="" /></a>
									</div>
									<div class="lf">
										<p class="font_14">
											<a href="myProfPage.action?pageNumber=1" namecard="true"
												title="${sessionScope.uInfo.nickName }">${sessionScope.uInfo.nickName }</a>
										</p>
										<p>${sessionScope.uInfo.Province},&nbsp;${sessionScope.uInfo.City}</p>
									</div>
								</div>
								<div class="user_atten MIB_linedot">
									<ul id="profile_following_follower_update">
										<li id="pop_2" class="MIB_line_r">
											<div class="num" pop="true">
												<a
													href="/Weibo/MyBlog/myFollowpage.action?pageNumber=1&listType=1"
													id="mblog">${sessionScope.user.followCount}</a>
											</div> <a
											href="/Weibo/MyBlog/myFollowpage.action?pageNumber=1&listType=1">关注</a>
										</li>
										<li class="MIB_line_r">
											<div class="num">
												<a
													href="/Weibo/MyBlog/myFanspage.action?pageNumber=1&listType=1"
													id="myfans">${sessionScope.user.fansCount}</a>
											</div> <a
											href="/Weibo/MyBlog/myFanspage.action?pageNumber=1&listType=1">粉丝</a>
										</li>
										<li class="">
											<div class="num">
												<a href="myProfPage.action?pageNumber=1" id="mblog">${sessionScope.user.profileCount}</a>
											</div> <a href="myProfPage.action?pageNumber=1">微博</a>
										</li>
									</ul>
								</div>
							</div>
							<!--企业白名单入口-->
							<!-- 企业白名单入口 -->
						</div>
						<!--/右栏内容 -->
						<!--左栏内容 -->
						<div class="mainL MIB_600 MIB_txtal MIB_linkal ssdh_wrap">
							<div class="msg_lf clearFix titmg10">
								<div class="titmg10">
									<span class="font_14 fb">我的私信</span>&nbsp; <span class="gray6"></span>
								</div>
								<div class="lf">
									<a class="newbbtngrn" id="send_Msg" href="javascript:void(0);"
										onclick="OnClickSendMsg();"><em>发私信</em></a>
								</div>
								<div class="rt">
									<div class="chdd">
										<form action="/message/search_msg.php">
											<form action="search_msg.php">
												<label><input id="searchkeyword"
													name="searchkeyword" type="text"
													style="color: rgb(153, 153, 153);" class="txt_s2"
													value="查找联系人 / 搜索私信内容" def="查找联系人 / 搜索私信内容"> <a
														id="search_btn" href="javascript:previousBox();"
														class="btn_normal btnxs"><em>搜索</em></a></label>
											</form>
									</div>
								</div>
							</div>
							<div id="atme_filter" class="atme_filter1">
								<div act="panel" class="atmef_con1 clearFix">
									<ul class="lf">
										<li><a href="frommsgList.action?pageNumber=1">已收到的私信</a>
										</li>
										<li class="cur"><b>已发出的私信</b></li>

									</ul>
									<div id="feed_sort" class="timeHot_feed">共${pageBean.totalPosts }条</div>
								</div>
							</div>

							<ul class="MIB_feed" id="msg_list" popcontainer="true">
								<c:if test="${pageBean.totalPosts == 0}">
									<div style="color: #B8B7B7; padding: 10px 30px;">
										<p>亲，你还没收到私信哦，尝试给别人发一条吧！</p>

									</div>
								</c:if>
								<!-- 直接加 -->
								<c:forEach items="${blogs}" var="msg">
									<li id="${msg.msgId }" class="MIB_linedot_l"
										onmouseover="mouseovershowDialog('messages_cancle1_${msg.msgId}')"
										onmouseout="mouseovercloseDialog('messages_cancle1_${msg.msgId}')"
										style="z-index: inherit;">
										<div class="user_pic user_Stat">
											<div class="head_pic">
												<a href="" title=""><img title="" alt="" imgtype="head"
													src="${sessionScope.uInfo.myFace}" width="50" height="50"></a>
											</div>
										</div>
										<div class="MIB_feed_c">
											<div class="rt icon_closel" title="删除"
												id="messages_cancle1_${msg.msgId}" style="display: none;">
												<a href="javascript:void(0);"
													onclick="OnClickremove(${msg.msgId })">x</a>
											</div>
											<p class="letter">
												我发给&nbsp;<a namecard="true" id="msg_${msg.msgId}"
													href="/Weibo/Others/othersProfile.action?otherId=${msg.msgTo}"
													title="${msg.msgTo} ">@${msg.msgToName}</a>&nbsp;的私信：&nbsp;&nbsp;
												${msg.msgContent}
											</p>
											<div class="feed_att MIB_linkbl">
												<div class="lf">
													<span class="gray9">${msg.date } </span> <em
														class="reportBtn"> </em>
												</div>
												<div class="rt">
													<input type="hidden" id="msgToName_${msg.msgId }"
														value="${msg.msgToName}" />

												</div>
											</div>
										</div>
									</li>
								</c:forEach>
								<!--翻页-->
								<div class="MIB_bobar">
									<c:if test="${pageBean.totalPosts != 0}">
										<div class="fanye MIB_txtbl" style="float: right;" id="page">
											<a href="privateMsg?pageNumber=1"
												class="btn_num btn_numWidth"><em>首页</em></a>
											<c:if test="${pageNumber>1}">
												<a href="privateMsg?pageNumber=${pageNumber-1}"
													class="btn_num btn_numWidth"><em>上一页</em></a>
											</c:if>
											<c:forEach begin="1" end="5" step="1" var="pageIndex">
												<c:if test="${pageNumber-(6-pageIndex) >=1}">
													<a class="btn_num"
														href="privateMsg?pageNumber=${pageNumber+pageIndex-6}"><em>${pageNumber+pageIndex-6}</em></a>
												</c:if>
											</c:forEach>
											<span>${pageNumber}</span>
											<c:forEach begin="1" end="5" step="1" var="pageIndex">
												<c:if test="${pageNumber+pageIndex <= pageBean.totalPages}">
													<a class="btn_num"
														href="privateMsg?pageNumber=${pageNumber+pageIndex}"><em>${pageNumber+pageIndex}</em></a>
												</c:if>
											</c:forEach>
											<c:if test="${pageNumber < pageBean.totalPages}">
												<a href="privateMsg?pageNumber=${pageNumber+1}"
													class="btn_num btn_numWidth"><em>下一页</em></a>
											</c:if>
											<a href="privateMsg?pageNumber=${pageBean.totalPages}"
												class="btn_num btn_numWidth"><em>末页</em></a>
										</div>
									</c:if>
								</div>
								<!--翻页-->
							</ul>
						</div>
					</div>
				</div>
				<!--/正文-->
				<!--尾-->
				<!--/尾-->
			</div>
		</div>

	</div>

	</div>

	<!-- /网站信息 -->
	<div class="bottomLinks " id="bottomborder"">
		<div class="bottombg"></div>
		<div class="MIB_foot_new MIB_txtbr MIB_linkbr"
			style="text-align: center;">
			<p></p>
			<p>特别声明：本网站仅用于学习参考，严禁一切商业行为。如有违反，后果自负。</p>
			<p>
				Copyright © 2011-2013 <a href="http://weibo.com/yooungt">有田十三</a>
				All Rights Reserved.
			</p>
			<div class="clearit"></div>
			<p></p>
		</div>
	</div>
</body>
</html>
