<%@ page import="cz.actis.catalog.Image" %>



<div class="fieldcontain ${hasErrors(bean: imageInstance, field: 'fileName', 'error')} required">
	<label for="fileName">
		<g:message code="image.fileName.label" default="File Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fileName" required="" value="${imageInstance?.fileName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: imageInstance, field: 'fullPath', 'error')} required">
	<label for="fullPath">
		<g:message code="image.fullPath.label" default="Full Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fullPath" required="" value="${imageInstance?.fullPath}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: imageInstance, field: 'file', 'error')} required">
	<label for="file">
		<g:message code="image.file.label" default="File" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="file" name="file" />

</div>

