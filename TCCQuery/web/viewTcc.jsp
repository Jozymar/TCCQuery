<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pdf TCC</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <div class="col-sm-8 sidenav">
                    <ct:buscaTCC id="${param.id}" />
                    <div>
                        <iframe name="interno"  id="iframeTcc" src="${tcc.path}"></iframe>
                    </div>
                </div>
                    <div class="col-sm-3 sidenav pull-right" id="divDadosPdf">
                    <div class="panel panel-primary">
                        <div class="panel-heading text-center">Dados TCC</div>
                        <div class="panel-body text-center">Titulo: ${tcc.titulo}</div>
                        <div class="panel-body text-center">Autor: ${tcc.autor}</div>
                        <div class="panel-body text-center">Ano: ${tcc.ano}</div>
                        <div class="panel-body text-center" id="divResumoPdf">Resumo: ${tcc.resumo}</div>
                    </div>
                </div>  
                <div class="col-sm-3 sidenav pull-right" id="divDadosPdf">
                    <div class="panel panel-primary">
                        <div class="panel-heading text-center">Sugestões</div>
                        <div class="panel-body text-center"><a name="sugestao" href="#" class="btn-link" role="button">Nome da Sugestão</a></div>
                        <div class="panel-body text-center"><a name="sugestao" href="#" class="btn-link" role="button">Nome da Sugestão</a></div>
                    </div>
                </div>

                <div class="col-sm-3 sidenav pull-right" id="divDadosPdf">
                    <div class="panel panel-primary">
                        <div class="panel-heading text-center">Nenhuma Sugestão Encontrada :(</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
