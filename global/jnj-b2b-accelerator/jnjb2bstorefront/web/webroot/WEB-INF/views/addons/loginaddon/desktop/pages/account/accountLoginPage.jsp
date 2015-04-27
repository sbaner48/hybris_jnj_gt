<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/loginaddon/desktop/template" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/desktop/user" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>


<template:loginPage pageTitle="${pageTitle}">
	<!-- Login first panel wrapper start-->     
	<body onload="checkCookie()">
		<c:url value="/logout" var="logoutURL" />
		<input type="hidden" id="hddnLogoutURL" value="${logoutURL}" />
		<div class="sectionBlock">
			<div class="span-15 loginbannerSlot">
				<div class="loginLeftSlot">
					<c:choose>
						<c:when test="${signout ne null}">
							<cms:pageSlot position="SideContentLogout" var="feature" >
								<cms:component component="${feature}"/>
							</cms:pageSlot>
						</c:when>
						<c:otherwise>
							<cms:pageSlot position="SideContent" var="feature" >
								<cms:component component="${feature}"/>
							</cms:pageSlot>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<!-- Login right Panel starts-->
			<c:url value="/j_spring_security_check" var="loginActionUrl"/>
			<form method="post" action="${loginActionUrl}" id="loginForm" name="loginForm" id="loginpagevalid">
         		<div class="span-9 last loginSlot">
					<h2>Login</h2>
           			<div class="logininfo">
						<span>
							<label for="logintxt">login.user.login</label>
							<input type="text" data-msg-required="Username or password incorrect." class="login_img textbox required" id="j_username" name="j_username" />
						</span>
						<span>
							<label for="passwordtxt">login.user.password</label>
							<input type="password" data-msg-required="Username or password incorrect." class="pass_img textbox required" id="j_password" name="j_password" />
						</span>
						<div class="recPassError"></div>
						<span>
							<a class="password-forgotten" href="javascript:;">login.user.forgot</a>
						</span>
						<c:if test="${!empty loginError}">
							<div class="registerError">
								<c:choose>
									<c:when test="${attemptsExceeded ne null}">
										<label for="state" class="error">
											login.attempts.exceeded
										</label>
									</c:when>
									<c:otherwise>
										<label for="state" class="error">
											<messageLabel:message messageCode="${loginError}" />
										</label>
									</c:otherwise>
								</c:choose>
							</div>
						</c:if>
						<div class="buttonloginWrapper">
							<span>
								<input type="button" value='login.header' class="primarybtn" id="loginButton">
							</span>
							<span class="saveMyUsername">
								<input type="checkbox" id="saveuserChkBox">
								<label for="saveuser">login.user.save</label>
								${addOnJavaScriptPaths}
							</span>
						</div>          			
			       </div>
			   </div>
			</form>   
		</div>
		<input type="hidden" id="passwordExpiryFlag" value="${passwordExpired}">
		<input type="hidden" id="passwordExpireToken" value="${passwordExpireToken}">
		<input type="hidden" id="helpFlag" value="${helpFlag}">
		<input type="hidden" id="email" value="${email}">
		
	</body>
</template:loginPage>