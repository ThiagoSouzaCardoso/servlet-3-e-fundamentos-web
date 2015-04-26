<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

Bem vindo ao nosso gerenciador de empresas!<br/>
<br/>
<c:if test="${not empty sessionScope['usuario.logado']}">
    Você está logado como ${sessionScope['usuario.logado'].email}<br/>
</c:if>

<form action="executa?tarefa=NovaEmpresa" method="post">
    Nome: <input type="text" name="nome" /><br/>
    <input type="submit" value="Enviar" />
</form>

<form action="login" method="post">
    Email: <input type="text" name="email" /><br/>
    Senha: <input type="password" name="senha" /><br/>
    <input type="submit" value="Login" />
</form>

<form action="executa?tarefa=Logout" method="post">
    <input type="submit" value="Logout" />
</form>

</body>
</html>