<h3>
  What is ${user.profile.fullName} hacking on right now?
</h3>
<p>
  <g:form>
    <g:textArea id='postContent' name="content"
         rows="3" cols="50"/><br/>
    <g:submitToRemote value="Post" 
      url="[controller: 'post', action: 'addPostAjax']"
      update="allPosts"
      onSuccess="clearPost(data)"
      onLoading="showSpinner(true)"
      onComplete="showSpinner(false)"/>
    <g:img id="spinner" style="display:none"
      uri="/images/spinner.gif"/>
  </g:form>
</p>