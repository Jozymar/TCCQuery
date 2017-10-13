<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

                    <ct:buscaTcc id="${param.id}"/> 

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

                <c:choose>
                    <c:when test="${not empty idsTccs}">
                        <div class="col-sm-3 sidenav pull-right" id="divDadosPdf">
                            <div class="panel panel-primary">
                                <div class="panel-heading text-center">Sugestões de TCCs</div>
                                <c:forEach var="tccs" items="${idsTccs}" >
                                    <ct:buscaTcc id="${tccs}" />
                                    <div class="panel-body text-center">
                                        <form action="viewTcc.jsp" method="post">
                                            <input type="hidden" name="id" value="${tcc.id}">
                                            <button type="submit" class="btn-default" id="btPesPdf" role="button" value="Vizualizar PDF">
                                                <table id="playlistTable">                                    
                                                    <tr>
                                                        <td><img src="imagens/pdfSug.png" alt="FotoPdf" class="img-responsive pull-left">${tcc.titulo}</td>                               
                                                    </tr>                                     
                                                </table>
                                            </button>
                                        </form>
                                    </div>
                                </c:forEach>                   
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-sm-3 sidenav pull-right" id="divDadosPdf">
                            <div class="panel panel-primary">
                                <div class="panel-heading text-center">Nenhuma Sugestão Encontrada :(</div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
