<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.marjane.dao.AdminDao"%>
<%@page import="com.marjane.dao.CenterDao"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="com.marjane.entities.Admin" %>
<%@page import="com.marjane.entities.Center" %>

<html>
<head>
  <title>Admin Page</title>
  <%@include file="helpers/links.jsp" %>
</head>
<body>
<%@include file="sidebarAGen.jsp" %>
<div class="container -top-3/4 flex relative">
statistiiics
</div>
<div class="container grid grid-cols-4 gap-x-1">

<%
AdminDao adminDao = new AdminDao();
List<Admin> listAdmins = adminDao.getAdmins();
for(Admin c : listAdmins) {
%>

<div class="flex w-full items-center flex justify-center items-center py-12 px-6">
            <div>
                <div class="max-w-xs h-64 flex flex-col justify-between bg-white dark:bg-gray-800 rounded-lg border border-gray-400 mb-6 py-5 px-4">
                    <div>
                        <h5 tabindex="0" class="focus:outline-none text-gray-800 dark:text-gray-100 font-bold mb-3"><%=c.getEmail() %></h5>
                        <p tabindex="0" class="focus:outline-none text-gray-800 dark:text-gray-100 text-sm">Probabo, inquit, sic agam, ut labore et voluptatem sequi nesciunt.</p>
                    </div>
                    <div>
                        <div class="flex items-center justify-between text-gray-800">
                            <p tabindex="0" class="focus:outline-none text-sm text-gray-400">Cree par supAdmin@gmail.com</p>
                            <a href="" class="mr-4">
                            <div class="w-8 h-8 rounded-full bg-gray-800 text-white flex items-center justify-center">
                                <img src="https://tuk-cdn.s3.amazonaws.com/can-uploader/single_card_with_title_and_description-svg1.svg" alt="icon"/>
                            </div>
                            </a>
                            <a onclick="return confirm('Vous confirmez la suppression ? ')" href="DeleteAdminServlet?idAdmin=<%=c.getId() %>">
                            <div class="w-8 h-8 rounded-full bg-gray-800 text-white flex items-center justify-center">
                                <i class="fa fa-trash" aria-hidden="true"></i>
                            </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%
}
%>
</div>
</body>
</html>
