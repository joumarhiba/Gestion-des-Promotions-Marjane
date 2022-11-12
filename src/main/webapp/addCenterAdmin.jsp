<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Admin Page</title>
  <%@include file="helpers/links.jsp" %>
</head>
<body style="background-image: url('helpers/adminImg.jpg');  background-position: center; background-repeat: no-repeat; background-size: cover;">
<%@include file="sidebarAGen.jsp" %>

<div class="container mt-8 flex relative place-content-center">

  <div class="relative sm:max-w-xl sm:mx-auto">
    <form action="CenterAdminServlet" method="post" class="relative px-8 py-8 bg-white mx-8 md:mx-0 shadow rounded-3xl sm:p-10">
      <div class="max-w-md mx-auto">
        <div class="flex items-center space-x-5">
          <div class="h-14 w-14 flex flex-shrink-0 justify-center items-center text-2xl font-mono"><img src="helpers/images.png" /></div>
          <div class="block pl-2 font-semibold text-xl self-start text-gray-700">
            <h2 class="leading-relaxed">Create a center admin</h2>
            <p class="text-sm text-gray-500 font-normal leading-relaxed">Lorem ipsum, dolor sit amet consectetur adipisicing elit.</p>
          </div>
        </div>
        <div class="divide-y divide-gray-200">
          <div class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">
            <div class="flex flex-col">
              <label class="leading-loose">Nom d Utilisateur</label>
              <input type="text" name="fullname" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Username">
            </div>
            <div class="flex flex-col">
              <label class="leading-loose">Email</label>
              <input type="email" name="email" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Entrer Votre Email" autoComplete="off" >
            </div>
            <div class="flex flex-col">
              <label class="leading-loose">Ville du Centre</label>
              <input type="text" name="ville" autoComplete="off" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Ville ...">
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
</body>
</html>
