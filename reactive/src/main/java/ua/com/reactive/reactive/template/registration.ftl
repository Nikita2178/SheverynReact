<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1> Form Registration </h1>
<script>
    function sendData() {
        const data = {
            username: document.querySelector('input[name="username"]').value,
            password: document.querySelector('input[name="password"]').value,
        };
        fetch(
            '/registration',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data) // {"username": "Vasya", "password": "1234"}
            }
        )
            .then(response => {
                    response.json()
                    if (response.ok) {
                        window.location.href = "/login";
                    } else {
                        response.json().then(errorData=> {
                            console.log("Err", errorData);
                        })
                    }
                }
            )
            .catch(err=> console.log(err));
    }
</script>
<form onsubmit="sendData(); return false;">
    <input type="text" name="username" id="username">
    <input type="text" name="password" id="password">
    <input type="submit" value="add">
</form>
</body>
</html>