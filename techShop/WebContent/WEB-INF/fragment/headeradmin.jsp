<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="javax.servlet.*,model.*,java.util.*" pageEncoding="UTF-8"
	session="true"%>


<div class="header" style="background-color: #1c1c1c;">

	<div class='menu' id='menubar' onclick="openNav();">
		<span id='menu-symbol' class='symbol'><i class="fas fa-bars"></i></span>
		<!--&#9776; -->
		<span id='menu-x' class='symbol-x'><i class="fas fa-times"></i></span>
	</div>
	<div class='logo'>
		<img src='<%=getServletContext().getContextPath() %>/images/utilities/logotsw.jpg'
			alt='Nome Negozio' title='Logo Nome Negozio'>
		<p></p>
	</div>
	<div class='cerca'></div>
	<div class='cart' onclick="">
		<span><a href='../Logout'
			style='font-weight: 400; text-decoration: none; color: #141414;'><i
				class="fas fa-sign-out-alt"></i></a></span>
		<!--&#128722;-->
	</div>





</div>