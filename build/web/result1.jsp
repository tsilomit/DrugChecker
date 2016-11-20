<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>

<%
//    String username = (String) request.getAttribute("username");
//    out.print("<title>DrugChecker ></title>" + " User:" + username + "\n");

%>

<!--<form method = "post" action = "logout">
    <input type = "submit" value = "Logout"/>
</form>-->


    <h1 class="hero-unit">DrugChecker</h1>
    <form method="POST" action="SelectRestaurant.do">
        Select Restaurant 
        Type:
        <select name="type" size="1">
            <option value="Fast Food">Fast Food</option>
            <option value="Ethnic">Ethnic</option>
            <option value="Traditional">Traditional</option>
            <option value="Family Restaurant">Family Restaurant</option>
        </select>
        <br><br>
        <center>
            <input type="Submit">
        </center>
    </form>

    <jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>