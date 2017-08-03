<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人资料</title>
<link rel="shortcut icon" href="css/img/v.png" />
<link href="css/setup.css" type="text/css" rel="stylesheet" />
<link href="css/skin.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/index.js">
        </script>
<script type="text/javascript" src="js/validateUserInfo.js">
        </script>
</head>

<body background="Images/background.jpg"
	onload="initDate();refreshCount();">
	<div class="MIB_bloga">
		<div class="MIB_blogb">
			<%@include file="../common/bannner.jsp"%>
			<!--正文-->
			<div class="MIB_blogbody">
				<!--找朋友-->
				<div class="MIB_column">
					<div class="MIB_main_cont">
						<div class="MIB_setup">
							<!--页签-->
							<%@include file="../common/setting.jsp" %>
							<!--/页签-->
							<div id="system_information" style="display: none"></div>
							<!--个人资料-->
							<div class="setup_main">
								<%@include file="../common/TopInfo.jsp" %>
								<form:form id="update" action="updateUser" method="post"
									modelAttribute="user">
									<div class="info_tab01" id="information_box">
										<table style="width: 645px;">
											<tr>
												<th width="148" class="gray6">登录名：</th>
												<td class="font_12" colspan="2">
													<div>
														<span> <em> ${userInfo.loginName} </em>
														</span>
													</div>
												</td>
											</tr>
											<tr>
												<th class="gray6"><em class="error_color"> * </em>
													昵&nbsp;&nbsp;称：</th>
												<td width="245"><form:input type="text"
														class="PY_input" autocomplete="off"
														value="${userInfo.nickName}" 
														id="nickName" onclick="onclickShowStyleOfNickName()"
														onblur="onblurValidateNickName('nickName')" path="nickName"/>
												</td>
												<td id="red_nickname">
													<div class="setup_info" style="display: none;"
														id="successNickName">
														<div class="info_tip2">
															<div class="tipicon tip3" title=""></div>
														</div>
														<div class="info_tip1"></div>
													</div>
													<table class="cudTs" style="display: none"
														id="inputNickName1">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">可输入1-12位，包含数字、英文或中文</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
													<table class="cudTs3" style="display: none;"
														id="errorNickName2">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">支持中英文、数字、“_”或减号</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
													<table class="cudTs3" style="display: none;"
														id="errorNickName3">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">此昵称太火了，换换，亲</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
												<th class="gray6">真实姓名：</th>
												<td><form:input type="text" class="PY_input"
														name="user.trueName" id="truename" autocomplete="off"
														value="${userInfo.trueName}"
														onclick="onclickShowStyleOfTrueName();"
														onblur="onblurValidateTrueName('truename');"
														path="trueName" /> </td>
												<td id="red_realname">
													<div class="setup_info" style="display: none;"
														id="successTrueName">
														<div class="info_tip2">
															<div class="tipicon tip3" title=""></div>
														</div>
														<div class="info_tip1"></div>
													</div>
													<table class="cudTs" style="display: none;"
														id="inputTrueName1">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">请填写真实姓名，方便我们联系你</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
													<table class="cudTs3" style="display: none;"
														id="errorTrueName2">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">请填写真实姓名</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
												<th class="gray6"><em class="error_color"> * </em> 所在地：
												</th>
												<td class="info_tab_vm"><form:select name="user.province"
													id="province" onchange="getCity()" path="Province">
														<option value="直辖市" selected="selected">直辖市</option>

														<option value="河北">河北</option>
														<option value="山西">山西</option>
														<option value="内蒙古">内蒙古</option>
														<option value="辽宁">辽宁</option>
														<option value="吉林">吉林</option>
														<option value="黑龙江">黑龙江</option>
														<option value="江苏">江苏</option>
														<option value="浙江">浙江</option>
														<option value="安徽">安徽</option>
														<option value="福建">福建</option>
														<option value="江西">江西</option>
														<option value="山东">山东</option>
														<option value="河南">河南</option>
														<option value="湖北">湖北</option>
														<option value="湖南">湖南</option>
														<option value="广东">广东</option>
														<option value="广西">广西</option>
														<option value="海南">海南</option>
														<option value="四川">四川</option>
														<option value="贵州">贵州</option>
														<option value="云南">云南</option>
														<option value="西藏">西藏</option>
														<option value="陕西">陕西</option>
														<option value="甘肃">甘肃</option>
														<option value="青海">青海</option>
														<option value="宁夏">宁夏</option>
														<option value="新疆">新疆</option>
														<option value="台湾">台湾</option>
												</form:select> <form:select name="user.city" id="city" path="City">
														<option selected="北京" value="北京">北京</option>
														<option value="上海">上海</option>
														<option value="天津">天津</option>
														<option value="重庆">重庆</option>
														<option value="香港">香港</option>
														<option value="澳门">澳门</option>
												</form:select> <span class="co_kd2" style="display: none"> </span></td>
												<td id="red_prov"></td>
											</tr>
											<tr>
												<th class="gray6"><em class="error_color"> * </em>
													性&nbsp;&nbsp;别：</th>
												<td class="info_tab_vm"><c:forEach items="${sexList}"
														varStatus="loop" var="sex">
														<div class="fragm">
															<label><form:radiobutton value="${loop.count}"
																	name="sex" id="rdoboy" class="ra" checked="checked"
																	path="sex" />${sex }</label>
														</div>
													</c:forEach> </span></td>
												<td>
													<table class="cudTs3" style="display: none;" id="errorMSN2">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">请选择性别</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
												<th class="gray6">生日：</th>
												<td class="info_tab_vm birthDay" id="birthday">
												<select
													name="birthday_y" id="birthday_y"
													onchange="YYYYDD(this.value);birthDay()">
												</select> <em> 年 </em> <select name="birthday_m" id="birthday_m"
													onchange="MMDD(this.value);birthDay()">
												</select> <em> 月 </em> <select name="birthday_d" id="birthday_d" onchange="birthDay()">
												</select> <em> 日 </em><form:input id="Birthday" path="Birthday" type="hidden"/></td>
												
												<td id="birthdaytip">&nbsp;</td>
											</tr>
											<tr>
											</tr>
											<tr>
												<th class="gray6">联系邮箱：</th>
												<td><form:input type="text" class="PY_input"
													value="${userInfo.email}" name="Email" id="Email"
													autocomplete="off" onclick="onclickShowStyleOfEmail()"
													onblur="onblurValidateEmail('email')" path="Email"/></td>
												<td id="red_email" style="vertical-align: top;">
													<div class="setup_info" style="display: none;"
														id="successEmail">
														<div class="info_tip2">
															<div class="tipicon tip3" title=""></div>
														</div>
														<div class="info_tip1"></div>
													</div>
													<table class="cudTs" style="display: none;"
														id="inputEmail1">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">如:736646709@qq.com</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
													<table class="cudTs3" style="display: none"
														id="errorEmail2">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">请输入正确的邮箱</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
												<th class="gray6">QQ：</th>
												<td><form:input type="text" id="qq" name="user.qq"
													value="${userInfo.qq}" autocomplete="off" class="PY_input"
													onclick="onclickShowStyleOfQQ()"
													onblur="onblurValidateQQ('qq')" path="QQ"/> <span class="co_kd2"
													style="display: none"> </span></td>
												<td id="red_qq" style="vertical-align: top;">
													<div class="setup_info" style="display: none;"
														id="successQQ">
														<div class="info_tip2">
															<div class="tipicon tip3" title=""></div>
														</div>
														<div class="info_tip1"></div>
													</div>
													<table class="cudTs" style="display: none;" id="inputQQ1">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">如:736646709</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
													<table class="cudTs3" style="display: none;" id="errorQQ2">
														<tbody>
															<tr>
																<td class="topL"></td>
																<td></td>
																<td class="topR"></td>
															</tr>
															<tr>
																<td></td>
																<td class="tdCon">请输入正确的QQ</td>
																<td></td>
															</tr>
															<tr>
																<td class="botL"></td>
																<td></td>
																<td class="botR"></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
											<th class="gray6">一句话介绍：</th>
											<td><form:textarea 
													class="info_txtarea"
													type="text"
													onclick="onclickShowStyleOfIntroduce();"
													onblur="onblurValidateIntroduce('introduce');"
													path="intruduce" value="${userInfo.introduce}"/>
												<span class="co_kd2" style="display: none"> </span></td>
											<td id="red_mydesc">
												<div class="setup_info" style="display: none;"
													id="successIntroduce">
													<div class="info_tip2">
														<div class="tipicon tip3" title=""></div>
													</div>
													<div class="info_tip1"></div>
												</div>
												<table class="cudTs" style="display: none;"
													id="inputIntroduce1">
													<tbody>
														<tr>
															<td class="topL"></td>
															<td></td>
															<td class="topR"></td>
														</tr>
														<tr>
															<td></td>
															<td class="tdCon">请不要超过70个字</td>
															<td></td>
														</tr>
														<tr>
															<td class="botL"></td>
															<td></td>
															<td class="botR"></td>
														</tr>
													</tbody>
												</table>
												<table class="cudTs3" style="display: none"
													id="errorIntroduce2">
													<tbody>
														<tr>
															<td class="topL"></td>
															<td></td>
															<td class="topR"></td>
														</tr>
														<tr>
															<td></td>
															<td class="tdCon">你输入的个人简介超过了70个字</td>
															<td></td>
														</tr>
														<tr>
															<td class="botL"></td>
															<td></td>
															<td class="botR"></td>
														</tr>
													</tbody>
												</table>
											</td>
											</tr>
											<tr>
												<th></th>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<th></th>
												<td class="info_tabTip02 gray6">以下信息，可作为取回帐号的依据</td>
												<td></td>
											</tr>
											<tr>
												<th class="gray6">证件号码：</th>
												<td><form:input type="text" name="identifier"
													value="${userInfo.identifier}" path="identifier"/> </td>
												<td id="red_idcard"></td>
											</tr>
											<tr>
												<th></th>
												<td>
													<div class="MIB_btn">
														<a href="javascript:validateUserSubmit('update')"
															id="submit" class="newabtngrn"> <em> 保存 </em>
														</a>
													</div>
												</td>
												<td></td>
											</tr>
										</table>
									</div>
								</form:form>
							</div>
							<!--/个人资料-->
						</div>
					</div>
				</div>
				<%@include file="../Template/Copyright.jsp"%>

				<!--/找朋友-->
			</div>
			<!--/正文-->
		</div>
	</div>

</body>

</html>