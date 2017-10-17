<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Cadastro Tcc</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body onload="selecionar('${sessionScope.tcc.area}')">
        <div class="container" id="divCad">

            <div class="row">
                <div class="col-md-12 text-center">
                    <h1>Cadastro Tcc</h1>
                    <h5 id="hErro">${sessionScope.erro}</h5>
                </div>
            </div>
            <form action="FrontControl" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-text-size"></i></span>
                        <input type="text" name="titulo" value="${sessionScope.tcc.titulo}" class="form-control" placeholder="Título" aria-describedby="basic-addon1" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="autor" value="${sessionScope.tcc.autor}" class="form-control" placeholder="Autor" aria-describedby="basic-addon1" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="orientador" value="${sessionScope.tcc.orientador}" class="form-control" placeholder="Orientador" aria-describedby="basic-addon1" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-rub"></i></span>
                        <input type="text" name="palavrasChave" value="${sessionScope.tcc.palavrasChave}" class="form-control" placeholder="Palavras-Chave" aria-describedby="basic-addon1" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-list-alt"></i></span>
                        <textarea type="text" name="resumo" class="form-control" placeholder="Resumo" aria-describedby="basic-addon1" required>${sessionScope.tcc.resumo}</textarea>
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                        <input type="text" name="ano" value="${sessionScope.tcc.ano}" class="form-control" placeholder="Ano" aria-describedby="basic-addon1" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group input-group"> 
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-text-background"></i></span>
                        <select class="form-control" name="area" id="area" data-toggle="tooltip" title="Informe a área" required>
                            <option readonly>Banco de Dados</option>
                            <option>Engenharia de Software</option>
                            <option>Redes</option>
                            <option>Segurança</option>
                            <option>Arquitetura de Sistemas</option>
                            <option>Hardware</option>
                            <option>Desenvolvimento de Sistemas</option>
                        </select>
                    </div>
                </div>  

                <script type="text/javascript">
                    function selecionar(uf) {
                        var area = document.getElementById("area");

                        for (var i = 0; i < area.options.length; i++) {
                            if (area.options[i].value == uf) {
                                area.options[i].selected = "true";
                                break;
                            }
                        }
                    }
                </script>

                <div class="input-group input-group"> 
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-file"></i></span>
                    <input data-toggle="tooltip" name="pdf" title="Carregue aqui o pdf do texto" type="file" class="form-control" aria-describedby="basic-addon1" required>
                </div>

                <div class="form-group" id="divBtLogin">
                    <input type="hidden" name="identificador" value="CadastroTcc"> 
                    <input type="submit" name="cadastrar" class="btn btn-secundary btn-md btn-block" role="button" value="Cadastrar">
                </div>
            </form>
        </div>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

    </body>
</html>