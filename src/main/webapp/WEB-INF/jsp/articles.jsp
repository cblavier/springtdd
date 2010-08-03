<%@ page contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<body>
<h2>Liste des articles</h2>
<c:if test='${articles != null}'>
	<table class="list">
		<thead>
			<tr>
				<th>Titre</th>
				<th>Contenu</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}" varStatus="status">
				<tr>
					<td><c:out value="${article.title}"/></td>
					<td><c:out value="${article.content}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<a href="addArticle.htm">Ajouter un article</a>
</body>
</html>