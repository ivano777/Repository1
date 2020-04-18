<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Spring Boot ajax example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Ivano.com</a>
        </div>
    </div>
</nav>

<div class="container" style="min-height: 500px">

    <div class="starter-template">
        <h1>Gestione Cinema</h1>

        <div id="feedback"></div>

                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="bth-logout"
                            class="btn btn-primary btn-lg">Logout
                    </button>
                </div>

    </div>

</div>

<div class="container">
    <footer>
        <p>
            © <a href="http://localhost:8090/">Ivano.com</a> 2017
        </p>
    </footer>
</div>

<script type="text/javascript"
        src="webjars/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript" src="js/logout.js"></script>

</body>
</html>