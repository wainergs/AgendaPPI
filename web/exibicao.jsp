<%-- 
    Document   : exibicao
    Created on : 03/11/2018, 18:19:44
    Author     : eduardo
--%>

<%@page import="Model.contatos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">

        <title>Contatos</title>
        <style>
              *{
            font-family: 'Ubuntu', sans-serif;
        }
            table{
                margin: 0 auto;
                border-spacing: 5px;
                border-radius: 5%;
                padding: 5px;

            }
            tr, td,th{
                padding: 10px;
                box-shadow: 3px 3px lightgreen;
                    
            }
            td{
                width: auto;
            }
            input[type="submit"]{
                height: 30px;
                width: 100%;
                background-color: lightgreen;
            }
      

        </style>
    </head>
    <body>
        <div align="center">
            <h1>Contatos Cadastrados</h1>    

        </div>
        <table border="1px solid black">
            <tr>
            <tr>
                <th>
                    Cod: 
                </th>
                <th>
                    Nome:
                </th>               
                <th>
                    Telefone:
                </th>
            </tr>


            <%
                List<contatos> result = (List<contatos>) request.getAttribute("resp");

                for (contatos c : result) {
                    out.print("<tr>");
                    out.print("<td>" + c.getId() + "</td>");
                    out.print("<td>" + c.getNome() + "</td>");
                    out.print("<td>" + c.getTelefone() + "</td>");
                    out.print("</tr>");

                }
            %> 
            <tr>
                <td style="border: 0px"></td>
                <td style="border: 0px"></td>

                <td>
                    <form action="index.html">
                        <input type="submit" value="Voltar"   />

                    </form>
                </td>

            </tr>
        </table>
    </body>
</html>
