
<%@ page import="cz.actis.catalog.Category" %>
<!DOCTYPE html>
<html>
	<head>
		%{--<meta name="layout" content="main">--}%
		<g:set var="entityName" value="${message(code: 'category.label', default: 'Category')}" />
        <link href="${resource(dir: 'css', file: 'style.css')}" type="text/css" rel="stylesheet">
		<title><g:message code="default.show.label" args="[entityName]" /></title>
        %{--<title>Katalog</title>--}%
	</head>
	<body>
		%{--<a href="#show-category" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
    <div class="content">
        <h1>Katalog</h1>
        <div class="categoryList">
            <ul>
                <h5>Kategorie</h5>
                <li><g:link controller="category" action="index">Správce kategorií</g:link></li>
                <li><g:link controller="category" action="create">Nová kategorie</g:link></li>
                <li><g:link controller="item" action="create">Nový produkt</g:link></li>
                <li><g:link controller="item" action="index">Všechny produkty</g:link></li>
                <g:each in="${categories}" var="category">
                    <li><g:link controller="category" action="show" id="${category.id}">${category.name}</g:link></li>
                </g:each>
            </ul>
        </div>
        <div class="itemList">
            <g:each in="${itemsFromCategory}" var="item">
                <div class="item">
                    <g:each in="${item.images}" var="img">
                        <g:link controller="image" action="showImage" id="${img.id}"><g:img style="width: 200px; height: 150px;" file="${img.fileName}"/></g:link>
                    </g:each>
                    <h2>Název: ${item.name}</h2>
                    <h3>Značka: ${item.brand}</h3>
                    <p>Popis: ${item.description}</p>
                    <h4>Cena: ${item.price} Kč</h4>
                </div>
            </g:each>
        </div>
    </div>
	</body>
</html>
