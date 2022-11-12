<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.marjane.dao.AdminDao"%>
<%@page import="com.marjane.dao.CenterDao"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="com.marjane.entities.Admin" %>
<%@page import="com.marjane.entities.Center" %>
<%@ page import="javax.servlet.http.HttpUtils.*" %>

<html>
<head>
  <title>Admin Page</title>
  <%@include file="helpers/links.jsp" %>
</head>
<body>
<%@include file="sidebarAGen.jsp" %>
<div class="container flex relative justify-content-center mt-8">

<div class="flex h-screen">
   <div class="m-auto">
      <div>
         <a href="addCenterAdmin.jsp" class="relative w-full flex justify-center items-center px-5 py-2.5 font-medium tracking-wide text-white capitalize   bg-blue-900 rounded-md hover:bg-blue-800  focus:outline-none   transition duration-300 transform active:scale-95 ease-in-out">
            <svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF">
               <g>
                  <rect fill="none" height="24" width="24"></rect>
               </g>
               <g>
                  <g>
                     <path d="M19,13h-6v6h-2v-6H5v-2h6V5h2v6h6V13z"></path>
                  </g>
               </g>
            </svg>
            <span class="pl-2 mx-1 outline-none">Create new Admin</span>
         </a>
         <div class="mt-5 bg-white rounded-lg shadow">


            <div class="flex">
               <div class="flex-1 py-5 pl-5 overflow-hidden">
                  <svg class="inline align-text-top" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#000000">
                      <path d="M0 0h24v24H0V0z" fill="none"></path>
                      <path d="M5 18.08V19h.92l9.06-9.06-.92-.92z" opacity=".3"></path>
                      <path d="M20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.2-.2-.45-.29-.71-.29s-.51.1-.7.29l-1.83 1.83 3.75 3.75 1.83-1.83zM3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM5.92 19H5v-.92l9.06-9.06.92.92L5.92 19z"></path>
                   </svg>
                   <h1 class="inline text-2xl font-semibold leading-none">Edit Admin</h1>
               </div>
               <div class="flex-none pt-2.5 pr-2.5 pl-1"></div>
            </div>
            <%
                           AdminDao adminDao = new AdminDao();
                           String params = request.getQueryString();
                           String[] parts = params.split("=");
                           String part2 = parts[1];
                           int idAdmin = Integer.parseInt(part2);
                           List<Admin> ad = adminDao.getAdminById(idAdmin);

                           for(Admin a : ad) {
                           %>
            <form method="post" action="UpdateAdminServlet" >
            <div class="px-5 pb-5">
               <input type="hidden" name="idAdmin" value="<%=idAdmin %>">
               <input type="text" name="fullname" placeholder="Fullname" class=" text-black placeholder-gray-400 w-full px-4 py-2.5 mt-2 text-base transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">
               <input type="email" name="email" placeholder="email" class=" text-black placeholder-gray-400 w-full px-4 py-2.5 mt-2 text-base transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400">
               <div class="flex">
                  <div class="flex-grow w-1/4 pr-2">
                  <input type="number" placeholder="Role" name="role" class=" text-black placeholder-gray-600 w-full px-4 py-2.5 mt-2 text-base transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-none focus:bg-white dark:focus:bg-gray-800 focus:outline-none "></div>
                  <div class="flex-grow"><input placeholder="ville" name="ville" class=" text-black placeholder-gray-600 w-full px-4 py-2.5 mt-2 text-base   transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400"></div>
               </div>
            </div>
            <div class="flex flex-row-reverse p-3">
               <div class="flex-initial pl-3">
                  <button type="submit" class="flex items-center px-5 py-2.5 font-medium tracking-wide text-white capitalize   bg-blue-900 rounded-md hover:bg-blue-800  focus:outline-none focus:bg-blue-900  transition duration-300 transform active:scale-95 ease-in-out">
                     <svg class="text-white" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF">
                        <path d="M0 0h24v24H0V0z" fill="none"></path>
                        <path d="M5 5v14h14V7.83L16.17 5H5zm7 13c-1.66 0-3-1.34-3-3s1.34-3 3-3 3 1.34 3 3-1.34 3-3 3zm3-8H6V6h9v4z" opacity=".1"></path>
                        <path d="M17 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V7l-4-4zm2 16H5V5h11.17L19 7.83V19zm-7-7c-1.66 0-3 1.34-3 3s1.34 3 3 3 3-1.34 3-3-1.34-3-3-3zM6 6h9v4H6z"></path>
                     </svg>
                     <span class="pl-2 mx-1">Save</span>
                  </button>
               </div>
               <div class="flex-initial">
                  <button type="button" class="flex items-center px-5 py-2.5 font-medium tracking-wide text-black capitalize rounded-md hover:fill-current focus:outline-none  transition duration-300 transform active:scale-95 ease-in-out">
                     <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px">
                        <path d="M0 0h24v24H0V0z" fill="none"></path>
                        <path d="M8 9h8v10H8z"></path>
                        <path d="M15.5 4l-1-1h-5l-1 1H5v2h14V4zM6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM8 9h8v10H8V9z"></path>
                     </svg>
                  </button>
               </div>
            </div>
            </form>
         </div>
         <div class="mt-5 bg-white shadow cursor-pointer rounded-xl mb-5">
            <div class="flex">

               <div class="flex-1 py-3 pl-1 overflow-hidden">

                  <ul>
                     <li class="text-xs text-gray-600 uppercase mb-4">Les Informations d Admin</li>
                     <li>Fullname : <%=a.getFullname() %> </li>
                     <li>email : <%=a.getEmail() %></li>
                     <li>role : Admin du centre</li>
                     <li>Cree par : supAdmin@gmail.com</li>
                  </ul>
               <%
               }
               %>

               </div>

            </div>
         </div>
      </div>
   </div>
</div>

</div>
</body>
</html>
