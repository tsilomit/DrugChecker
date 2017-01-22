<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>


    <h1 class="hero-unit">DrugChecker</h1>
    
    <form method="POST" class="navbar-form navbar-left" role="search" action="Search">
        <div class="form-group">
          <input type="text" name="drug" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    
    

<jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>