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



<div class="container -top-3/4 flex relative place-content-center">
<!-- <div class="max-w-full mx-4 py-6 sm:mx-auto sm:px-6 lg:px-8">
    <div class="sm:flex sm:space-x-4">
        <div class="inline-block align-bottom bg-white rounded-lg text-left overflow-hidden shadow transform transition-all mb-4 w-full sm:w-1/3 sm:my-8">
            <div class="bg-white p-5">
                <div class="sm:flex sm:items-start">
                    <div class="text-center sm:mt-0 sm:ml-2 sm:text-left">
                        <h3 class="text-sm leading-6 font-medium text-gray-400">Total Subscribers</h3>
                        <p class="text-3xl font-bold text-black">71,897</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="inline-block align-bottom bg-white rounded-lg text-left overflow-hidden shadow transform transition-all mb-4 w-full sm:w-1/3 sm:my-8">
            <div class="bg-white p-5">
                <div class="sm:flex sm:items-start">
                    <div class="text-center sm:mt-0 sm:ml-2 sm:text-left">
                        <h3 class="text-sm leading-6 font-medium text-gray-400">Avg. Open Rate</h3>
                        <p class="text-3xl font-bold text-black">58.16%</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="inline-block align-bottom bg-white rounded-lg text-left overflow-hidden shadow transform transition-all mb-4 w-full sm:w-1/3 sm:my-8">
            <div class="bg-white p-5">
                <div class="sm:flex sm:items-start">
                    <div class="text-center sm:mt-0 sm:ml-2 sm:text-left">
                        <h3 class="text-sm leading-6 font-medium text-gray-400">Avg. Click Rate</h3>
                        <p class="text-3xl font-bold text-black">24.57%</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> -->
<div class="mb-8 overflow-x-auto relative">
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="py-3 px-6">
                    Promotion
                </th>
                <th scope="col" class="py-3 px-6">
                    Price
                </th>
                <th scope="col" class="px-3 py-6">
                options
              </th>
            </tr>
        </thead>
        <%
        ChefRayonDao chefRayonDao = new ChefRayonDao();
        int idCategory = chefRayonDao.validate("chefBbb@gmail.com","1234");
        //int id = chefRayonDao.promoInfos(idCategory);
        List<Object> promos = chefRayonDao.getPromotions(idCategory);
        for(int i = 0 ; i < promos.size(); i++) {
        %>
        <tbody>
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <td scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white"><%=promos.get(i)  %>
                </td>
                <td class="py-4 px-6">
                    100 MAD
                </td>
                <td class="py-4 px-6">
                <form method="post" action="UpdatePromotionServlet">
                    <input type="hidden" value="23" name="idPromo" />
                    <button type="submit" class="text-green-900 hover:text-green-600">appliquer</button>
                </form>
                </td>
            </tr>
        </tbody>
        <%
        }
        %>
    </table>
</div>
</div>

</body>
</html>
