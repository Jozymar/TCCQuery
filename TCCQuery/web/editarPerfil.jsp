<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Perfil</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body onload="selecionar('${sessionScope.sexo}')">

        <div class="container" id="divCad">  

                    <div class="row">
                        <div class=" col-md-12 text-center">
                            <h1>Editar Perfil</h1>
                        </div>
                    </div>
                    <form action="FrontControl" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" name="nome" value="${sessionScope.nome}" class="form-control" placeholder="Nome" aria-describedby="basic-addon1">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-home"></i></span>
                                <input type="text" name="cidade" value="${sessionScope.cidade}" class="form-control" placeholder="Cidade" aria-describedby="basic-addon1">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                                <input type="date" name="nascimento" value="${sessionScope.nascimento}" data-toggle="tooltip" title="Informe sua data de nascimento" class="form-control" placeholder="Nascimento" aria-describedby="basic-addon1">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-education"></i></span>
                                <input type="text" name="universidade" value="${sessionScope.universidade}" class="form-control" placeholder="Universidade" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-map-marker"></i></span>
                                <input type="text" name="campus"  value="${sessionScope.campus}" class="form-control" placeholder="Campus" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-envelope"></i></span>
                                <input type="email" name="email" value="${sessionScope.email}" class="form-control" placeholder="Email" aria-describedby="basic-addon1">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                                <input type="password" name="senha" value="${sessionScope.senha}" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-sort"></i></span>
                                <select class="form-control" name="sexo" id="sexo" data-toggle="tooltip" title="Informe seu sexo">
                                    <option value="Masculino">Masculino</option>
                                    <option value="Feminino">Feminino</option>
                                    <option value="Outro">Outro</option>
                                </select>
                            </div>
                            <script type="text/javascript">
                                function selecionar(uf) {
                                    var sexo = document.getElementById("sexo");

                                    for (var i = 0; i < sexo.options.length; i++) {
                                        if (sexo.options[i].value == uf) {
                                            sexo.options[i].selected = "true";
                                            break;
                                        }
                                    }
                                }
                            </script>
                        </div>  
                        <div class="input-group input-group"> 
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                            <input data-toggle="tooltip" name="foto" value="${sessionScope.foto}" title="Escolha sua foto do perfil" type="file" class="form-control" aria-describedby="basic-addon1" required>
                        </div>

                        <div class="form-group" id="divBtLogin">
                            <input type="hidden" name="identificador" value="AtualizaUsuario"> 
                            <input type="submit" name="atualizar" class="btn btn-secundary btn-md btn-block" role="button" value="Atualizar">
                        </div>
                    </form>
        </div>

    </body>
</html>

