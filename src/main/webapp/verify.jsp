<%@ page language="java" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="container">

<h2>Verify OTP</h2>

<%
    String email = request.getParameter("email");
    if (email == null) {
        email = (String) request.getAttribute("email");
    }

    String error = (String) request.getAttribute("error");

    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
        session.removeAttribute("msg");
    }
%>

<% if (error != null) { %>
    <div class="msg error"><%= error %></div>
<% } %>

<% if (msg != null) { %>
    <div class="msg success"><%= msg %></div>
<% } %>

<form action="verify" method="post">

    <input type="email" name="email" value="<%=email%>" readonly>
    <input type="text" name="otp" placeholder="Enter OTP" required>

    <!-- IMPORTANT -->
    <div id="timer" style="margin:10px 0; font-weight:bold;"></div>

    <button type="submit">Verify</button>

</form>

<form action="resend-otp" method="post">
    <input type="hidden" name="email" value="<%=email%>">
    
    <!-- IMPORTANT -->
    <button type="submit" id="resendBtn">Resend OTP</button>
</form>

</div>

<!-- IMPORTANT -->
<script src="<%=request.getContextPath()%>/js/otp.js"></script>