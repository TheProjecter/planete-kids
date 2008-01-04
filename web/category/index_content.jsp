<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2><s:text name="category"/></h2>
<s:div cssClass="main">
    <s:iterator value="getCategories()">
        <script type="text/javascript">coldiv_load('category_<s:property value="getId()" />');</script>
        <s:hidden id="category_%{getId()}" value="{ init : false, col_img : 'images/down_enable.png', uncol_img : 'images/up_enable.png'}"/>
        <div class="category">
            <h3>
                <img id="category_<s:property value="getId()" />_img" onclick="coldiv_click('category_<s:property value="getId()"/>')" />
                <img src="<s:property value="getImage_small()" />" width="20px" height="20px"/>
                <s:property value="getName(getLocale())" />
            </h3>
            <div id="category_<s:property value="getId()" />_div">
                <img src="<s:property value="getImage_medium()" />" onmouseover="show('category_<s:property value="getId()" />_imgLarge')" onmouseout="hide('category_<s:property value="getId()" />_imgLarge')" width="50px" height="50px"/>
                <img id="category_<s:property value="getId()" />_imgLarge" src="<s:property value="getImage_large()"/>" style="display:none; z-index:1; position:absolute; background-color:white; border-color:black; border-width:1px; border-style: solid;" width="100px" height="100px"/>
            </div>
        </div>
    </s:iterator>
</s:div>