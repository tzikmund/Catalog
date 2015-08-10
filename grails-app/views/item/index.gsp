<%@ page import="cz.actis.catalog.Item" %>
<!DOCTYPE html>
<html>
<head>
    %{--<meta name="layout" content="main">--}%
    <g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}"/>
    <link href="${resource(dir: 'css', file: 'style.css')}" type="text/css" rel="stylesheet">
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    %{--<title>Katalog</title>--}%
</head>

<body>
<div class="content">
    <h1>Katalog</h1>
    <div class="categoryList">
        <ul>
            %{--TODO prestylovat--}%
            <h5>Kategorie</h5>
            <li><g:link controller="category" action="index">Správce kategorií</g:link></li>
            <li><g:link controller="category" action="create">Nová kategorie</g:link></li>
            <li><g:link controller="item" action="create">Nový produkt</g:link></li>
            <g:each in="${categories}" var="category">
                <li><g:link controller="category" action="show" id="${category.id}">${category.name}</g:link></li>
            </g:each>
        </ul>
    </div>
    <div class="itemList">
        <g:each in="${items}" var="item">
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
