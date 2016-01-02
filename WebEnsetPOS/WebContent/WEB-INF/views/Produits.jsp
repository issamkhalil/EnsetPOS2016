<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/materialize.css" rel="stylesheet">
</head>
<body>
	<h1>Catalogue de produits</h1>

	<div class="container">

		<div class="row">
			<div class="col-lg-8">

				<table border="1">
					<tr style="""background-color:pink;\">
						<td>ID</td>
						<td>Referance</td>
						<td>Prix de Vente</td>
						<td>Categorie</td>
						<td>Image</td>
					</tr>
					<s:iterator value="produits">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="referance" /></td>
							<td><s:property value="prixVente" /></td>
							<td><s:property value="categorie" /></td>
							<td><s:property value="image" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>