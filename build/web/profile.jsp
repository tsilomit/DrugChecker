<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.example.web.DB_interaction.*"%>

<%
    String title = "Profile Information";
    request.setAttribute("pageTitle", title);
    request.setAttribute("pageHeading", title);
%>
<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>

    <div class="center">
        <table class="table">


        </table>

        <script   type="text/javascript">
            $(document).ready(function () {
                //image gallery setup    
                $(function () {
                    'use strict';
                    $('#blueimp-gallery').data('useBootstrapModal', false);
                    $('#blueimp-gallery').toggleClass('blueimp-gallery-controls', true);
                });
            });


            $(function () {

                var click = false;

                $("#accordion").accordion({
                    heightStyle: "fill", collapsible: true, active: false
                });


                $("#statsToggle").click(function () {
                    if (click === true) {
                        $("#stats").animate({left: '-=15vw'}, 1000);
                        $("#accordion").accordion({
                            active: false
                        });
                        $("#statsToggle img").attr("src", "images/favicon_toggle.png");
                        click = false;
                    }
                    else {
                        $("#stats").animate({left: '+=15vw'}, 1000);

                        $("#statsToggle img").attr("src", "images/favicon2.png");
                        click = true;
                    }
                });

                $("#statsToggle img").mouseover(function () {
                    $(this).stop().animate({"border-color": '1px solid #337ab7'}, 'fast');
                });
                $("#statsToggle img").mouseout(function () {
                    $(this).stop().animate({"border-color": '1px solid #ccc'}, 'fast');
                });

                $(".ui-accordion-header").mouseover(function () {
                    $(this).stop().animate({"border-color": '1px solid #337ab7'}, 'fast');
                });

                $(".ui-accordion-header").mouseout(function () {
                    $(this).stop().animate({"border-color": '1px solid #ccc'}, 'fast');
                });




            });
            $(function () {
                $("#accordion-resizer").resizable({
                    height: '100%',
                    minWidth: 500,
                    resize: function () {
                        $("#accordion").accordion("refresh");
                    }
                });

            });


        </script>
        <div id="accordion-resizer" class="ui-widget-content">

            <div id="accordion">
                <h3>Personal Information</h3>
                <div >
                <%  String username = request.getSession().getAttribute("username").toString();
                    Map m = com.example.web.DB_interaction.selectAll(username);
                    out.println("<span><strong>Name :</strong> " + m.get("name") + "</span></br>");
                    out.println("<span><strong>Surname: </strong>" + m.get("surname") + "</span></br>");
                    out.println("<span><strong>Email:</strong> " + m.get("email") + "</span></br>");
                    out.println("<span><strong>Department:</strong> " + m.get("department") + "</span></br>");
                    out.println("<span><strong>Affiliation:</strong> " + m.get("affiliation") + "</span></br>");
                %>
            </div>
                  
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>