<%@ page language="java" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="container">

    <h2>Reset Password</h2>

    <%
        String error = (String) request.getAttribute("error");
        String msg = (String) request.getAttribute("msg");
        String email = request.getParameter("email");
    %>

    <% if (error != null) { %>
        <div class="msg error"><%= error %></div>
    <% } %>

    <% if (msg != null) { %>
        <div class="msg success"><%= msg %></div>
    <% } %>

    <form action="reset-password" method="post">

        <input type="hidden" name="email" value="<%=email%>">

        <input type="password" id="password" name="password" placeholder="New Password" required>

        <div id="strength"></div>

        <input type="password" id="confirmPassword" placeholder="Confirm Password" required>

        <div id="msg"></div>

        <button type="submit">Reset Password</button>

    </form>

</div>

<script src="<%=request.getContextPath()%>/js/validation.js"></script>