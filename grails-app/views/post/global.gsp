<html>
<head>
  <title>Global Timeline</title> 
  <meta name="layout" content="main"/>
</head>
<body>
  <h1>Global Timeline</h1>
  <div id="allPosts">
    <g:each in="${posts}" var="post">
      <div class="postEntry">
        <div class="postText">
          ${post.content}
        </div>
        <div class="postDate">
          ${post.dateCreated}
        </div>
      </div>
    </g:each>
    <g:paginate action="global" total="${postCount}" max="25"/>
  </div>
</body>
</html>