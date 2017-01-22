<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Welcome to DrugChecker</title>
        <meta name="description" content="Welcome on DrugChecker" />
        <meta name="keywords" content="FarAway" />
        <meta name="author" content="Ourania Tsilomitrou" />
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" href="css/bootstrap-dialog.min.css">
        <link rel="stylesheet" href="css/main.css" />
        <link rel="stylesheet" id="google_fonts-css" href="//fonts.googleapis.com/css?family=Megrim|Raleway|Open+Sans:400,400italic,700,700italic" type="text/css" media="all">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body class="flex-center-wrapper">
        <img alt="" src="static/img/medicine.jpg"/>
        <div class="navbar navbar-fixed-top  ">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a href="/DrugChecker/"><header class="brand">DrugChecker</header></a>

                    <nav class="nav-collapse ">
                        <ul class="nav">
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <div class="container">
            <hgroup>

                <% if (request.getAttribute("pageHeading") != null) { %>
                <h1 class="hero-unit">${pageHeading}</h1>
                <% }%>

            </hgroup>  

            <%
                session = request.getSession(false);
                if (session == null || session.getAttribute("username") == null) {
            %>
            <h1 class="hero-unit">Welcome to DrugChecker</h1>

            <div class="form-container" >

                <div class="center">                                                      
                    
                    <form method="get" action="/DrugChecker/login.jsp">
                        <button type="submit" class="btn btn-primary" value="Login">Login</button>
                    </form>
                    
                    <form method="get" action="/DrugChecker/register.jsp">
                        <button type="submit" class="btn btn-primary" value="Register">Register</button>
                    </form>
                    
                </div>
                

            </div>


            <%
                } else {

                    String redirectURL = "result1.jsp";
                    response.sendRedirect(redirectURL);
                }
            %>
            <jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>