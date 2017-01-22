<%@ page import="java.util.*" %>

<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>

            <h1 class="hero-unit">Results</h1>
            
            <h3>
            <%
            String styles2 = request.getSession().getAttribute("styles2").toString(); 
            out.print(styles2);
            %>
            </h3>
            <br><br>
            <div class="form-container" >

                <div class="center">                                                      
                    
                    <form action='AddDrug' method="POST">
                        <button type="submit" class="btn btn-primary" value="Add">Add</button>
                        <input type="hidden" name="d_name" readonly value="${d_name}"> 
                        <input type="hidden" name="d_id" readonly value="${d_id}"> 
                    </form>
                    
                    <form method="get" action="/DrugChecker/result1.jsp">
                        <button type="submit" class="btn btn-primary" value="Cancel">Cancel</button>
                    </form>

                </div>
                

            </div>

            <jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>