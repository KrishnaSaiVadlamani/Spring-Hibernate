<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
   <title>RockStar Company Home Page</title>
</head>

<body>

   <h2>RockStar Company Home Page - Yipeeee!!!!</h2>
   <hr>
   <p>
      Welcome to RockStar Company Home Page!!!
   </p>

   <!-- add logout button -->
   <form:form action="${pageContext.request.contextPath}/logout"
   method="POST">
   <input type="submit" value="Logout"/>
   </form:form>
</body>
</html>