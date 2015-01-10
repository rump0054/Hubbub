<html>
<head>
  <title>Global Timeline</title> 
  <meta name="layout" content="main"/>
</head>
<body>
  <h1>Global Timeline</h1>
  <div id="allPosts">
    <g:render template="postEntry" collection="${posts}" var="post"/>
  </div>
  <g:paginate action="global" total="${postCount}" max="25"/>
</body>
</html>