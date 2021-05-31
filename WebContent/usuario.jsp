<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Gestion de usuarios</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand">Gestion de usuarios </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Usuarios</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${usuario != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${usuario == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${usuario != null}">
                                    Editar usuario
                                </c:if>
                                <c:if test="${usuario == null}">
                                    agregar usuario
                                </c:if>
                            </h2>
                        </caption>
                        <c:if test="${usuario != null}">
                            <input type="hidden" name="id" value="<c:out value='${usuario.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Nombre de usuario</label> <input type="text" value="<c:out value='${usuario.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${usuario.email}' />" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Pais</label> <input type="text" value="<c:out value='${usuario.pais}' />" class="form-control" name="pais">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
        </html>