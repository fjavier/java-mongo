<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fruit Picker</title>
</head>
<body>
    <form action="/favorite-fruit" method="POST">
        <p>What is your Favorite Fruit</p>
        <#list fruits as fruit>
                <input type="radio" name="fruit" value="${fruit}">
                    <p>${fruit}</p>
                </input>
        </#list>
        <input type="submit" value="Submit">
    </form>
</body>
</html>