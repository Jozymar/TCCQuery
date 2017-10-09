<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Erros</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse" id="navBarNav">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" id="linkMenu"><span class="glyphicon glyphicon-exclamation-sign"></span> TCCQuery</a>
                </div>
            </div>
        </nav>

        <div class="container" id="divLog">
            <center>
                <img class="img-thumbnail" src="imagens\erro.png" alt="Erro" id="imgErro">

                <div class="alert alert-danger" role="alert" id="divErro">
                    <h4>Ocorreu um erro :(</h4>
                    <h6>Você precisa estar logado no sistema para acessar essa página</h6>

                    <a href="index.jsp" class="alert-link">Realize o login no TCCQuery</a>
                </div>
            </center>
        </div>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

    </body>
</html>
