<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SHA-1</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <h1 style="padding-left: 30% ">SHA-1 </h1>

<div id="mainFrame">
    <form id="encryptMode">
        <label for="message">Message to be encrypted:</label>
        <input type="text" id="message">
    </form>
<%--    <button type="submit" form="encryptMode" value="submit">Encrypt</button>--%>
    <c:url value="/sha1encrypt" var="encrypt"/>
    <a href="${encrypt}" >Encrypt</a>
    <p>Encrypted message:</p> <br><br>

    <b id="encryptedMessage">
        ${msg}
    </b>
</div>

<script src="js/sha1Front.js"></script>
</body>
</html>