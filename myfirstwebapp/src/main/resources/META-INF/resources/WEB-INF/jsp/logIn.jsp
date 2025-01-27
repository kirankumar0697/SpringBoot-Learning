<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<title> LogIn Page</title>
	</head>
	<body>
		<div class="container">
			<h2>Welcome to the Login page!</h2>
			<pre>${invalidCred}</pre>
			<form method="post">
				name: <input type="text" name="name"/>
				password: <input type="password" name="password"/>
				<input type="submit"/>
			</form>
		</div>
	</body>
</html>