<!DOCTYPE html>

<html lang="en">
<head>
<#include "bootstrap.ftl">
</head>
<body>
<div class="col-xs-6" style="background-color: black; color:white">
    Date: ${time?date}
    <br>
    Time: ${time?time}
    <br>
    Message: ${message}
</body>
</div>


</html>