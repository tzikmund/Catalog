<%@ page import="cz.actis.catalog.Item" %>



<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'brand', 'error')} required">
	<label for="brand">
		<g:message code="item.brand.label" default="Brand" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="brand" required="" value="${itemInstance?.brand}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="item.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${itemInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="item.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="255" required="" value="${itemInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="item.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: itemInstance, field: 'price')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'image', 'error')} required">
	<label for="image">
		<g:message code="item.image.label" default="Image" />
		<span class="required-indicator">*</span>
	</label>
    <input type="file" name="file"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'categories', 'error')} ">
	<label for="categories">
		<g:message code="item.categories.label" default="Categories" />
		
	</label>
	<g:select name="categories" from="${cz.actis.catalog.Category.list()}" multiple="multiple" optionKey="id" size="5" value="${itemInstance?.categories*.id}" class="many-to-many"/>

</div>

