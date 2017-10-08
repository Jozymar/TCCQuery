<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Por Autor</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div id="divContPes">
                <ct:buscaTCC id="${param.id}" />
                <div>
                    <iframe name="interno" width="800" height="700" src="${tcc.path}" style="border: none"></iframe>
                </div>
            </div>
        </div>
    </body>
</html>
