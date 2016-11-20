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
        <jsp:include page="/WEB-INF/jsp/menus/top.inc.jsp"></jsp:include>
            <div class="container-fluid">
                <hgroup>

                <% if (request.getAttribute("pageHeading") != null) { %>
                <h1 class="hero-unit">${pageHeading}</h1>
                <% }%>

            </hgroup>  