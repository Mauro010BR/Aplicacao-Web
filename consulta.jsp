<%@page import="java.util.ArrayList"%>
<%@page import="dao.dao"%>
<%@page import="java.util.List"%>
<%@page import="model.pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
        <style>
            .back {
                max-width: 1500px;
                width: 100%;
                height: 689px;
                background: rgb(105,104,104);
                background: linear-gradient(90deg, rgba(105,104,104,1) 0%, rgba(164,164,164,1) 50%, rgba(65,65,65,1) 100%);
            }
        </style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%
            List<pedido> lprod = (List<pedido>) request.getAttribute("lprod");
        %>
        <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
            <a class="navbar-brand" href="http://localhost:8080/CrudWeb/index.html">
                <img src="Imagens/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                BMO Informática
            </a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link active" aria-current="page" href="http://localhost:8080/CrudWeb/index.html">Cadastro</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link active" aria-current="page" href="http://localhost:8080/CrudWeb/cadastro_pedido?submit=ConsultarTodos">Pedidos</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link active" aria-current="page" href="http://localhost:8080/CrudWeb/Galeria.html">Galeria</a>
                    </li>
                </ul>
                <form action="cadastro_pedido" method="GET" class="form-inline my-2 my-lg-0">
                    <input name="id" id="id" class="form-control mr-sm-2" type="search" placeholder="Insira o ID">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="submit" id="submit" value="BuscarId">Buscar</button>
                </form>
            </div>
        </nav>
        <div class="back">
            <h1 style=text-align:center;>PEDIDOS</h1>
            <br>
            <table class="table table-dark">
                <tr>
                    <th>Pedido</th>
                    <th>Nome</th>
                    <th>Processador</th>
                    <th>Placa de Video</th>
                    <th>Placa mãe</th>
                    <th>RAM</th>
                    <th>Cooler</th>
                    <th>HD</th>
                    <th>SSD</th>
                    <th>Gabinete</th>
                    <th>Estado</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>

                <%for (pedido p : lprod) {%>
                <tr>                
                    <td><%out.print(p.getId());%></td>
                    <td><%out.print(p.getNome());%></td>  
                    <td><%out.print(p.getProcessador());%></td>  
                    <td><%out.print(p.getPlacavideo());%></td>  
                    <td><%out.print(p.getPlacamae());%></td>  
                    <td><%out.print(p.getRam());%></td>  
                    <td><%out.print(p.getCooler());%></td>  
                    <td><%out.print(p.getHd());%></td>  
                    <td><%out.print(p.getSsd());%></td>  
                    <td><%out.print(p.getGabinete());%></td>  
                    <td><%out.print(p.getEstado());%></td>  
                    <td><a href="http://localhost:8080/CrudWeb/cadastro_pedido?submit=Editar&id=<%out.print(p.getId());%>"><img src="Imagens/Edit.png" height="40px" width="40px"></td>
                            <td><a href="http://localhost:8080/CrudWeb/cadastro_pedido?submit=Deletar&id=<%out.print(p.getId());%>"><img src="Imagens/Lixeira.png" height="40px" width="40px"></a></td>
                </tr>
                <%}%>

            </table>
        </div>
        <footer class="bg-dark text-center text-lg-start">
            <!-- Copyright -->
            <div class="text-center p-3" style="color:white; background-color: black;">
                © 2023 Copyright: Mauro JR
            </div>
        </footer>
    </body>
</html>
