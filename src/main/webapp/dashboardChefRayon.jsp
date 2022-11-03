<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Admin Page</title>
  <%@include file="helpers/links.jsp" %>
  <%@page import="com.marjane.dao.ChefRayonDao"%>
  <%@page import="com.marjane.entities.Category"%>
  <%@page import="java.util.List"%>
</head>
<body>
<%@include file="sidebarCRayon.jsp" %>


<%
ChefRayonDao chefRayonDao = new ChefRayonDao();
int idCategory = chefRayonDao.validate("chefBbb@gmail.com","1234");
List<Object> promos = chefRayonDao.getPromotions(idCategory);
for(int i = 0 ; i < promos.size(); i++) {
%>


<div class="overflow-x-auto relative">
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="py-3 px-6">
                    Promotion
                </th>
                <th scope="col" class="py-3 px-6">
                    Price
                </th>
            </tr>
        </thead>
        <tbody>
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
<%=promos.get(i)  %>
                </th>
                <td class="py-4 px-6">
                    200 MAD
                </td>

            </tr>
        </tbody>
    </table>
</div>


<!-- <p><%=promos.get(i)  %> % - <%=idCategory %></p> -->

<%
}
%>
</body>
</html>
