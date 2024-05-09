<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session</title>
</head>
<body>
    <h1>Session Object Handling</h1>

    <form action="session" method="post">
        <table>
            <tr>
                <td>firstName : </td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>lastName : </td>
                <td><input type="text" name="lastName"></td>
            <tr>
                <td colspan="2">
                    <button type="submit">Send</button>
                </td>
            </tr>

        </table>
        <hr>
        <p>
            <a href="delete">delete Session data</a>
        <p>
    </form>
</body>
</html>