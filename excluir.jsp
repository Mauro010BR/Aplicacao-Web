<%-- 
    Document   : excluir
    Created on : 26 de mai. de 2023, 23:56:16
    Author     : mauro
--%>

<%@page import="model.pedido"%>
<%@page import="dao.dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    pedido p = new pedido();
    p.setId(id);
    dao d = new dao();
    d.deletar(p);
    request.getRequestDispatcher("consulta.jsp").forward(request, response);
%>