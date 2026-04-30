<%@ page language="java" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="container">

    <h2>Home Page</h2>

    <%
        String user = (String) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
        }
    %>

    <p>Welcome: <b><%= user %></b></p>

    <a href="logout"><button>Logout</button></a>

</div>