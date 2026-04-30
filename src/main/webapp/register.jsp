<%@ page language="java" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="container">

    <h2>Register</h2>

    <%
        String error = (String) request.getAttribute("error");
        String msg = (String) request.getAttribute("msg");
    %>

    <% if (error != null) { %>
        <div class="msg error"><%= error %></div>
    <% } %>

    <% if (msg != null) { %>
        <div class="msg success"><%= msg %></div>
    <% } %>

    <form action="register" method="post">

        <input type="text" name="name" placeholder="Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" id="password" name="password" placeholder="Password" required>

         <div id="strength"></div>

<input type="password" id="confirmPassword" placeholder="Confirm Password" required>

<div id="msg"></div>
        <button type="submit">Register</button>

    </form>

    <div class="link">
        Already registered?
        <a href="<%=request.getContextPath()%>/login.jsp">Login</a>
    </div>

</div>

<script src="<%=request.getContextPath()%>/js/validation.js"></script>