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
    <a href="#" id="showHideUrl" onclick="toggleTinyUrl(); return false;">
      Show TinyURL
    </a>
    <g:img id="spinner" style="display:none"
      uri="/images/spinner.gif"/>
  </g:form>
<div id="tinyUrl" style="display:none;">
                      <g:formRemote name="tinyUrlForm" url="[action: 'tinyUrl']" onSuccess="addTinyUrl(data);">
                      TinyUrl: <g:textField name="fullUrl"/>
                      <g:submitButton name="submit" value="Make Tiny"/>
                   </g:formRemote>
                </div>

                <r:script disposition="head">
                function toggleTinyUrl() {
                    var toggleText = $('#showHideUrl');
                    if ($('#tinyUrl').is(':visible')) {
                        $('#tinyUrl').slideUp(300);
                        toggleText.innerText = 'Hide TinyURL';
                    } else {
                        $('#tinyUrl').slideDown(300);
                        toggleText.innerText = 'Show TinyURL';
                    }
                }
                </r:script>
</p>