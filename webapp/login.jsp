<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ocean View Resort - Login</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container-fluid login-bg d-flex justify-content-center align-items-center">

    <div class="card shadow-lg p-4 login-card">
        <h3 class="text-center mb-4">🏨 Ocean View Resort</h3>

        <% if (request.getParameter("error") != null) { %>
        <div class="alert alert-danger text-center">
            Invalid username or password!
        </div>
        <% } %>

        <form action="login" method="post">

            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" name="username" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Login</button>

        </form>
    </div>

</div>

</body>
</html>
