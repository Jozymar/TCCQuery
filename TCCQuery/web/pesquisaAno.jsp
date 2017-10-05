<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Por Ano</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div id="divContPes">
                <div class="row">
                    <div class=" col-md-12 text-center">
                        <h1>Pesquisar Por Ano</h1>
                    </div>
                </div>
                <div id="divPesLocal">
                    <form action="pesquisaAno.jsp" method="post" name="pesquisarAno">   
                        <div class="input-group input-group">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                            <input type="text" name="nome" class="form-control" placeholder="Buscar Por Ano" aria-describedby="basic-addon1" required>
                            <div class="input-group-btn">
                                <input type="hidden" name="identificador" value="PesquisarAno"> 
                                <button class="btn btn-primary btn-md btn-block" role="button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="form-group">
                    <div class="col-md-12 text-center" id="divResultado">
                        <h4>Não encontramos nenhum tcc para este ano :(</h4>
                    </div>
                </div>
                <form action="perfilLocal.jsp" method="post" name="perfilLocal">
                    <div class="form-group">
                        <div id="divResultado">
                            <div id="divPes" class="form-group pull-left">
                                <h3>Título:</h3>
                                <h5 id="hDados">Autor: </h5>
                                <h5 id="hDados">Ano: </h5>
                                <h5 id="hDados">Resumo: </h5>
                            </div>
                            <div id="divPesbt" class="form-group">
                                <input name="email" type="hidden" value="${tag}">
                                <input name="nome" type="hidden" value="${tag}">
                                <input type="submit" class="btn btn-primary btn-md btn-block" id="btPes" role="button" value="Visualizar Pdf"> 
                            </div>
                        </div>  
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
