<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contatos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <main class="container">
        <h1>Contatos</h1>
        <a href="${pageContext.request.contextPath}/restrito/contatos/contato.jsp?acao=CADASTRAR" class="btn btn-primary">Novo</a>
        <c:if test="${null != sucesso}">
            <p class="alert alert-success">${sucesso}</p>
        </c:if>

        <c:if test="${null != erro}">
        <p class="alert alert-warning">${erro}</p>
    </c:if>
        <table id="table" class="table table-hover">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>E-mail</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${contatos.isEmpty()}">
                    <tr>
                        <td colspan="4">
                            Você ainda não tem contatos cadastrados. Clique no botão 'Novo' para cadastrar.
                        </td>
                    </tr>
                </c:if>
                <c:forEach items="${contatos}" var="contato">
                    <tr>
                        <td>${contato.nome}</td>
                        <td>${contato.telefone}</td>
                        <td>${contato.email}</td>
                        <td>
                            <a href="/gestaoContatos?acao=EDITAR&contatoId=${contato.id}">Editar</a>
                            <a href="/gestaoContatos?acao=EXCLUIR&contatoId=${contato.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
