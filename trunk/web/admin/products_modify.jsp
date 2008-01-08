<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planete-kids</title>
        <s:head theme="ajax" debug="true" />
        <link href="<s:url value='/style.css'/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>

    <s:div cssClass="main">
	<h1>Planete-Kids</h1>
	<div style="text-align:center">
	<h2><s:text name="admin"/></h2>

	<s:url id="viewlabels" namespace="/admin" action="labels" includeParams="none" />
	<s:a href="%{viewlabels}"><s:text name="labels" /></s:a>
	
	<s:url id="viewcolors" namespace="/admin" action="colors" includeParams="none" />
	<s:a href="%{viewcolors}"><s:text name="colors" /></s:a>
	
	<s:url id="viewcategories" namespace="/admin" action="categories" includeParams="none" />
	<s:a href="%{viewcategories}"><s:text name="categories" /></s:a>
	
	<s:url id="viewproducts" namespace="/admin" action="products" includeParams="none" />
	<s:a href="%{viewproducts}"><s:text name="products" /></s:a>
	
	<s:url id="viewcustomers" namespace="/admin" action="customers" includeParams="none" />
	<s:a href="%{viewcustomers}"><s:text name="customers" /></s:a>

	<br />
	<br />
	<div align=left>
	<form method="post" name="productform">
	<table>
	<tr><td align=right>Name (en)
        <td><input type="text" name="name" value="<s:property value="getProduct(getProductId()).getName('en')" />" size="35"/>
	<tr><td align=right>Name (fr)
        <td><input type="text" name="name" value="<s:property value="getProduct(getProductId()).getName('fr')" />" size="35"/>
	<tr><td align=right>Description (en)
        <td><input type="text" name="description_fr" value="<s:property value="getProduct(getProductId()).getDescription('en')" />" size="35"/>
	<tr><td align=right>Description (fr)
        <td><input type="text" name="description_en" value="<s:property value="getProduct(getProductId()).getDescription('fr')" />" size="35"/>
	<tr><td align=right>Category
        <td><input type="text" name="category_id" value="<s:property value="getProduct(getProductId()).getCategory().getId()" />" size="35"/>
	<tr><td align=right>Color
        <td><input type="text" name="category_id" value="<s:property value="getProduct(getProductId()).getColor().getId()" />" size="35"/>
	<tr><td align=right>Label
        <td><input type="text" name="category_id" value="<s:property value="getProduct(getProductId()).getLabel().getId()" />" size="35"/>
	<tr><td align=right>Age
        <td><input type="text" name="category_id" value="<s:property value="getProduct(getProductId()).getAge().getId()" />" size="35"/>
	<tr><td align=right>Price
        <td><input type="text" name="category_id" value="<s:property value="getProduct(getProductId()).getPrice()" />" size="35"/>
	<tr><td align=right>Stock
        <td><input type="text" name="category_id" value="<s:property value="getProduct(getProductId()).getStock()" />" size="35"/>
	<tr><td align=right>Image (large)
        <td><input type="text" name="image_large" value="<s:property value="getProduct(getProductId()).getImage_large()" />" size="35"/>
	<tr><td align=right>Image (medium)
        <td><input type="text" name="image_medium" value="<s:property value="getProduct(getProductId()).getImage_medium()" />" size="35"/>
	<tr><td align=right>Image (small)
        <td><input type="text" name="image_small" value="<s:property value="getProduct(getProductId()).getImage_small()" />" size="35"/>
	</table><br />
	<input type="submit" value="Submit" />
	</form>
	</div>
	</div>
    </s:div>
</body>
</html>