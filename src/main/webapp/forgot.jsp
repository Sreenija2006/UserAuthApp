<%@ page language="java" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="container">

    <h2>Forgot Password</h2>

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

    <form action="forgot" method="post">

        <input type="email" name="email" placeholder="Enter Email" required>

        <button type="submit">Send OTP</button>

    </form>

</div>