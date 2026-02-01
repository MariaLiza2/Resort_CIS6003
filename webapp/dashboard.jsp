<%@ page import="com.oceanview.model.User" %>
<%
    User user = (User) session.getAttribute("loggedUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h2>Welcome, <%= user.getUsername() %></h2>
<p>Role: <%= user.getRole() %></p>

<a href="logout">Logout</a>

</body>
</html>
