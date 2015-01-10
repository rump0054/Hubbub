<html>
<head>
  <title>
      Timeline for ${ user.profile ? user.profile.fullName : user.loginId }
  </title> 
  <meta name="layout" content="main"/>
  <g:if test="${user.profile?.skin}">
    <g:external dir="css" file="${user.profile.skin}.css"/>
  </g:if>
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
  <h1>Timeline for ${ user.profile ? user.profile.fullName : user.loginId }</h1>

  <g:if test="${flash.message}">
    <div class="flash">
      ${flash.message}
    </div>
  </g:if>
  
  <div id="newPost">
    <g:render template="postNew" />
  </div>
  <br/>
  <div id="allPosts">
    <g:render template="postEntry" collection="${user.posts}" var="post"/>
  </div>
</body>
</html>