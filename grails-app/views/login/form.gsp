<html>
<head>
  <title>Login Form</title>
  <meta name="layout" content="main">
</head>
<body>
  <h1>Please Login</h1>
  <g:form action="signIn">
    Login Id:
    <g:textField name="loginId" value="${loginId}"/>
    <br/>
    Password:
    <g:passwordField name="password" value="${password}"/>
    <g:submitButton name="login" value="Login"/>
  </g:form>
</body>
</html>