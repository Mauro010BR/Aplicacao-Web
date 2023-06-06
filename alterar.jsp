<%-- 
    Document   : alterar
    Created on : 31 de mai. de 2023, 23:54:42
    Author     : mauro
--%>

<%@page import="model.pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            .back {
                max-width: 1500px;
                width: 100%;
                height: 900px;
                font-family: Arial, Helvetica, sans-serif;
                background: rgb(105,104,104);
                background: linear-gradient(90deg, rgba(105,104,104,1) 0%, rgba(164,164,164,1) 50%, rgba(65,65,65,1) 100%);
            }
            h1,h2 {
                text-align: center;
            }

            .form {
                text-align: center;
                background-color: rgba(0, 0, 0, 0.9);
                position: absolute;
                top: 67%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 22px;
                border-radius: 15px;
                color: #fff;
            }

            .botao {
                background-color: dodgerblue;
                border: none;
                padding: 15px;
                width: 100%;
                border-radius: 10px;
                color: white;
                font-size: 15px;
            }

            .botao:hover {
                background-color: deepskyblue;
                cursor: pointer;
            }

            select {
                border-radius: 15px 15px 15px 15px;
            }

            .sobre {
                position: absolute;
                top: 110%;
            }

            .h3 {
                position: absolute;
                top: 120%;
            }
            input{
                border-radius: 15px 15px 15px 15px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%
            pedido p = (pedido) request.getAttribute("pe");
        %>

        <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="http://localhost:8080/CrudWeb/index.html">
                    <img src="Imagens/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                    BMO Informática
                </a>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link active" aria-current="page" href="http://localhost:8080/CrudWeb/index.html">Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="http://localhost:8080/CrudWeb/cadastro_pedido?submit=ConsultarTodos">Pedidos</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link active" aria-current="page" href="http://localhost:8080/CrudWeb/Galeria.html">Galeria</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="back">
            <div class="form">
                <h1>Editar Pedido</h1>
                <br>
                <form action="cadastro_pedido" method="GET">
                    <input type="hidden" name="id" id="id" value="<% out.print(p.getId()); %>">
                    <label for="nome">Nome: </label>
                    <input type="text" id="nome" name="nome" value="<% out.print(p.getNome()); %>"placeholder="Digite seu Nome">
                    <br>
                    <hr>
                    <label for="processador">Processador: </label>
                    <select name="processador" id="processador">
                        <option disabled option value="">Selecione o Processador</option>
                        <option value="<% out.print(p.getProcessador()); %>"><% out.print(p.getProcessador()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="i9">I9</option>
                        <option value="i7">I7</option>
                        <option value="ryzen7">AMD Ryzen 7</option>
                        <option value="ryzen5">AMD Ryzen 5</option>
                    </select>
                    <br>
                    <hr>
                    <label for="pvideo">Placa de Vídeo: </label>
                    <select name="pvideo" id="pvideo">
                        <option disabled option value="">Selecione a Placa de Vídeo</option>
                        <option value="<% out.print(p.getPlacavideo()); %>"><% out.print(p.getPlacavideo()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="rtx3090">RTX 3090</option>
                        <option value="rtx2060 ">RTX 2060 </option>
                        <option value="gtx1650">gtx 1650</option>
                        <option value="gtx1050">gtx 1050 ti</option>
                    </select>
                    <br>
                    <hr>
                    <label for="pmae">Placa Mãe: </label>
                    <select name="pmae" id="pmae">
                        <option disabled option value="">Selecione a Placa Mãe</option>
                        <option value="<% out.print(p.getPlacamae()); %>"><% out.print(p.getPlacamae()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="AsRock B450M Steel Legend">AsRock B450M Steel Legend</option>
                        <option value="Gigabyte B450 AORUS M">Gigabyte B450 AORUS M</option>
                    </select>
                    <br>
                    <hr>
                    <label for="ram">Memória RAM: </label>
                    <select name="ram" id="ram">
                        <option disabled option value="">Selecione a Memória RAM: </option>
                        <option value="<% out.print(p.getRam()); %>"><% out.print(p.getRam()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="ram8">Memória RAM DDR4 HyperX Fury 8 GB</option>
                        <option value="ram4">Memória RAM DDR4 HyperX Fury 4 GB</option>
                    </select>
                    <br>
                    <hr>
                    <label for="cooler">Cooler: </label>
                    <select name="cooler" id="cooler">
                        <option disabled option value="">Selecione o Cooler</option>
                        <option value="<% out.print(p.getCooler()); %>"><% out.print(p.getCooler()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="Cooler Hydro Series H60 Corsair">Cooler Hydro Series H60 Corsair</option>
                    </select>
                    <br>
                    <hr>
                    <label for="hd">HD: </label>
                    <select name="hd" id="hd">
                        <option disabled option value="">Selecione o HD</option>
                        <option value="<% out.print(p.getHd()); %>"><% out.print(p.getHd()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="Seagate Barracuda ST1000DM010">Seagate Barracuda ST1000DM010</option>
                    </select>
                    <br>
                    <hr>
                    <label for="ssd">SSD: </label>
                    <select name="ssd" id="ssd">
                        <option disabled option value="">Selecione o SSD</option>
                        <option value="<% out.print(p.getSsd()); %>"><% out.print(p.getSsd()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="SSD Samsung 970 EVO 500GB">SSD Samsung 970 EVO 500GB</option>
                    </select>
                    <br>
                    <hr>
                    <label for="gabinete">Gabinete: </label>
                    <select name="gabinete" id="gabinete">
                        <option disabled option value="">Selecione o Gabinete</option>
                        <option value="<% out.print(p.getGabinete()); %>"><% out.print(p.getGabinete()); %> </option>
                        <option value="nenhum">Nenhum</option>
                        <option value="Thermaltake">Thermaltake</option>
                        <option value="Cooler Master">Cooler Master</option>
                    </select>
                    <br>
                    <hr>
                    <label for="estado">Estado: </label>
                    <select name="estado" id="estado">
                        <option disabled option value="">Selecione o Estado</option>
                        <option value="<% out.print(p.getEstado()); %>"><% out.print(p.getEstado());%> </option>
                        <option value="São Paulo">São Paulo</option>
                        <option value="Rio de Janeiro">Rio de Janeiro</option>
                        <option value="Minas Gerais">Minas Gerais</option>
                    </select>
                    <br>
                    <br>
                    <input class="botao" type="submit" name="submit" id="submit" value="Salvar">
                </form>
            </div>
        </div>
        <footer class="bg-dark text-center text-lg-start">
            <!-- Copyright -->
            <div class="text-center p-3" style="color:white; background-color: black;">
                © 2023 Copyright: Mauro JR
            </div>
        </footer>
    </body>
</html>
