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
//                        Cookie[] cookies = request.getCookies();
//
//                        if (cookies != null) {
//                            for (Cookie cookie : cookies) {
//                                System.out.println("cookies??? " + cookie.getName());
//                                if (cookie.getName().equals("user")) {
//                                    username = cookie.getValue();
//                                }
//                            }
//                        }
//                        System.out.println("Cookie username: " + username);
//
//                        if ((username == null) || (username.equals(""))) {
//                            System.out.println("No user, header");
//                            response.sendRedirect("/");
//                        } else {
//                            out.print("<li><a href='/DrugChecker/host.jsp'>Host</a></li>");
//                            out.print("<li><a href='/DrugChecker/about.jsp'>About</a></li>");
//                            out.print("<li><a href='/DrugChecker/contact.jsp'>Contact</a></li>");
//                            out.print("<li><a href='/DrugChecker/home.jsp' ><strong>" + username + "</strong></a></li>");
//                            out.print("<li>"
//                                    + "<a id='logout' href='do.Logout'>Logout</a>"
//                                    + "</li>");
//
//                            out.print("</li>User:" + username + "</li>");
//                            out.print("</li><form method = 'post' action = 'logout'> "
//                                    + "<input type = 'submit' value = 'Logout'/>"
//                                    + " </form></li>");
//                        }
                        username = request.getSession().getAttribute("username").toString();
                        if (username != null) {
                            out.print("<li><a href='/DrugChecker/about.jsp'>About</a></li>");
                            out.print("<li>"
                                    + "<a href='/DrugChecker/profile.jsp' style='border-left:1px solid #999;margin-left:50%'>" + username + "</a>"
                                    + "</li>");
                            out.print("<li>"
                                    + "<a id='logout' href='logout' style='margin-left:50%'>Logout</a>"
                                    + "</li>");
//                            out.print("<li><form method = 'post' action = 'logout'> "
//                                    + "<input type = 'submit' value = 'Logout'/>"
//                                    + " </form><li>");
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

//                if ($('#profile').html() === "") {
//                    $("#logo").attr('href', 'login.jsp');
//                }

            </script>


        </div>
    </div>
</div>