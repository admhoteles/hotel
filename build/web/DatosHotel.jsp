<%-- 
    Document   : DatosHotel
    Created on : 5/04/2016, 04:44:39 PM
    Author     : edinson
--%>

<jsp:useBean id="facade" class="Mundo.facade" scope="session"></jsp:useBean>>
<jsp:useBean id="prod" class="dto.hotel" scope="session"></jsp:useBean>>
<%
    String nombre = request.getParameter("nomProd");
    String slogan = request.getParameter("slogan");
    
    
    prod.setNombre(nombre);
    prod.setslogan(slogan);
    
    System.out.println(prod.toString());
    String msg = facade.agregar(prod);
    
    System.out.println(msg);
    session.setAttribute("mensaje", msg);
    
    response.sendRedirect("formDatosHotel.jsp");
%>
