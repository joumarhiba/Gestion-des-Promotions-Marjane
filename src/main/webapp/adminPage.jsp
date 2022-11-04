<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.marjane.entities.Center" %>
<%@page import="com.marjane.dao.CenterDao"%>
<%@page import="com.marjane.entities.Category"%>
<%@page import="com.marjane.dao.CategoryDao"%>

<%@page import="java.util.List"%>

<html>
<head>
  <title>Admin Page</title>
  <%@include file="helpers/links.jsp" %>
  <%@page import="com.marjane.dao.PromotionDao"%>
</head>
<body>
<%@include file="sideBarACenter.jsp" %>

<div class="container -top-3/4 flex relative">
<div class="container my-24 px-6 mx-auto">

  <!-- Section: Design Block -->
  <section class="mb-32 text-gray-800 text-center">
    <h2 class="text-3xl font-bold mb-20">Why is it so great?</h2>

    <div class="grid lg:gap-x-12 lg:grid-cols-3">
      <div class="mb-12 lg:mb-0">
        <div class="rounded-lg shadow-lg h-full block bg-white">
          <div class="flex justify-center">
            <div class="p-4 bg-blue-800 rounded-full shadow-lg inline-block -mt-8">
              <i class="fa fa-check text-white" aria-hidden="true"></i>
            </div>
          </div>
          <div class="p-6">
          <%
          PromotionDao promotionDao = new PromotionDao();
          String data = promotionDao.getAppliedPromotions();
          String[] promotions = data.split("-");
          String applied = promotions[0];
          String notApplied = promotions[1];
          String nbPromo = promotions[2];
          %>
            <h3 class="text-2xl font-bold text-blue-600 mb-4"><%=applied %></h3>
            <h5 class="text-lg font-medium mb-4">Promotions Appliquees</h5>
            <p class="text-gray-500">
              Laudantium totam quas cumque pariatur at doloremque hic quos quia eius
            </p>
          </div>
        </div>
      </div>

      <div class="mb-12 lg:mb-0">
        <div class="rounded-lg shadow-lg h-full block bg-white">
          <div class="flex justify-center">
            <div class="p-4 bg-blue-800 rounded-full shadow-lg inline-block -mt-8">
              <i class="fa fa-times text-white" aria-hidden="true"></i>
            </div>
          </div>
          <div class="p-6">
            <h3 class="text-2xl font-bold text-blue-600 mb-4"><%=notApplied %></h3>
            <h5 class="text-lg font-medium mb-4">Promotions Non-appliquees</h5>
            <p class="text-gray-500">
              Eum nostrum fugit numquam, voluptates veniam neque quibusdam ullam
            </p>
          </div>
        </div>
      </div>

      <div class="">
        <div class="rounded-lg shadow-lg h-full block bg-white">
          <div class="flex justify-center">
            <div class="p-4 bg-blue-800 rounded-full shadow-lg inline-block -mt-8">
              <svg
                class="w-7 h-7 text-white"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 640 512"
              >
                <path
                  fill="currentColor"
                  d="M512.1 191l-8.2 14.3c-3 5.3-9.4 7.5-15.1 5.4-11.8-4.4-22.6-10.7-32.1-18.6-4.6-3.8-5.8-10.5-2.8-15.7l8.2-14.3c-6.9-8-12.3-17.3-15.9-27.4h-16.5c-6 0-11.2-4.3-12.2-10.3-2-12-2.1-24.6 0-37.1 1-6 6.2-10.4 12.2-10.4h16.5c3.6-10.1 9-19.4 15.9-27.4l-8.2-14.3c-3-5.2-1.9-11.9 2.8-15.7 9.5-7.9 20.4-14.2 32.1-18.6 5.7-2.1 12.1.1 15.1 5.4l8.2 14.3c10.5-1.9 21.2-1.9 31.7 0L552 6.3c3-5.3 9.4-7.5 15.1-5.4 11.8 4.4 22.6 10.7 32.1 18.6 4.6 3.8 5.8 10.5 2.8 15.7l-8.2 14.3c6.9 8 12.3 17.3 15.9 27.4h16.5c6 0 11.2 4.3 12.2 10.3 2 12 2.1 24.6 0 37.1-1 6-6.2 10.4-12.2 10.4h-16.5c-3.6 10.1-9 19.4-15.9 27.4l8.2 14.3c3 5.2 1.9 11.9-2.8 15.7-9.5 7.9-20.4 14.2-32.1 18.6-5.7 2.1-12.1-.1-15.1-5.4l-8.2-14.3c-10.4 1.9-21.2 1.9-31.7 0zm-10.5-58.8c38.5 29.6 82.4-14.3 52.8-52.8-38.5-29.7-82.4 14.3-52.8 52.8zM386.3 286.1l33.7 16.8c10.1 5.8 14.5 18.1 10.5 29.1-8.9 24.2-26.4 46.4-42.6 65.8-7.4 8.9-20.2 11.1-30.3 5.3l-29.1-16.8c-16 13.7-34.6 24.6-54.9 31.7v33.6c0 11.6-8.3 21.6-19.7 23.6-24.6 4.2-50.4 4.4-75.9 0-11.5-2-20-11.9-20-23.6V418c-20.3-7.2-38.9-18-54.9-31.7L74 403c-10 5.8-22.9 3.6-30.3-5.3-16.2-19.4-33.3-41.6-42.2-65.7-4-10.9.4-23.2 10.5-29.1l33.3-16.8c-3.9-20.9-3.9-42.4 0-63.4L12 205.8c-10.1-5.8-14.6-18.1-10.5-29 8.9-24.2 26-46.4 42.2-65.8 7.4-8.9 20.2-11.1 30.3-5.3l29.1 16.8c16-13.7 34.6-24.6 54.9-31.7V57.1c0-11.5 8.2-21.5 19.6-23.5 24.6-4.2 50.5-4.4 76-.1 11.5 2 20 11.9 20 23.6v33.6c20.3 7.2 38.9 18 54.9 31.7l29.1-16.8c10-5.8 22.9-3.6 30.3 5.3 16.2 19.4 33.2 41.6 42.1 65.8 4 10.9.1 23.2-10 29.1l-33.7 16.8c3.9 21 3.9 42.5 0 63.5zm-117.6 21.1c59.2-77-28.7-164.9-105.7-105.7-59.2 77 28.7 164.9 105.7 105.7zm243.4 182.7l-8.2 14.3c-3 5.3-9.4 7.5-15.1 5.4-11.8-4.4-22.6-10.7-32.1-18.6-4.6-3.8-5.8-10.5-2.8-15.7l8.2-14.3c-6.9-8-12.3-17.3-15.9-27.4h-16.5c-6 0-11.2-4.3-12.2-10.3-2-12-2.1-24.6 0-37.1 1-6 6.2-10.4 12.2-10.4h16.5c3.6-10.1 9-19.4 15.9-27.4l-8.2-14.3c-3-5.2-1.9-11.9 2.8-15.7 9.5-7.9 20.4-14.2 32.1-18.6 5.7-2.1 12.1.1 15.1 5.4l8.2 14.3c10.5-1.9 21.2-1.9 31.7 0l8.2-14.3c3-5.3 9.4-7.5 15.1-5.4 11.8 4.4 22.6 10.7 32.1 18.6 4.6 3.8 5.8 10.5 2.8 15.7l-8.2 14.3c6.9 8 12.3 17.3 15.9 27.4h16.5c6 0 11.2 4.3 12.2 10.3 2 12 2.1 24.6 0 37.1-1 6-6.2 10.4-12.2 10.4h-16.5c-3.6 10.1-9 19.4-15.9 27.4l8.2 14.3c3 5.2 1.9 11.9-2.8 15.7-9.5 7.9-20.4 14.2-32.1 18.6-5.7 2.1-12.1-.1-15.1-5.4l-8.2-14.3c-10.4 1.9-21.2 1.9-31.7 0zM501.6 431c38.5 29.6 82.4-14.3 52.8-52.8-38.5-29.6-82.4 14.3-52.8 52.8z"
                />
              </svg>
            </div>
          </div>
          <div class="p-6">
            <h3 class="text-2xl font-bold text-blue-600 mb-4"><%=nbPromo %></h3>
            <h5 class="text-lg font-medium mb-4">Total des Promotions</h5>
            <p class="text-gray-500">
              Cupiditate enim, minus nulla dolor cumque iure eveniet facere ullam
            </p>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- Section: Design Block -->



    <div class="relative sm:max-w-xl sm:mx-auto">
      <form action="AddChefRayonServlet" method="post" class="relative px-8 py-8 bg-white mx-8 md:mx-0 shadow rounded-3xl sm:p-10">
        <div class="max-w-md mx-auto">
          <div class="flex items-center space-x-5">
            <div class="h-14 w-14 bg-yellow-200 rounded-full flex flex-shrink-0 justify-center items-center text-yellow-500 text-2xl font-mono">m</div>
            <div class="block pl-2 font-semibold text-xl self-start text-gray-700">
              <h2 class="leading-relaxed">Ajouter un chef du  rayon</h2>
              <p class="text-sm text-gray-500 font-normal leading-relaxed">Lorem ipsum, dolor sit amet consectetur adipisicing elit.</p>
            </div>
          </div>
          <div class="divide-y divide-gray-200">
            <div class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">

              <div class="flex flex-col">
                <label class="leading-loose">Email</label>
                <input type="email" name="email" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Entrer Votre Email" autoComplete="off" >
              </div>
                <div class="flex flex-col">
                  <label class="leading-loose">Mot de passe</label>
                  <input type="password" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Username">
                </div>
              <div class="flex flex-col">
                <label for="center" class="leading-loose">Nom du centre</label>
                  <select id="center" name="center" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">
                      <option value="">Selectionner le centre </option>
                      <%
                         CenterDao centerdao = new CenterDao();
                        List<Center> listCenter = centerdao.getCenters();
                        for(Center centre : listCenter) {

                        %>
                      <option name="center" value="<%=centre.getId() %>"><%=centre.getVille() %></option>
                      <%
                      }
                      %>
                  </select>
                </div>
                 <div class="md:col-span-5">
                <label for="category">Nom de la Categorie</label>
              <select id="category" name="category" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">
                  <option value="">Selectionner une categorie  </option>
                  <%
                   CategoryDao dao = new CategoryDao();
                  List<Category> list = dao.getCategory();
                  for(Category cat : list) {

                  %>
                  <option name="category" value="<%=cat.getId() %>"><%=cat.getName() %></option>
                  <%
                  }
                  %>

              </select>
              </div>
            </div>
            <div class="pt-4 flex items-center space-x-4">
                <button class="flex justify-center items-center w-full text-gray-900 px-4 py-3 rounded-md focus:outline-none">
                  <svg class="w-6 h-6 mr-3" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path></svg> Cancel
                </button>
                <button type="submit" class="bg-blue-800 hover:bg-blue-900 flex justify-center items-center w-full text-white px-4 py-3 rounded-md focus:outline-none">Create</button>
            </div>
          </div>
        </div>
    </form>
  </div>

</div>
</div>


</body>
</html>
