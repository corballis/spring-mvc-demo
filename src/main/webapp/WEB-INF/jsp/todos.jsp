<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="utf-8">

    <title>My Spring Todo Application</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.0.3/css/bootstrap.min.css" />

</head>

<body>

<div class="container">

    <div class="jumbotron text-center">
        <h1>Spring Todo Application</h1>
    </div>

    <div id="todo-list" class="row">
        <div class="col-sm-4 col-sm-offset-4">

            <div class="checkbox">
                <label>
                    <input type="checkbox">
                </label>
            </div>

        </div>
    </div>

    <div id="todo-form" class="row">
        <div class="col-sm-8 col-sm-offset-2 text-center">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control input-lg text-center" placeholder="Describe your todo">
                </div>
                <button type="submit" class="btn btn-primary btn-lg">Add</button>
            </form>
        </div>
    </div>

</div>

</body>
</html>