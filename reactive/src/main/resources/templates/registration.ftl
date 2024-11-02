<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Реєстрація</title>
</head>
<body>
<h1>Реєстрація</h1>
<form action="/register" method="post">
    <label for="username">Логін:</label>
    <input type="text" id="username" name="username" required><br><br>
    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password" required><br><br>
    <label for="firstName">Ім'я:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>
    <label for="lastName">Прізвище:</label>
    <input type="text" id="lastName" name="lastName" required><br><br>
    <label for="phone">Телефон:</label>
    <input type="text" id="phone" name="phone" required><br><br>
    <input type="submit" value="Зареєструватися">
</form>
</body>
</html>
