<%@ page language="java" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="container">

    <h2>Login</h2>

    <%
        String error = (String) request.getAttribute("error");
    %>

    <% if (error != null) { %>
        <div class="msg error"><%= error %></div>
    <% } %>

    <form action="login" method="post">

        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>

        <button type="submit">Login</button>

    </form>

    <div class="link">
        <a href="<%=request.getContextPath()%>/forgot.jsp">Forgot Password?</a>
    </div>

    <div class="link">
        New user?
        <a href="<%=request.getContextPath()%>/register.jsp">Register</a>
    </div>

</div>