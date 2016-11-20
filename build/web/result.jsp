<%@ page import="java.util.*" %>

<html>

<head>
<title>Restaurant Recommendation JSP View></title>
<link href="firstcss.css" type="text/css"
rel="stylesheet" />

<form method = "post" action = "logout">
    <input type = "submit" value = "Logout"/>
</form>
</head>

<body>
<h1 align="center">Restaurant Recommendation JSP View</h1>
<p>

<%
  List styles = (List) request.getAttribute("styles");
  Iterator it = styles.iterator();
  while(it.hasNext()) {
    out.print("<br>try: " + it.next());
  }
%>

</body>
</html>

<head>
<title>Restaurant Advisor></title>
<link href="firstcss.css" type="text/css"
rel="stylesheet" />
</head>