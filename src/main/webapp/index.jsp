<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Admin Page</title>
    <%@include file="helpers/links.jsp" %>
</head>
<body class>
        <div class="lg:flex">
            <div class="lg:w-3/6">
                <div class="py-12 bg-blue-100 lg:bg-white flex justify-center lg:justify-start lg:px-12">
                    <div class="cursor-pointer flex items-center">
                        <div>
                            <img src="helpers/marjane_logo.png" class="w-1/4 transform duration-200 hover:scale-110 cursor-pointer" />
                        </div>

                    </div>
                </div>
                <div class="mt-10 px-12 sm:px-24 md:px-48 lg:px-12 lg:mt-16 xl:px-24 xl:max-w-2xl">
                    <h2 class="text-center text-4xl text-blue-900 font-display font-semibold lg:text-left xl:text-5xl
                    xl:text-bold">Log in</h2>
                    <div class="mt-12">
                        <form action="LoginServlet" method="post">
                           <div>
                                <select id="role" name="role" class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-blue-700">
                                      <option value="">Log in as :</option>
                                      <option value="1">Admin General</option>
                                      <option value="2">Admin Center</option>
                                      <option value="3">Chef du Rayon</option>
                                </select>
                           </div>
                            <div class="mt-8">
                                <input autocomplete="off" class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-blue-700" type="text" name="email" placeholder="mike@gmail.com">
                            </div>
                            <div class="mt-8">
                                <div class="flex justify-between items-center">

                                    <div>

                                    </div>
                                </div>
                                <input class="w-full text-lg py-2 border-b border-gray-300 focus:outline-none focus:border-blue-700" name="password" type="password" placeholder="Enter your password">
                            </div>
                            <div class="mt-10">
                                <button type="submit" class="bg-blue-700 text-gray-100 p-4 w-full tracking-wide font-semibold font-display focus:outline-none focus:shadow-outline hover:bg-blue-600 shadow-lg">
                                    Login
                                </button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
            <div class="hidden lg:flex items-center justify-center flex-1  lg:float-right ">
            <img src="helpers/Marjane-login.jpg" class="h-screen " />
            </div>
        </div>
      </div>
    </body>
</html>
