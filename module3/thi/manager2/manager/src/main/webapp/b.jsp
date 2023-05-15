<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/05/2023
  Time: 6:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">

    function editConfirm() {
        return window.confirm("Are you sure you want to edit this?")
    }
    function cancelConfirm() {
        return window.confirm("Are you sure you want to cancel?")
    }
    function deleteConfirm() {
        return window.confirm("Are you sure you want to delete this?")
    }
    function createConfirm() {
        return window.confirm("Are you sure you want to create this?")
    }

</script>
</body>
</html>
