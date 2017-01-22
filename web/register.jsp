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

            </hgroup>  

            <h1 class="hero-unit">Welcome to DrugChecker</h1>

            <div class="form-container" >

                <div class="center">                                                      
                    
<form class="form-horizontal" action='SignUp' method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="username">Username</label>
      <div class="controls">
        <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
        <p class="help-block">Username can contain any letters or numbers, without spaces</p>
      </div>
    </div>
      
        <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="firstname">Firstname</label>
      <div class="controls">
        <input type="text" id="username" name="firstname" placeholder="" class="input-xlarge">
        <p class="help-block">Firstname can contain any letters without spaces</p>
      </div>
    </div>
      
        <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="lastname">Lastname</label>
      <div class="controls">
        <input type="text" id="username" name="lastname" placeholder="" class="input-xlarge">
        <p class="help-block">Lastname can contain any letters or numbers, without spaces</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="email">E-mail</label>
      <div class="controls">
        <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your E-mail</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
        <p class="help-block">Password should be at least 4 characters</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password -->
      <label class="control-label"  for="password_confirm">Password (Confirm)</label>
      <div class="controls">
        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
        <p class="help-block">Please confirm password</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
  </fieldset>
</form>

                </div>
                

            </div>

            <jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>