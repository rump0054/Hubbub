<html>
    <head>
        <title>
            Timeline for ${ user.profile ? user.profile.fullName : user.loginId }
        </title> 
        <meta name="layout" content="main"/>
        <g:if test="${user.profile?.skin}">
          <g:external dir="css" file="${user.profile.skin}.css"/>
        </g:if>
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

