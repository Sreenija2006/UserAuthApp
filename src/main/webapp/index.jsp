
<%@ page language="java" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="container">

    <h2>Welcome</h2>

    <a href="register.jsp"><button>Get Started</button></a>

    <div class="link">
        Already have account?
        <a href="<%=request.getContextPath()%>/login.jsp">Login</a>
    </div>

</div>