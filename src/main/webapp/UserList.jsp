<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--Acima é como se fosse um import do java-->
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp"/><!--<!-- chama pasta e aplica os parâmetros do arquivo -->
        <title>List of Users</title>
    </head>

    <body>
        <!--Link a partir da mudança : localhost:8080/bookstoreweb/bstore/list-->
        <div class="container">
            <jsp:include page="./contents/cabecalho.jsp" />
            <jsp:include page="./contents/menu.jsp" />
            <div class="table-responsive">
                <table class="table table-hover">
                    <caption><h2>List of logins</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Nome do usuário</th>
                        <th>Email</th>
                    </tr>

                    <c:forEach var="user" items="${listaUser}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.fullName}" /></td>
                            <td><c:out value="${user.email}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <jsp:include page="./contents/rodape.jsp" />

        </div>
    </body>
</html>