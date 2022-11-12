<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Admin Page</title>
  <%@include file="helpers/links.jsp" %>
  <%@page import="com.marjane.dao.ChefRayonDao"%>
  <%@page import="com.marjane.entities.Category"%>
  <%@page import="java.util.*"%>
  <%@page import="java.text.*"%>
</head>
<body>
<%@include file="sidebarCRayon.jsp" %>



<div class="container">

<div class="my-8 ">
  <form action="LogoutChefRayonServlet" method="post" class="flex flex-row justify-content-end">
                <input type="hidden" value="${idCategory }" name="idCategory" />

               <button type="submit" class="bg-yellow-500 p-2 rounded-md">
                Deconnecter
               </button>
             </form>
             </div>

<div class="mt-12 overflow-x-auto relative flex-row">
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
        int idCategory = chefRayonDao.validate("chefMutlimedia@gmail.com","1234");
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String testTime = formatter.format(new Date());
        Date date1=new SimpleDateFormat("HH:mm").parse(testTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, 1);
        List<Object> promos = chefRayonDao.getPromotions(idCategory, cal.getTime());
        if(promos.size() > 0) {
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
                <input type="hidden" value="${idCategory }" name="idCategory" />
                    <input type="hidden" value="23" name="idPromo" />
                    <button type="submit" class="text-green-900 hover:text-green-600">appliquer</button>
                </form>
                </td>
            </tr>
        </tbody>
        <%
        }
        }else {
        %>
    </table>
    <p>time outtttttttttttttttt !!!!!!!!!!!!</p>
    <%
    }
    %>
</div>
</div>

</body>
</html>
