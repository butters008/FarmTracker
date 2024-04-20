<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
  
    <!-- Version 2 Links -->
    <link rel="stylesheet" href="../pub/css/LayoutStyle.css">
    <link rel="stylesheet" href="../pub/css/Animal_Style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;700&family=Roboto:wght@500&display=swap" rel="stylesheet">

    <title>Farm Management System</title>
</head>
<body class="LayoutBody">
    <header class="LayoutHeader">
        <div>
            <img id="siteLogo" src="../pub/images/farmLogo.png" alt="farmlogo">
            <%-- Going to change so it reads (user's Farm Management Systems) --%>
            <%-- <h3 style="padding-left: 25px;font-size: xxx-large;">Farm Managment System</h3>  --%>
        </div>

<%-- <div id="headerAccount">
<sec:authorize access="isAuthenticated()">
<img src="../pub/images/avatarIcon.svg" alt="farmlogo" style="max-width: 15%; border-radius: 35px">
<span style="padding-left: 15px; font-size: x-large"><strong><sec:authentication
property="principal.username"/></strong></span>
</sec:authorize>
</div> --%>

    </header>
    <nav id="LayoutNaivgation">
        <ul class="navULContainer">
            <li class="navButton"><a href="../login/login">Login</a></li>
            <li class="navButton"><a href="../index">Index</a></li>
            <li class="navButton"><a href="../animal/animal-dashboard">Add Animal</a></li>
            <%-- ADMIN TOOLS --%>
            <li class="navButton"><a href="../systems/systems-dashboard">Systems Dashboard</a></li>
        </ul>
    </nav>    
