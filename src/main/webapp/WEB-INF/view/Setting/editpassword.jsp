<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>修改密码</title>
<link rel="shortcut icon" href="css/img/v.png"/>
<link href="css/setup.css" type="text/css" rel="stylesheet" />
<link href="css/skin.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/editPassword.js"></script>
<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/sx_validatePsw.js" type="text/javascipt"></script>
</head>

<body onload="refreshCount();">
<div class="MIB_bloga">
  <div class="MIB_blogb">

	<%@include file="../common/bannner.jsp" %>



<div class="MIB_blogbody">
	<div class="MIB_column">
		<div class="MIB_main_cont">
			<div class="MIB_setup">
				<!--页签-->
							<%@include file="../common/setting.jsp"%>
							<div id="system_information" style="display:none"></div>
			<!--个人资料-->
			<div class="setup_main">
				<%@include file="../common/TopInfo.jsp" %>

                
			<form id="updatepassword"  action="updatePassword" method="post" name="updatepassword">
				<div class="title MIB_linedot2 title1">
                                        <span class="fb">
                                            修改密码
                                        </span>
                                    </div>
				<div class="info_tab01">
					<table>
						<tbody>
							<tr>
								<th scope="row" class="gray6">当前密码：</th>
									<td><input type="password" class="PY_input" id="oldPassword" name="oldpassword" onclick="onclickShowStyleOfOldPassword()" onblur="validateOldPassword('1')"></input><span style="display:none" class="errorTs2"></span></td>
									<td node-type="tip">
                                                        	<div class="setup_info" style="display: none;" id="successOldPwd">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>
                                                            <table class="cudTs" style="display:none" id="inputOldPwd1">
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="topL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="topR">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                        </td>
                                                                        <td class="tdCon">
                                                                            输入当前密码
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td class="botL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="botR">
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                            <table class="cudTs3" style="display:none;" id="errorOldPwd2">
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="topL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="topR">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                        </td>
                                                                        <td class="tdCon">
                                                                           与当前密码不符
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td class="botL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="botR">
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </td>
				</tr>

				<tr>
					<th scope="row" class="gray6">新 密 码：</th>
						<td><input type="password" id="newPassword" class="PY_input" name="updatepassword.password" onclick="onclickShowStyleOfNewPassword()" onblur="onblurValidateNewPassword('newPassword')"></input><span style="display:none" class="errorTs2"></span></td>
						<td node-type="tip">
                                                        	<div class="setup_info" style="display: none;" id="successNewPwd">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>
                                                            <table class="cudTs" style="display:none" id="inputNewPwd1">
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="topL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="topR">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                        </td>
                                                                        <td class="tdCon">
                                                                            输入长度为6-16位由数字英文及"_"组成的新密码
              															</td>
                                                                        <td>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td class="botL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="botR">
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                            <table class="cudTs3" style="display:none;" id="errorNewPwd2">
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="topL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="topR">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                        </td>
                                                                        <td class="tdCon">
                                                                           请输入合法的密码
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td class="botL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="botR">
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </td>
					</tr>
					
					<tr>
						<th scope="row" class="gray6">确认密码：</th>
						<td><input type="password" class="PY_input" id="confirmPassword" name="confirmpasswprd" onclick="onclickShowStyleOfConfirmPassword()" onblur="onblurValidateConfirmPassword('confirmPassword')"></input><span style="display:none" class="errorTs2"></span></td>
						<td node-type="tip">
                                                        	<div class="setup_info" style="display: none;" id="successConfirmPassword">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>
                                                            <table class="cudTs" style="display:none" id="inputConfirmPassword1">
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="topL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="topR">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                        </td>
                                                                        <td class="tdCon">
                                                                            再次输入新密码
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td class="botL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="botR">
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                            <table class="cudTs3" style="display:none;" id="errorConfirmPassword2">
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="topL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="topR">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                        </td>
                                                                        <td class="tdCon">
                                                                           与新密码不同，请重新输入
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td class="botL">
                                                                        </td>
                                                                        <td>
                                                                        </td>
                                                                        <td class="botR">
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </td>

                      </tr>

                      

                      <tr>

                        <th scope="row"></th>

                        <td>

                            <div class="MIB_btn">

                            <a href="javascript:validateEditPasswordSubmit('updatepassword')" id="submit_password" class="newabtngrn"><em>保存</em></a>

                            </div>

 

                      </tr>

                    </tbody>

                    </table>
				</div>
				
				</form>

            </div>
        <!--/个人资料--> 

         </div>

	 </div>

	 <!--/我的账号-->

  </div>

  <!--/正文-->
  </div>   

</div> 

</div>
<div class="bottomLinks " id="bottomborder">
			<div class="bottombg"></div>
		    <div class="MIB_foot_new MIB_txtbr MIB_linkbr" style="text-align:center;">
				<p></p>		
		        <p>学习用</p>              
		        <p>Copyright © 2017  <a href="#">zsx</a>  All Rights Reserved.</p>		
				<div class="clearit"></div>
				<p></p>
			</div>
		</div>
<script type="text/javascript">
	$(function(){
		
	})

</script>
</body>

</html>