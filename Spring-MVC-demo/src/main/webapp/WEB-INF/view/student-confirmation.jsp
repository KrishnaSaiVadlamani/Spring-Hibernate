<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Confirmation</title>

</head>

<body>
The Student is Confirmed : ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

FavoriteLanguage: ${student.favoriteLanguage}

<br><br>

Operating Systems :

<ul>
  <c:forEach var="temp" items="${student.operatingSystems}">
     <li>${temp}</li>
  </c:forEach>
</ul>


</body>
</html>