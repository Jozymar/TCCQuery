<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Tcc</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <div class="col-sm-4 col-sm-push-4 sidenav text-center" id="divMenuPes">
                    <a name="buscarAno" href="buscaTccPorAno.jsp" class="btn btn-primary btn-md btn-block" role="button">
                        <span class="glyphicon glyphicon-search"></span> Buscar Por Ano
                    </a>
                    <a name="buscarConteudo" href="buscaTccPorConteudo.jsp" class="btn btn-primary btn-md btn-block" role="button">
                        <span class="glyphicon glyphicon-search"></span> Buscar Por Conteúdo
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>