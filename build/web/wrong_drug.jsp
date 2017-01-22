<%@ page import="java.util.*" %>

<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>

            <h1 class="hero-unit">Something going wrong..</h1>
            

            <div class="form-container" >

                <div class="center">
                 
                    <h3>Oh snap! This drug does not exist.. Try again.</h3>
                    <br><br>                    
                    <form method="get" action="/DrugChecker/result1.jsp">
                        <button type="submit" class="btn btn-primary" value="Return">Return</button>
                    </form>

                </div>
                

            </div>

            <jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>