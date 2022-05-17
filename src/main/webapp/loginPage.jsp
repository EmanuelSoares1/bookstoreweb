<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Faça seu login</h1>
            <jsp:include page="./contents/cabecalho.jsp" />
            
            <form action="login" method="post">
                <label for="email">Email:</label>
                <input name="email" size="30" />
                <br><br>
                <label for="password">Password:</label>
                <input type="password" name="password" size="30" />
                <!--
                Esse atributo MESSAGE será utilizado como retorno de
               mensagem ao usuário caso
                login inválido.
                -->
                <br>${message}<br>
                <a href="<%=request.getContextPath()%>/bsuser/new">Se não possui uma conta registre-se já!!!</a>
                <br>
                <!--aqui cadastra se caso não tiver uma conta-->
                
                <button type="submit">Login</button>
            </form>
                <jsp:include page="./contents/rodape.jsp" />
        </div>
    </body>
</html>

  