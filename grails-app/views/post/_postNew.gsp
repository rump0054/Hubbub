<h3>
  What is ${user.profile.fullName} hacking on right now?
</h3>
<p>
  <g:form action="addPost" id="${params.id}">
    <g:textArea id='postContent' name="content"
         rows="3" cols="50"/><br/>
    <g:submitButton name="post" value="Post"/>
  </g:form>
</p>