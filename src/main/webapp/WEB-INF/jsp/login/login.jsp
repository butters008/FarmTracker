<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../includes/header.jsp"/>

<main class="Animal_Dashboard_Container">
    <h2>Exisiting users, Please either Login and new users please Sign Up</h2>
    <div>
        <h4>Log in</h4>
        <form action="/login/loginSubmit" method="post" class="loginPageStyle">
    <div class="lTitle" style="display: flex; flex-direction: column; text-align: center">
        <h1 style="font-size: xx-large">Login Page</h1><br>
        <div id="loginError"></div>
    </div>
    <div class="lUserName">
        <label for="userNameID" style="font-size: x-large; text-align: center">Username:</label>
        <input id="userNameID" type="text" name="username" style="width: 30%; height:3vh; border-radius: 10px; font-size: large; text-align: center"><br>
    </div>
    <div class="lPassword">
        <label for="passwordID" style="font-size: x-large; text-align: center">Password:</label>
        <input id="passwordID" type="password" name="password" style="width: 30%; height:3vh; border-radius: 10px;font-size: large; text-align: center">
    </div>
    <div class="lSubmit">
        <button type="submit"><strong>Login</strong></button>
    </div>

</form>
    </div>
    <div>
        <h4>Sign Up</h4>
        <button type="button">Sign Up</button>
    </div>

<script>
    function errorLogin(){
        let errorCheck = window.location.search
        const errorLocation = document.getElementById("loginError");
        console.log(errorCheck);
        if(errorCheck.valueOf("login?error")){
            errorLocation.textContent = "Incorrect Username or Password";
            errorLocation.style.color = "red";
        }
    }

    window.onload = errorLogin();
</script>

</main>

<jsp:include page="../includes/footer.jsp"/>