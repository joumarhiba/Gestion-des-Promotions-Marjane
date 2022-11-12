<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Admin Sidebar</title>
  <%@include file="../helpers/links.jsp" %>
</head>
<body>

<div class="flex flex-row position-sticky relative">

  <!-- Sidebar -->
  <aside class="w-16 flex flex-col space-y-10 items-center justify-center relative bg-blue-900 text-white h-screen fixed-top">
    <!-- Dashboard ( get promotions by category ) -->
    <a href="dashboardChefRayon.jsp" class="h-10 w-10 flex items-center text-white justify-center rounded-lg cursor-pointer hover:text-gray-800 hover:bg-white hover:duration-300 hover:ease-linear focus:bg-white">
        <svg class="w-5 h-5" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M19 11H5M19 11C20.1046 11 21 11.8954 21 13V19C21 20.1046 20.1046 21 19 21H5C3.89543 21 3 20.1046 3 19V13C3 11.8954 3.89543 11 5 11M19 11V9C19 7.89543 18.1046 7 17 7M5 11V9C5 7.89543 5.89543 7 7 7M7 7V5C7 3.89543 7.89543 3 9 3H15C16.1046 3 17 3.89543 17 5V7M7 7H17" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" /></svg>
    </a>

    <!-- update Promotion -->
    <a class="h-10 w-10 flex items-center justify-center rounded-lg cursor-pointer text-white hover:text-gray-800 hover:bg-white  hover:duration-300 hover:ease-linear focus:bg-white no-underline" href="editPromotion.jsp">
        <i class="fa fa-edit" aria-hidden="true"></i>
    </a>
  </aside>



  <div class="w-full h-full flex flex-col justify-between position-sticky">
    <!-- Header -->
    <header class="h-16 w-full flex items-center relative justify-end px-5 space-x-10 bg-blue-900">
      <div class="flex flex-shrink-0 items-center space-x-4 text-white">

        <!-- Texto -->
        <div class="flex flex-col items-end ">
          <!-- Name -->
          <c:if test="${not empty email }" >
          <div class="text-md font-medium ">${email }</div>
              <c:remove var="email" />
          <!-- Título -->
          <div class="text-sm font-regular">Chef</div>
        </div>

        <!-- avatar -->
         <div class="flex items-center px-4 -mx-2">
            <img class="object-cover mx-2 rounded-full h-9 w-9" src="https://images.unsplash.com/photo-1531427186611-ecfd6d936c79?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80" alt="avatar" />
        </div>
      </div>
    </header>

  </div>

</div>
</body>
</html>