<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca TCC</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div id="divContPes">
                <div class="row">
                    <div class=" col-md-12 text-center">
                        <h1>Busca TCC</h1>
                    </div>
                </div>
                <div id="divPesLocal">
                    <form action="FrontControl" method="post" >   
                        <div class="input-group input-group">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-text-size"></i></span>
                            <input type="text" name="query" class="form-control" placeholder="Busque por Título, Autor, Ano, Orientador, Área ou Conteúdo" aria-describedby="basic-addon1" required>
                            <div class="input-group-btn">
                                <input type="hidden" name="identificador" value="PesquisaTcc"> 
                                <button class="btn btn-primary btn-md btn-block" role="button" name="buscarTcc" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>

                <c:choose>
                    <c:when test="${not empty tccs}">
                        <c:forEach var="tccs" items="${tccs}" >
                            <form action="viewTcc.jsp" method="post">
                                
                                    <div id="divResultado">
                                        <div id="divPes" class="form-group pull-left">
                                            <h3>Título: ${tccs.titulo}</h3>
                                            <h5 id="hDados">Autor: ${tccs.autor}</h5>
                                            <h5 id="hDados">Ano: ${tccs.ano}</h5>
                                            <h5 id="hDados">Resumo:${fn:substring(tccs.resumo, 0, 90)}...</h5>
                                        </div>
                                        <div id="divPesbt" class="form-group pull-right">
                                            <input type="hidden" name="id" value="${tccs.id}">
                                            <button type="submit" class="btn btn-default btn-md" id="btPesPdf" role="button" value="Vizualizar PDF"><img src="imagens/pdf.png" alt="FotoPdf" class="img-responsive"></button>
                                        </div>
                                    </div>  
                               
                            </form>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${empty not param.buscarTcc}">
                            <div class="form-group">
                                <div class="col-md-12 text-center" id="divResultado">
                                    <h4>Não encontramos nenhum tcc para este autor :(</h4>
                                </div>
                            </div>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
