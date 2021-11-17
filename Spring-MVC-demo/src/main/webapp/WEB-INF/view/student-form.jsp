<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Student Registration Form</title>

</head>

<body>
<form:form action="processForm" modelAttribute="student">

First Name : <form:input path="firstName"/>
<br><br>
Last Name : <form:input path="lastName"/>
<br><br>


Country:
<form:select path="Country">
   <form:options items="${student.countryOptions}"/>
</form:select>


<br><br>

Favorite Language:

Java<form:radiobutton path="favoriteLanguage" value="Java"/>
C<form:radiobutton path="favoriteLanguage" value="C"/>
C++<form:radiobutton path="favoriteLanguage" value="C++"/>
PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
Python<form:radiobutton path="favoriteLanguage" value="Python"/>


<br><br>

Operating Systems :
Linux<form:checkbox path="operatingSystems" value="Linux"/>
Mac<form:checkbox path="operatingSystems" value="Mac"/>
Windows<form:checkbox path="operatingSystems" value="Windows"/>

<br><br>
<input type="submit" value="submit"/>

</form:form>

</body>
</html>