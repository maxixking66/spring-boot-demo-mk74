<%--
  Created by IntelliJ IDEA.
  User: Mohsen
  Date: 9/29/2022
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Home</title>
</head>
<body>
<h1>Home page</h1>
<hr/>
<h2 id="username"></h2>
<form>
    <label>
        userId:
        <input id="userId" name="userId" type="number">
    </label>
    <button type="button" onclick="getUser()">get User</button>
</form>
</body>
</html>
<script>
    function getUser() {
        let userId = document.getElementById("userId").value;
        $.ajax({
            url: '/user?id=' + userId,
            success: function (response) {
                console.log(response);
                document.getElementById("username")
                    .innerText = response.firstName;
            },
            error: function (jqXHR, exception) {
                console.log('error');
                document.getElementById("username")
                    .innerText = 'user not found';
            },
        });
    }
</script>