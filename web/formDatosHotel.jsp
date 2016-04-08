<%-- 
    Document   : formDatosHotel
    Created on : 5/04/2016, 04:49:06 PM
    Author     : edinson
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="diseno/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="diseno/css/bootstrap.min.css">
        <script src="diseno/js/bootstrap.min.js"></script>
        <script src="diseno/js/jquery-1.12.0.min.js"></script>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Registrar Hotel</h3>         
                    </div>
                    <div class="panel-body">
                        <form action="DatosHotel.jsp" method="post">
                            <div class="col-lg-6 col-lg-offset-3">
                                <label>Nombre Hotel</label>
                                <input class="form-control" name="nomProd" maxlength="50"
                                       placeholder="Escriba el nombre del hotel"
                                       type="text">
                                <br>
                                <label>Slogan</label>
                                <input class="form-control" name="cantidad" type="text" max="50"
                                       placeholder="Cantidad de elementos del producto">
                                <br>
                                
                                <div class="text-center">
                                    <button class="btn btn-default" type="submit">Registrar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="panel-footer">
                        <% 
                            if(session.getAttribute("mensaje") == null){
                                session.setAttribute("mensaje", "");
                                out.println(session.getAttribute("mensaje").toString());
                            }
                            else{
                                out.println(session.getAttribute("mensaje").toString());
                                session.setAttribute("mensaje", "");
                            }
                        %>
        </div>
    </body>
</html>
