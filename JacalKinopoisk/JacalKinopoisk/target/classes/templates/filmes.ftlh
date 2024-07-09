<!DOCTYPE html>
<html>
<head>
    <title> JacalKinopoisk </title>
</head>
<body>

<h1>Jacal Kinopoisk</h1>
<hr>
<h4>Фильмы кинопоиска</h4>
<form action="/" method="get">
    Поиск фильма по названию: <input type="text" name="name"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list films as film>
    <div>
        <p>
            <b>
                ${film.name}
            </b>
            ${film.description} | <a href="/film/${film.id}">Подробнее</a>
        </p>
    </div>
    <h3> Фильмы отсутствуют <h3>
</#list>
</body>
</html>