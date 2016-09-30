<%@page import="javaPackage.DataModelBean"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%-- Access bean placed in the request by ShowInfoRequestHandler --%>
<jsp:useBean id="dataModelBean"
  scope="request"
  type="javaPackage.DataModelBean" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head><title>Hello <%=dataModelBean.getForename()%></title></head>
<body>

Welcome <b><%=dataModelBean.getForename()%> <%=dataModelBean.getSurname()%></b>!

<p/>Your email is <i><%=dataModelBean.getEmail()%></i>

</body>
</html>