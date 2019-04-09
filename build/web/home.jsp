<%-- 
    Document   : Home
    Created on : 06/04/2019, 22:19:18
    Author     : Tenente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Equals</title>
        <link rel="shortcut icon" href="https://www.equals.com.br/wp-content/themes/equals-theme/assets/img/favicon.ico">
        <!-- CSS Bootstrap -->
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- JS, Popper.js, e jQuery do Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="logo">
            <a href="https://www.equals.com.br">
                <img src="https://www.equals.com.br/wp-content/themes/equals-theme/assets/img/logo_equals.png">
            </a>
        </div><br>
        <div class="centro card">
            <h5 class="card-header">Envio do arquivo:</h5>
            <div class="card-body">
                <form class="form-group" action="FileUploader" method="post" enctype="multipart/form-data">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="selectedFile" name="selectedFile" required>
                        <label class="custom-file-label file-fixer" for="selectedFile">Selecionar arquivo</label>
                        <script>
                            $('#selectedFile').on('change', function() { 
                                //Variável fileName corrige o bug no nome fakepath
                                var fileName = $(this).val().replace('C:\\fakepath\\', " ");
                                $(this).next('.custom-file-label').html(fileName);
                            });
                        </script>
                    </div>
                    <br><br>
                    <button type="submit" class="btn btn-primary">Enviar arquivo</button>
                </form>
            </div>
        </div>
    </body>
</html>
