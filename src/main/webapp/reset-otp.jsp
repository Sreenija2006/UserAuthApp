<link rel="stylesheet" href="css/style.css">
<div class="container">
<form action="verifyForgot" method="post">
    Email:
    <input type="email" name="email"
           value="<%= request.getParameter("email") %>" readonly><br><br>

    OTP:
    <input type="text" name="otp" required><br><br>

    <button type="submit">Verify OTP</button>
</form>
</div>
<script src="<%=request.getContextPath()%>/js/validation.js"></script>