<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Navbar</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse" id="navBarNav">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" id="linkMenu" href="inicial.jsp"><span class="glyphicon glyphicon-home"></span> TCCQuery</a>
                </div>
                
                
                <form method="post" action="FrontControl" id="deslogar">
                    <input type="hidden" name="identificador" value="DeslogaSistema">
                    <ul class="nav navbar-nav navbar-right"> 
                        <li role="presentation"><a id="linkMenu" href="#" onclick="document.getElementById('deslogar').submit();"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    </ul>
                </form>

            </div>
        </nav>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
    </body>
</html>
