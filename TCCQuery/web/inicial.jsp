<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                
                    <div class="col-sm-4 col-sm-push-4 sidenav text-center" id="divMenu">
                        <img id="fotoPerfil" src="${sessionScope.foto}" alt="FotoPerfil" class="img-circle">
                        <h3>${sessionScope.nome}</h3>
                        <h5 id="hMenu">${sessionScope.universidade} - ${sessionScope.campus}</h5>
                        <a name="cadastroTcc" href="cadastroTcc.jsp" class="btn btn-primary btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-list-alt"></span> Cadastrar TCC</a>
                        <a name="pesquisarTcc" href="pesquisaTcc.jsp" class="btn btn-primary btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-search"></span> Pesquisar</a>
                        <a name="edPerfil" href="editarPerfil.jsp" class="btn btn-primary btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-pencil"></span> Editar Perfil</a><br>
                    </div>
               
            </div>
        </div>

    </body>
</html>