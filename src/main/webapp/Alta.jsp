<%--
  Created by IntelliJ IDEA.
  User: ale57
  Date: 15/12/2022
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <!-- ACA VA EL NAVBAR  -->
    <%@include file="navbar.jsp" %>
    <div class="container">
        <section>
            <h1>Alta</h1>
            <!--  JSP -->
            <form method="post"
                  action="<%=request.getContextPath()%>/CreateController">
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">id-persona</label>
                    <input name="id-persona" type="int" class="form-control" id="exampleFormControlTextarea1" maxlength="7">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                    <input name="nombre"  type="varchar" class="form-control" id="exampleFormControlInput1" placeholder="Nombre" maxlength="50">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Apellido</label>
                    <input name="apellido" type="varchar" class="form-control" id="exampleFormControlTextarea1">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Im&aacute;gen</label>
                    <input name="edad" type="int" class="form-control" id="exampleFormControlTextarea1">
                </div>

                <button class="btn btn-primary">
                    Dar de alta
                </button>
            </form>
        </section>
    </div>
</main>
</body>
</html>
