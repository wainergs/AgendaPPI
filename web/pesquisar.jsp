<%-- 
    Document   : pesquisar
    Created on : 07/11/2018, 19:29:04
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.contatos"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">

        <title>JSP Page</title>
        <style>
            *{
                font-family: 'Ubuntu', sans-serif;
            }
            table{
                margin: 0 auto;
                border-spacing: 5px;
                border-radius: 5%;
                padding: 5px;
                width: 800px;

            }
            tr, td,th{
                padding: 10px;
                box-shadow: 1px 3px lightgreen;

            }
            td{
                width: auto;
            }
            input[type="submit"],input[type="button"]{
                height: 30px;
                width: 100%;
                background-color: lightgreen;
            }
            input[type="text"]{
                width: 100%;
                box-shadow: 3px 1px lightgreen;

            }


        </style>
        <script src="JS/funcoes.js"></script>
    </head>

    <body>
        <h1 align="center">Pesquisar Contato</h1>
        <form action="Pesquisar" name="formPesquisa" id="formPesquisa">

            <table border="1px solid black">
                <tr>
                    <td>
                        <input type="text" name="pesquisar" method="POST" id="txtPesquisar">

                    </td>
                    <td>
                        <input type="button" value="Pesquisar" onclick="validaPesquisar()" />

                    </td>
                    </form>

                    <td>
                        <form action="index.html">
                            <input type="submit" value="Voltar" />

                        </form>

                    </td>

                </tr>
            </table>

            <h2 align="center">Contatos Encontrados</h2>

            <table>


                <%
                    List<contatos> result = (List<contatos>) request.getAttribute("resp");
                    String pesquisar = (String) request.getAttribute("pesquisar");

                    if (result != null && pesquisar != null) {
                        for (contatos c : result) {

                            if (c.getNome().contains(pesquisar)) {
                                out.print("<tr>");

                                out.print("<td>" + c.getId() + "</td>");
                                out.print("<td>" + c.getNome() + "</td>");
                                out.print("<td>" + c.getTelefone() + "</td>");
                                out.print("</tr>");

                            }
                        }
                     
                    }
                       else{
                        out.print("<div align='center'>"+"Nenhum contato encontrado"+"</div>");

                    }
                %> 




            </table>

    </body>
</html>
