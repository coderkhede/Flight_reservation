<%@ include file="header.jsp" %>

<link rel="stylesheet" href="css/registerCSS.css">

<section class="register-form">
    <h2>Register</h2>
    <form action="RegisterServlet" method="post">
    <label for="username">Username:
        <input type="text" name="username" value="username">
        </label>
            
            <br>
            <label for="password">Password:
            <input type="text" id="password" name="password" required>
            </label>
            
            <br>
            <label for="email">Email:
            <input type="email" id="email" name="email" required>
            </label>
            
            <button value = "register" name = "value">Register</button>
    </form>
</section>

<%@ include file="footer.jsp" %>