<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Admin Sidebar</title>
  <%@include file="../helpers/links.jsp" %>
</head>
<body>

<div class="h-full w-full bg-white relative flex overflow-hidden">

  <!-- Sidebar -->
  <aside class="h-full w-16 flex flex-col space-y-10 items-center justify-center relative bg-blue-900 text-white">
    <!-- Dashboard -->
    <a href="adminPage.jsp" class="h-10 w-10 flex items-center text-white justify-center rounded-lg cursor-pointer hover:text-gray-800 hover:bg-white hover:duration-300 hover:ease-linear focus:bg-white">
        <svg class="w-5 h-5" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M19 11H5M19 11C20.1046 11 21 11.8954 21 13V19C21 20.1046 20.1046 21 19 21H5C3.89543 21 3 20.1046 3 19V13C3 11.8954 3.89543 11 5 11M19 11V9C19 7.89543 18.1046 7 17 7M5 11V9C5 7.89543 5.89543 7 7 7M7 7V5C7 3.89543 7.89543 3 9 3H15C16.1046 3 17 3.89543 17 5V7M7 7H17" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" /></svg>
    </a>

    <!-- Add Promotion -->
    <a class="h-10 w-10 flex items-center justify-center rounded-lg cursor-pointer text-white hover:text-gray-800 hover:bg-white  hover:duration-300 hover:ease-linear focus:bg-white no-underline" href="addPromotion.jsp">
        <i class="fa fa-plus" aria-hidden="true"></i>
    </a>

    <!-- Edit Promotion -->
    <a href="editPromotion" class="h-10 w-10 flex items-center justify-center text-white rounded-lg cursor-pointer hover:text-gray-800 hover:bg-white  hover:duration-300 hover:ease-linear focus:bg-white">
      <i class="fas fa-edit"></i>
    </a>

    <!-- Logout -->
   <form action="LogoutServlet" method="get">
               <button type="submit">
                 <svg
                   class="fill-current h-5 w-5 text-white mx-auto hover:text-red-500"
                   viewBox="0 0 24 24"
                   fill="none"
                   xmlns="http://www.w3.org/2000/svg"
                 >
                   <path
                     d="M13 4.00894C13.0002 3.45665 12.5527 3.00876 12.0004 3.00854C11.4481 3.00833 11.0002 3.45587 11 4.00815L10.9968 12.0116C10.9966 12.5639 11.4442 13.0118 11.9965 13.012C12.5487 13.0122 12.9966 12.5647 12.9968 12.0124L13 4.00894Z"
                     fill="currentColor"
                   />
                   <path
                     d="M4 12.9917C4 10.7826 4.89541 8.7826 6.34308 7.33488L7.7573 8.7491C6.67155 9.83488 6 11.3349 6 12.9917C6 16.3054 8.68629 18.9917 12 18.9917C15.3137 18.9917 18 16.3054 18 12.9917C18 11.3348 17.3284 9.83482 16.2426 8.74903L17.6568 7.33481C19.1046 8.78253 20 10.7825 20 12.9917C20 17.41 16.4183 20.9917 12 20.9917C7.58172 20.9917 4 17.41 4 12.9917Z"
                     fill="currentColor"
                   />
                 </svg>
               </button>
             </form>
  </aside>



  <div class="w-full h-full flex flex-col justify-between">
    <!-- Header -->
    <header class="h-16 w-full flex items-center relative justify-end px-5 space-x-10 bg-blue-900">
      <!-- Informação -->
      <div class="flex flex-shrink-0 items-center space-x-4 text-white">

        <!-- Texto -->
        <div class="flex flex-col items-end ">
          <!-- Nome -->
          <div class="text-md font-medium ">Unknow Unknow</div>
          <!-- Título -->
          <div class="text-sm font-regular">Student</div>
        </div>

        <!-- Foto -->
         <div class="flex items-center px-4 -mx-2">
            <img class="object-cover mx-2 rounded-full h-9 w-9" src="https://images.unsplash.com/photo-1531427186611-ecfd6d936c79?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80" alt="avatar" />
        </div>
      </div>
    </header>

    <!-- Main -->
  <!--  <main class="max-w-full h-full flex relative">

      <div class="h-full w-full m-4 flex flex-wrap items-start justify-start rounded-tl grid-flow-col auto-cols-max gap-4 overflow-y-scroll">

        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
        <div class="w-96 h-60 rounded-lg flex-shrink-0 flex-grow bg-gray-400"></div>
      </div>
    </main> -->
  </div>

</div>
</body>
</html>