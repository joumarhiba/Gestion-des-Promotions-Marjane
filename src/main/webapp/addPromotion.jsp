<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.marjane.dao.CategoryDao"%>
<%@page import="com.marjane.dao.CenterDao"%>
<%@page import="java.util.List"%>
<%@page import="com.marjane.entities.Category"%>
<%@page import="com.marjane.entities.Center" %>
<html>
<head>
  <title>Admin Page</title>
  <%@include file="../sideBarACenter.jsp" %>
</head>
<body>

<div class="h-screen w-full bg-white relative flex">
<div class="w-full h-full flex flex-col justify-between">
<main class="container -top-3/4 flex relative">
      <div class="h-full w-full m-4 flex flex-wrap items-start justify-center rounded-tl grid-flow-col auto-cols-max gap-4">

            <div class="text-center flex justify-center flex-col">
                <div class="min-h-auto p-6 bg-gray-100 flex items-center justify-center">
                  <div class="container max-w-screen-lg mx-auto">
                    <div>
                      <h2 class="font-semibold text-xl text-gray-600 mb-10">Ajouter Une Promotion</h2>
<c:if test="${not empty successMsg }" >
        <p class="text-center text-green-600">${successMsg }</p>
    <c:remove var="successMsg" />
</c:if>
       <c:if test="${not empty errorMsg }" >
               <p class="text-center text-red-600">${errorMsg }</p>
           <c:remove var="errorMsg" />
       </c:if>
                      <form action="AddPromotionServlet" method="post" class="bg-white rounded shadow-lg p-4 px-4 md:p-8 mb-6">
                        <div class="grid gap-4 gap-y-2 text-sm grid-cols-1 lg:grid-cols-3">
                          <div class="text-gray-600">
                            <p class="font-medium text-lg">Les Details De La Promotion</p>
                            <p>Veuillez remplir tous les champs.</p>
                          </div>


                          <div class="lg:col-span-2">
                            <div class="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-5">
                              <div class="md:col-span-5">
                                <label for="center">Nom de la Categorie</label>
                              <select id="center" name="center" class="h-10 border mt-1 rounded px-4 w-full bg-gray-50 outline-none">
                                  <option value="">Selectionner une categorie  </option>
                                  <%
                                   CategoryDao dao = new CategoryDao();
                                  List<Category> list = dao.getCategory();
                                  for(Category cat : list) {

                                  %>
                                  <option name="category" value="<%=cat.getId() %>"><%=cat.getName() %>  - <%=cat.getId() %></option>
                                  <%
                                  }
                                  %>

                              </select>
                              </div>

                              <div class="md:col-span-5">
                                <label for="category">Nom du centre</label>
                              <select id="category" name="category" class="h-10 border mt-1 rounded px-4 w-full bg-gray-50 outline-none">
                                  <option value="">Selectionner le centre </option>
                                  <%
                                     CenterDao centerdao = new CenterDao();
                                    List<Center> listCenter = centerdao.getCenters();
                                    for(Center centre : listCenter) {

                                    %>
                                  <option name="center" value="<%=centre.getId() %>"><%=centre.getVille() %> - <%=centre.getId() %></option>
                                  <%
                                  }
                                  %>
                              </select>
                              </div>

                              <div class="md:col-span-3">
                                <label for="date">Date d Expiration</label>
                                <div class="relative focus-within:text-gray-600 text-gray-400">
                                  <input type="text" name="date" class="h-10 border mt-1 rounded px-4 w-full bg-gray-50 outline-none" placeholder="25/02/2020">
                                  <div class="absolute right-3 top-2">
                                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"></path></svg>
                                  </div>
                                </div>
                              </div>

                              <div class="md:col-span-2 mb-8">

                                <label for="promo">Taux du Reduction</label>
                                <input type="number" name="promo" id="promo" class="outline-none h-10 border mt-1 rounded px-4 w-full bg-gray-50" value="" placeholder="" />
                              </div>
                              </div>

                              <div class="md:col-span-5 text-right">
                                <div class="inline-flex items-end">
                                  <button type="submit" class="bg-blue-800 hover:bg-blue-900 text-white font-bold py-2 px-4 rounded">Ajouter</button>
                                </div>
                              </div>

                            </div>
                          </div>
                        </div>
                      </form>
                    </div>

                    <a href="https://www.buymeacoffee.com/dgauderman" target="_blank" class="md:absolute bottom-0 right-0 p-4 float-right">
                      <img src="https://www.buymeacoffee.com/assets/img/guidelines/logo-mark-3.svg" alt="Buy Me A Coffee" class="transition-all rounded-full w-14 -rotate-45 hover:shadow-sm shadow-lg ring hover:ring-4 ring-white">
                    </a>
                  </div>
                </div>
            </div>

           <!--   <div class="h-full w-full m-4 flex flex-wrap items-start justify-start rounded-tl grid-flow-col auto-cols-max gap-4">
                <h2>ffffffff ffffffffffffff fffff fffff</h2>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                          <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
                        </div> -->
                  </div>
 </main>
      </div>
      </div>



      <script>
      $(function() {
      var dateToday = new Date();
        $('input[name="date"]').daterangepicker({
          singleDatePicker: true,
          showDropdowns: true,
          minYear: 1901,
          maxYear: parseInt(moment().format('YYYY'),10),
          minDate: dateToday,
        }, function(start, end, label) {
          var years = moment().diff(start, 'years');

        });
      });
      </script>

</body>
</html>