<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Novo contato</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<main class="container">
    <h1><%=request.getParameter("acao").substring(0, 1).toUpperCase() + request.getParameter("acao").substring(1, request.getParameter("acao").length()).toLowerCase()%>
        contato</h1>
    <c:if test="${null != erro}">
        <p class="alert alert-warning">${erro}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/gestaoContatos?acao=<%=request.getParameter("acao") == "CADASTRAR" ? request.getParameter("acao"):request.getParameter("acao")+"&contatoId="+request.getParameter("contatoId")%>"
          method="POST">
        <div class="row">
            <div class="col-12">
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" class="form-control" value="${contato.nome}" required>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="telefone">Telefone</label>
                <input type="text" name="telefone" id="telefone" class="form-control" value="${contato.telefone}"
                       required>
            </div>
            <div class="col-6">
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" class="form-control" value="${contato.email}" required>
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-3" name="adicionar">Salvar</button>
    </form>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>
</html>
