<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
   <hr>
   <!-- display user name and role -->

   <p>
     User:<security:authentication property="principal.username"/>
     <br><br>
     Role(s):<security:authentication property="principal.authorities"/>
   </p>


   <security:authorize access="hasRole('Manager')">
   <!-- Add a link to point to/leaders....this is for managers -->

   <p>
      <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
      (Only for Manager Purpose)
   </p>

   </security:authorize>

  <security:authorize access="hasRole('Admin')">
   <!-- add link to point to /systems... only to admins -->
      <p>
         <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
         (Only for Admin Purpose)
      </p>
  </security:authorize>


   <hr>


   <!-- add logout button -->
   <form:form action="${pageContext.request.contextPath}/logout"
   method="POST">
   <input type="submit" value="Logout"/>
   </form:form>
</body>
</html>