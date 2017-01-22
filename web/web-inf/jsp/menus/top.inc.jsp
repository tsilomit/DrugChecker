<%@ page session="true" %>
<div class="navbar navbar-fixed-top ">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a href="/DrugChecker/result1.jsp"><header class="brand">DrugChecker</header></a>

            <nav class="nav-collapse ">
                <ul class="nav">
                    <li class="active"><a href="/DrugChecker/result1.jsp">Home</a></li> 

                    <%  String username = null;

                        username = request.getSession().getAttribute("username").toString();
                        if (username != null) {
                            out.print("<li>"
                                    + "<a href='/DrugChecker/profile.jsp' style='border-left:1px solid #999;margin-left:50%'>" + username + "</a>"
                                    + "</li>");
                            out.print("<li>"
                                    + "<a id='logout' href='logout' style='margin-left:50%'>Logout</a>"
                                    + "</li>");
                        }
                    %>
                </ul>
            </nav>
            <script type="text/javascript">

//             redirect to main site
                if (location.pathname === "/DrugChecker/do.Connect") {
                    console.log(window.location.href);
                    window.location.href = "/DrugChecker/home.jsp";
                }

           }
            </script>
        </div>
    </div>
</div>