
<%-- 
    Document   : newjsp
    Created on : 03/11/2018, 19:20:52
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos/restom.css"/>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        <title>JSP Page</title>
        <style>
              *{
            font-family: 'Ubuntu', sans-serif;
        }
            input[type="text"]{
                width: 100%;
                height:30px;
            }
            input[type="submit"],  input[type="button"]{
                height: 30px;
                width: 100%;
                background-color: lightgreen;
            }
            label{
                padding-left: 5px;
            }
            form{
                background-image: linear-gradient(wheat, white);

            }

        </style>
        <script src="JS/funcoes.js"></script>
    </head>
    <body>
        <div align="center">
            <h1>Cadastrar Contato</h1>
            <div class="tamanho">
                <table border="1" width="1000px">
                    <form name="form1" id="form1" accept-charset="UTF-8" action='Control1' method="POST">
                        <tr>
                            <td>
                                <label >Nome: </label>
                            </td>
                            <td>            
                                <input type="text" name="nome" id="nome" />
                            </td>
                        </tr>


                        <tr>
                            <td>               
                                <label>Telefone </label>
                            </td>

                            <td>               
                                <input type="text" name="telefone" id="telefone" placeholder="São aceitos somente números"/>
                            </td>
                        </tr>

                        <tr>
                            <td>    
                                <input type="button" value="Cadastrar" onclick="validaForm()"/>
                    </form>
                    </td>
                    <td>

                        <form action="index.html">
                            <input type="submit" value="Voltar" />
                        </form>
                    </td>
                    </tr>
                </table>








            </div>
        </div>



    </body>
</html>
