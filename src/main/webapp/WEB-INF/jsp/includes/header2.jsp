<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--  local links for project  -->
    <link rel="stylesheet" href="../pub/css/BaseStyle.css">
    <link rel="stylesheet" href="../pub/css/gridStyle.css">
    <link rel="stylesheet" href="../pub/css/AnimalStyle.css">
    <link rel="stylesheet" href="../pub/css/UserStyle.css">
    <script src="../pub/js/working.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!--  Link to font and other frameworks  -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;700&family=Roboto:wght@500&display=swap"
          rel="stylesheet">
        
    <!-- Version 2 Links -->
    <link rel="stylesheet" href="../pub/css/LayoutStyle.css">

    <!--  Remaining head information  -->
    <title>Farm Management System</title>
</head>
<body class="LayoutBody">
<div class="mainGridContainer">
    <header class="headerContent">
        <div id="siteLogo">
            <img src="../pub/images/farmLogo.png" alt="farmlogo" style="padding-bottom: 10px;">
            <h1 style="padding-left: 25px;font-size: xxx-large;">FMS</h1>
        </div>
        <div id="headerSearch">

        </div>
        <div id="headerAccount">
            <sec:authorize access="isAuthenticated()">
                <img src="../pub/images/avatarIcon.svg" alt="farmlogo" style="max-width: 15%; border-radius: 35px">
                <span style="padding-left: 15px; font-size: x-large"><strong><sec:authentication
                        property="principal.username"/></strong></span>
            </sec:authorize>
        </div>

    </header>
    <main class="mainContentContainer">
        <nav id="navContainer">
            <ul class="navULContainer">
                <li class="navButton"><a href="../index">Index</a></li>
                <sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
                    <%-- TODO:Trying to make a drop-down => Gold Plate  --%>
                    <li class="navButton"><a href="../herd/addAnimal">Add Cow or Bull</a></li>
                    <li class="navButton"><a href="../herd/calfInfo">Add Calf</a></li>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
                    <li class="navButton"><a href="../herd/list">List</a></li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li class="navButton account"><a href="../login/login">Login</a></li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li class="navButton account"><a href="../user/register">Sign Up</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="navButton account"><a href="../login/logout">Logout</a></li>
                </sec:authorize>
            </ul>
        </nav>