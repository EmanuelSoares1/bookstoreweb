<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp" />
        <title>Aplicação Books Store</title>
        <style>
            body{
                align-content: center;
            }
        </style>

    </head>
    <body style="
          background-color: white">
        <div class="corpo" align="center">  
        
        <jsp:include page="./contents/cabecalho.jsp" />
        <jsp:include page="./contents/menu.jsp" />

            <c:if test="${book != null}">
                <form action="update" method="post">
                </c:if>
                <c:if test="${book == null}">
                    <form action="insert" method="post">
                    </c:if>
                        
                    
                    
                        <caption>
                            <h2><!<!-- titulo do body -->
                                <c:if test="${book != null}">
                                    Editar Livro
                                </c:if>
                                <c:if test="${book == null}">
                                    Adicionar novo Livro
                                </c:if>
                            </h2>
                        </caption>
                        
                        <c:if test="${book != null}">
                            <input type="hidden" name="formId" value="<c:out 
                                       value='${book.id}' />" />
                        </c:if> 
                        
                        <!--*///////////////////////////////////////////////////////////-->
                        <!--Titulo-->
                        <div class="container">
                            <!--texto e incone(span)--><label class="titulo" for="titulo"><span class="glyphicon glyphicon-book"></span> Titulo</label>
                            <!--Caixa de texto--><input type="text" placeholder="Insira o título" name="formTitulo" size="60"
                                       value="<c:out value='${book.titulo}' />"
                                       />
                            
                        </div>
                                       
                        <!--Autor-->
                        <div class="container">
                            <label class="autor" for="autor"><span class="glyphicon glyphicon-user"></span>Autor</label>
                            <input type="text" placeholder="Informe o nome do autor" name="formAutor" size="45"
                                       value="<c:out value='${book.autor}' />"
                                       />
                        </div>
                                       
                        <!--Preço-->
                        <div class="container">
                            <label class="autor" for="preco"><span class="glyphicon glyphicon-usd"></span>Autor</label>
                            <input type="text" placeholder="Insira o valor do livro" name="formPreco" size="45"
                                       value="<c:out value='${book.preco}' />"
                                       />
                        </div>
                        
                        <!--/////////////////////////////////////////////////////-->
                        <div class="container">
                            <button type="submit" value="Enviar" ><span class="glyphicon glyphicon-send"></span> Enviar</button>
                        </div>
                        
                       
                    
                    <jsp:include page="./contents/rodape.jsp" />
                                       
                </form>
                    
               
        </div>

    </body>
</html>