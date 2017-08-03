<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>
            教育信息
        </title>
        <link rel="shortcut icon" href="css/img/v.png"/>
        <link href="css/setup.css" type="text/css" rel="stylesheet" />
        <link href="css/skin.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="js/index.js">
        </script>
        <script type="text/javascript" src="js/validateEducationInfo.js">
        </script>
    </head>
    
    <body onload="refreshCount();">
        <div class="MIB_blogb">
            <!--顶托盘-->
            <%@include file="../common/bannner.jsp" %>
            <!--/顶托盘-->
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
                              
                               
                                <div node-type="school_create">
                                    <div class="title MIB_linedot2 title1">
                                        <span class="fb">
                                            修改教育信息
                                        </span>
                                    </div>
                                    <form:form id="educationinfo" action="updateEducationinfo" method="post"
                                    modelAttribute="user">
                                        <div class="info_tab01" node-type="formSchool_create">
                                            <table>
                                                <tbody>
                                                    <tr>
                                                        <th class="gray6">
                                                            	学校类型：
                                                        </th>
                                                        <td class="info_tab_vm">
                                                            <form:select node-type="school_type" name="educationinfo.schoolType" 
                                                            path="schoolType">
                                                                <c:forEach items="${types}" var="type">
                                                                	<option value="${type.value}">
                                                                		${type.key}
                                                                	</option>
                                                                </c:forEach>
                                                            </form:select>
                                                           
                                        </div>
                                        </td>
                                        <td node-type="tip">
                                        </td>
                                        </tr>
                                        </table>
                                        <table>
                                            <tr>
                                                <th class="gray6">
                                                    <em class="error_color">
                                                        
                                                    </em>
                                                    学校名称：
                                                </th>
                                                
                                                <td>
                                                    <form:input node-type="school_name" name="educationinfo.schoolName" type="text" id="schoolName"
                                                    value="${user.schoolName}" class="PY_input gray9" onclick="onclickShowStyleOfSchoolName()" 
                                                    onblur="onblurValidateSchoolName('schoolName')" path="schoolName"/>
                                                   
                                                    <form:select node-type="start" name="user.schoolTime" 
                                                    path="schoolTime" class="setup_sel">
                                                    	
                                                        <option value="${user.schoolTime }">
                                                           	 请选择
                                                        </option>
                                                        <c:forEach items="${years}" var="y">
                                                        	<option value="${y }">${y }</option>
                                                        </c:forEach>
                                                    </form:select>
                                                </td>
                                                <td>
                                                        	<div class="setup_info" style="display: none;" id="successSchoolName">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>
                                                            <table class="cudTs" style="display:none" id="inputSchoolName1">
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
                                                            <table class="cudTs3" style="display:none;" id="errorSchoolName2">
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
                                            <tr >
                                                <th class="gray6">
                                                    <span >
                                                        院系：
                                                    </span>
                                                </th>
                                                <td>
                                                    <form:input name="educationinfo.college" type="text"  id="college" value="${user.college}"
                                                    class="PY_input gray9" path="college" onclick="onclickShowStyleOfCollege()" 
                                                    onblur="onblurValidateCollege('college')"/>
                                                </td>
                                                <td node-type="tip">
                                                        	<div class="setup_info" style="display: none;" id="successCollege">
                                                                <div class="info_tip2">
                                                                    <div class="tipicon tip3" title="">
                                                                    </div>
                                                                </div>
                                                                <div class="info_tip1">
                                                                </div>
                                                            </div>
                                                            <table class="cudTs" style="display:none" id="inputCollege1">
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
                                                            <table class="cudTs3" style="display:none;" id="errorCollege2">
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
                                            <tr>
                                                <th>
                                                </th>
                                                <td>
                                                    <a class="newabtngrn" href="javascript:toSubmitChange('educationinfo')"
                                                    id="submit_education" class="newabtngrn">
                                                        <em>
                                                            保存
                                                        </em>
                                                    </a>
                                                    <a class="btn_normal btns" href="javascript:;">
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
                        </div>
                        <!-- /信息列表 -->
                    </div>
                    <!--/个人资料-->
                </div>
            </div>
           </div>
        <!--/找朋友-->
        
        </div>
        <!--/正文-->
        <!--尾-->

        <%@include file="../common/foot.jsp" %>
    </body>

</html>