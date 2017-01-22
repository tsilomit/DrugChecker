<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.example.web.DB_interaction.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%
    String title = "Profile Information";
    request.setAttribute("pageTitle", title);
    request.setAttribute("pageHeading", title);
%>
<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>
    
<sql:setDataSource var="ds" dataSource="jdbc/drugchecker" />

<sql:query dataSource="${ds}" sql="select * from drugs" var="results" />

    <div class="center">
        <table class="table">


        </table>


        <div id="accordion-resizer" class="ui-widget-content">

            <div id="accordion">
                <h2>Personal Information</h2>
                <div >
                <%  String username = request.getSession().getAttribute("username").toString();
                    Map m = com.example.web.DB_interaction.selectAll(username);
                    out.println("<h2>Name :</strong> " + m.get("name") + "</h2></br>");
                    out.println("<h2>Surname: </strong>" + m.get("surname") + "</h2></br>");
                    out.println("<h2>Email:</strong> " + m.get("email") + "</h2></br>");
                %>
                <h3>Your drug list:</h3>
                <ul>
                <c:forEach var="user" items="${results.rows}" varStatus="row">
                    <c:if test="${user.user_id.equals(username)}">       
                        <li class="list-group-item"><h2>${user.name}</h2></li>
                    </c:if>
                </c:forEach>    
              </ul>
                
            </div>
            
                  
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>