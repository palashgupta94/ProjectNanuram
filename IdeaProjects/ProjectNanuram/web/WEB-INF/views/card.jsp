<%--
  Created by IntelliJ IDEA.
  User: Palash
  Date: 23-01-2021
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri ="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Card</title>

    <link rel="stylesheet" href="<c:url value="/resources/static/css/row.css" />">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto&display=swap" rel="stylesheet">


</head>
<body>

<section class="bg">
    <div class="container">
        <div class="form_bg">
            <form:form id="rowHelper" action="saveCard" method="post" modelAttribute="rowHelper">

                <div class="header_text">
                    Input Card
                </div>
                <div class="container-body">
                    <h5 class="card-title">Please enter the Number of Rows</h5>

                    <form:select path="numberofRows" class="form-select">
                        <form value="">Select</form>
                        <form:options items="${referenceData.rowMap}" />
                    </form:select>

                    <button type="submit" class="btn btn-primary">
                        submit
                    </button>
                </div>
            </form:form>
        </div>
        </form>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
</body>
</html>
