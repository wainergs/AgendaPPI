<%-- 
    Document   : excluir
    Created on : 08/11/2018, 10:19:26
    Author     : eduardo
--%>

<%@page import="Model.contatos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
              *{
            font-family: 'Ubuntu', sans-serif;
        }
        form{
            margin: 0 auto;
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
            .botaoExcluir{
                 height: 30px;
                width: 15% !important;
                background-color: lightgreen;
            }
            input[type="submit"],input[type="button"]{
                height: 25px;
                width: 100%;
                background-color: lightgreen;
            }
            input[type="text"]{
                width: 25%;
                                height: 17px;

                                box-shadow: 3px 3px lightgreen;

            }
      

        </style>
        <script>
            function mostraBox(){
                document.getElementById('caixaExcluir').style.display = "block";
            }
        </script>
    </head>
    <body>
        <div align="center">
            <h1>Lista de Contatos</h1>
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
                <td colspan="2">
                    <form>                                             
                        <input type="button" name="" value="Quero excluir"  onclick="mostraBox()"/>
                    </form>

                </td>

                <td>
                    <form action="index.html">
                        <input type="submit" value="Voltar"   />

                    </form>
                </td>

            </tr>
        </table>
            <div id="caixaExcluir" style="display: none" align="center">
                <h2>Digite qual contato deseja excluir </h2>
                <form>
                    <input type="text" name="contatoExcluir" method="POST">
                    <input type="submit" value="Excluir" class="botaoExcluir">
                </form>
                
            </div>
    </body>
</html>
