<%@ include file="header.jsp" %>

<link rel="stylesheet" href="css/loginCSS.css">
<div>
<section class="login-form">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <select id="role" name="role" required>
                <option value="Admin">Admin</option>
                <option value="Customer">Customer</option>
            </select><br><br>
        <button type="submit" value="login.jsp">Login</button>
    </form>
    <p><a href="register.jsp">Create New Account</a></p>
</section>
</div>
<%@ include file="footer.jsp" %>