<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:div cssClass="contentHeader">
    <h2><s:text name="create"/></h2>
</s:div>
<s:div cssClass="contentMain">
    <form id="create" method="post" name="create">
        <table class="account">
            <tr>
                <td align="right">
                    <s:text name="password"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="password" name="password"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="firstName"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="firstName"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="lastName"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="lastName"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="addressLine1"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="addressLine1"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="addressLine2"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="addressLine2"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="addressLine3"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="addressLine3"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="zipCode"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="zipCode"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="city"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="city"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="phoneNumber"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="phoneNumber"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <s:text name="faxNumber"/>&nbsp;:
                </td>
                <td align="left">
                    <input type="text" name="faxNumber"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <s:url id="url_content" namespace="/account" action="create_submit" includeParams="none"/>
                    <input type="submit" value="<s:text name="submit"/>" class="button" onclick="navExec(new navRequest('content', '<s:property value="url_content"/>', null, null, 'create'))"/>
                </td>
            </tr>
        </table>
    </form>
</s:div>