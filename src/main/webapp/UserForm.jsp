<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp" /><!---<!-- chama o arquivo de padronização -->
        <title>Login Usuários</title>
    </head>
    <body>
        <jsp:include page="./contents/cabecalho.jsp" />
        <div class="container">
            <div class="jumbotron"><!-- Importa o arquivo da biblioteca do bootstrap-->
                <h2>Adicionar novo usuário</h2>
            </div>
            
            <!--Pegue o contexto do caminho-->
            <form action="<%=request.getContextPath()%>/bsuser/register">
            
                <!-- email************************** -->
                <div class="container">
                    <label class="form-control" for="userFullname"><span class=" glyphicon glyphicon-evey-close"></span>
                       Nome</label>
                    <input type="text" placeholder="Insira seu nome" name="userFullname" size="90"  value="<c:out value='${user.fullname}'/>"/>
                </div>
                
                <div class="container">
                    <label  class="form-control" for="userEmail"><span class=" glyphicon glyphicon-envelope"></span>
                        Email</label>
                    <input type="text" placeholder="Forneça seu email" name="userEmail" size="90" value="<c:out value='${user.email}'/>"/>
                </div>
                            <!-- passaword************************** -->
                <div class="container">
                    <label class="form-control" for="userPassword"><span class=" glyphicon glyphicon-evey-close"></span>
                       Passaword</label>
                    <input type="password" placeholder="Insira sua senha" name="userPassword" size="90" value="<c:out value='${user.password}'/>"/>
                </div>

                <!-- Botãp************************** -->
                <div class="container">
                    <button type="submit" class="btn btn-default" id="psw"><span class="glyphicon glyphicon-send"></span> Login </button>
                </div>
            </form>


        <jsp:include page="./contents/rodape.jsp" />

    
</div>

</body>
</html>
