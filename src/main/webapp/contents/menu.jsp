<p>
        <!--Bot�o linkado para cadastrar novo livro-->
    <a href="<%=request.getContextPath()%>/bstore/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Adicionar novo Livro</a>
        <!--Link listar novos livros-->
    <a href="<%=request.getContextPath()%>/bstore/list" class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Livros</a>
    <br><br>
        <!-- Registrar novo usu�rio -->
    <a href="<%=request.getContextPath()%>/bsuser/register" class="btn btn-default">
        <span class="glyphicon glyphicon-user"></span>
        Lista de usu�rio</a>
        
  
        <a href="<%=request.getContextPath()%>/login" class="btn btn-default">
        <span class="glyphicon glyphicon-ban-circle"></span>
        Logout</a>
        
</p>