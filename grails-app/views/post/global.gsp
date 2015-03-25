<html>
<head>
  <title>Global Timeline</title> 
  <meta name="layout" content="main"/>
  <g:javascript library="jquery"/>
  <g:javascript>
    function clearPost(e) {
      $('#postContent').val('');
    }
    function showSpinner(visible) {
      if (visible) $('#spinner').show();
      else $('#spinner').hide();
    }
    function addTinyUrl(data) {
      var tinyUrl = data.urls.small;
      var postBox = $("#postContent")
      postBox.val(postBox.val() + tinyUrl);
      toggleTinyUrl();
      $("#tinyUrl input[name='fullUrl']").val('');
    }
  </g:javascript>
</head>
<body>
  <h1>Global Timeline</h1>

  <g:if test="${flash.message}">
    <div class="flash">
      ${flash.message}
    </div>
  </g:if>
    
  <sec:ifLoggedIn>
    <div id="newPost">
      <g:render template="postNew" />
    </div>
  </sec:ifLoggedIn>

  <br/>

  <div id="allPosts">
    <g:render template="postEntry" collection="${posts}" var="post"/>
  </div>
  <g:paginate action="global" total="${postCount}" max="25"/>
</body>
</html>