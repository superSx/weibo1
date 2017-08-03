<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>
            公司信息
        </title>
        <link rel="shortcut icon" href="css/img/v.png"/>
        <link href="css/setup.css" type="text/css" rel="stylesheet" />
        <link href="css/skin.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="js/index.js">
        </script>
        <script type="text/javascript" src="js/validateWorkInfo.js">
        </script>
    </head>
    
    <body onload="refreshCount();">
        <div class="MIB_bloga">
            <div class="MIB_blogb">
                <%@include file="../common/bannner.jsp" %>
                <!--正文-->
                <div class="MIB_blogbody">
                    <!--找朋友-->
                    <div class="MIB_column">
                        <div class="MIB_main_cont">
                            <div class="MIB_setup">
                                <!--页签-->
                                <%@include file="../common/setting.jsp" %>
                                <!--/页签-->
                                <!--个人资料-->
                                <%@include file="../common/TopInfo.jsp" %>
                                    <!-- 信息列表 -->
                                    <div node-type="con_items">
                                    </div>
                                    <!-- /信息列表 -->
                                    
                                    <div node-type="company_create">
                                        <div class="title MIB_linedot2 title1">
                                            <span class="fb">
                                                修改职业信息
                                            </span>
                                        </div>
                                        <div class="info_tab01">
                                            <form:form id="workinfo" action="updateWorkinfo" method="post" name="workinfo" 
                                            modelAttribute="user">
                                                <table>
                                                    <tbody>
                                                        <tr node-type="area" act="department">
                                                            <th class="gray6">
                                                                所在地：
                                                            </th>
                                                            <td class="info_tab_vm" node-type="tip">
                                                                <form:select name="user.workProv" id="province" 
                                                                path="Province" onchange="getCity()">
                                                                    <option value="null" selected="selected">
                                                                    所在省份
                                                                </option>
                                                                <option value="直辖市">
                                                                    直辖市
                                                                </option>
                                                                <option value="河北">
                                                                    河北
                                                                </option>
                                                                <option value="山西">
                                                                    山西
                                                                </option>
                                                                <option value="内蒙古">
                                                                    内蒙古
                                                                </option>
                                                                <option value="辽宁">
                                                                    辽宁
                                                                </option>
                                                                <option value="吉林">
                                                                    吉林
                                                                </option>
                                                                <option value="黑龙江">
                                                                    黑龙江
                                                                </option>
                                                                <option value="江苏">
                                                                    江苏
                                                                </option>
                                                                <option value="浙江">
                                                                    浙江
                                                                </option>
                                                                <option value="安徽">
                                                                    安徽
                                                                </option>
                                                                <option value="福建">
                                                                    福建
                                                                </option>
                                                                <option value="江西">
                                                                    江西
                                                                </option>
                                                                <option value="山东">
                                                                    山东
                                                                </option>
                                                                <option value="河南">
                                                                    河南
                                                                </option>
                                                                <option value="湖北">
                                                                    湖北
                                                                </option>
                                                                <option value="湖南">
                                                                    湖南
                                                                </option>
                                                                <option value="广东">
                                                                    广东
                                                                </option>
                                                                <option value="广西">
                                                                    广西
                                                                </option>
                                                                <option value="海南">
                                                                    海南
                                                                </option>
                                                                <option value="四川">
                                                                    四川
                                                                </option>
                                                                <option value="贵州">
                                                                    贵州
                                                                </option>
                                                                <option value="云南">
                                                                    云南
                                                                </option>
                                                                <option value="西藏">
                                                                    西藏
                                                                </option>
                                                                <option value="陕西">
                                                                    陕西
                                                                </option>
                                                                <option value="甘肃">
                                                                    甘肃
                                                                </option>
                                                                <option value="青海">
                                                                    青海
                                                                </option>
                                                                <option value="宁夏">
                                                                    宁夏
                                                                </option>
                                                                <option value="新疆">
                                                                    新疆
                                                                </option>
                                                                <option value="台湾">
                                                                    台湾
                                                                </option>
                                                            </form:select>
                                                            <form:select path="City" name="user.city" id="city">
                                                                <option selected="selected" value="null">
                                                                    所在城市
                                                                </option>
                                                            </form:select>
                                                                <!--下拉-->
                                                                <form:select path="privacy" node-type="privacy" name="privacy" class="info_tabTip" style="display: none;">
                                                                    <option selected="" value="0">
                                                                        所有人可见
                                                                    </option>
                                                                    <option value="1">
                                                                        我关注的人可见
                                                                    </option>
                                                                    <option value="2">
                                                                        仅自己可见
                                                                    </option>
                                                                </form:select>
                                                                <!--下拉-->
                                                            </td>
                                                        </tr>
                                                </table>
                                                <table>
                                                    <tr node-type="input_form" act="company" verify="1">
                                                        <th class="gray6">
                                                            <em class="error_color">
                                                                *
                                                            </em>
                                                            单位名称：
                                                        </th>
                                                        <td>
                                                            <form:input path="workplace" name="workinfo.workplace" class="PY_input gray9"
                                                            type="text" value="${sessionScope.user.workplace }" id= "workplace" onclick="onclickShowStyleOfWorkPlace()" onblur="onblurValidateWorkPlace('workplace')"/>
                                                        </td>
                                                        <td node-type="tip">
                                                        	<div class="setup_info" style="display: none;" id="successWorkPlace">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>
                                                            <table class="cudTs" style="display:none" id="inputWorkPlace1">
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
                                                                            请输入名称，20个字以内
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
                                                            <table class="cudTs3" style="display:none;" id="errorWorkPlace2">
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
                                                                           字数超过了20个
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
                                                </table>
                                                <table>
                                                    <tr node-type="date" act="department">
                                                        <th class="gray6">
                                                            工作时间：
                                                        </th>
                                                        <td class="info_tab_vm">
                                                            <select name="workinfo.workTimeFrom" id="workTimeFrom" onchange="onchangeValidateWorkTime('workTimeTo')" >
                                                                <option value="">
                                                            		请选择
                                                            	</option>
                                                                <c:forEach items="years" var="year">
	                                                                <option value="${year}" >
	                                                            		${year}
	                                                            	</option>
                                                                </c:forEach>
                                                            </select>
                                                            &nbsp;至
                                                            <select name="workinfo.workTimeTo" id="workTimeTo" onchange="onchangeValidateWorkTime('workTimeTo')" >
                                                                <option value="">
                                                                    请选择
                                                                </option>
                                                                <option value="9999">
                                                                    至今
                                                                </option>
                                                                <c:forEach items="years" var="year">
	                                                                <option value="${year}" >
	                                                            		${year}
	                                                            	</option>
                                                                </c:forEach>
                                                            </select>
                                                        </td>
                                                        <td node-type="tip">
                                                        	<div class="setup_info" style="display: none;" id="successWorkTimeTo">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>

                                                            <table class="cudTs3" style="display:none;" id="errorWorkTime2">
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
                                                                           请选择正确的工作年份
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
                                                </table>
                                                <table>
                                                    <tr node-type="input_form" act="department">
                                                        <th class="gray6">
                                                            部门/职位：
                                                        </th>
                                                        <td>
                                                            <form:input path="department" name="workinfo.department" node-type="input" type="text" class="PY_input"
                                                            value="${user.department }" id="department"onclick="onclickShowStyleOfDepartment()" onblur="onblurValidateDepartment('department')"/>
                                                        </td>
                                                        <td node-type="tip">
                                                        	<div class="setup_info" style="display: none;" id="successDepartment">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>
                                                            <table class="cudTs" style="display:none" id="inputDepartment1">
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
                                                                            请输入职位，12个字以内
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
                                                            <table class="cudTs3" style="display:none;" id="errorDepartment2">
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
                                                                           字数超过了12个
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
                                                </table>
                                                <table>
                                                    <tr>
                                                        <th>
                                                        </th>
                                                        <td>
                                                            <a node-type="submit" class="newabtngrn" href="javascript:toSubmitChange('workinfo')"
                                                            id="submit_work" class="newabtngrn">
                                                                <em>
                                                                    保存
                                                                </em>
                                                            </a>
                                                            <a node-type="cancel" class="btn_normal btns" href="javascript:;">
                                                                <em>
                                                                    取消
                                                                </em>
                                                            </a>
                                                        </td>
                                                        <td>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </form:form>
                                        </div>
                                    </div>
                                    <!--/个人资料-->
                                </div>
                            </div>
                            <!--/找朋友-->
                        </div>
                    </div>
                </div>
                
			</div>
		</div>
                <!--/正文-->
                <!--尾-->
           <%@include file="../common/foot.jsp" %>
		</div>
    </body>

</html>
