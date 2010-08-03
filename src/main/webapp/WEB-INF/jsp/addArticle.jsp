<%@ page contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
	<html>
	<body>
	<h2>Ajouter un article</h2>
	<form:form method="POST" action="addArticle.htm" commandName="article">
		<b>Titre</b>
		<form:input path="title" />
		<br>
		<b>Contenu</b>
		<form:textarea path="content" />
		<br>
		<input type="submit" value="Poster"/>
	</form:form>
	</body>
	</html>