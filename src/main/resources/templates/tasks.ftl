<!DOCTYPE html>

<html lang="en">
<head>
<#include "bootstrap.ftl">
    <link href="/css/tasks.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="col-md-6">
    <div class="todolist not-done">
        <h1>Todos</h1>
        <input type="text" class="form-control add-todo" placeholder="Add todo">
        <button id="checkAll" class="btn btn-success">Mark all as done</button>

        <hr>
        <ul id="sortable" class="list-unstyled ui-sortable">


            <li class="ui-state-default">
                <div class="checkbox"><label><input type="checkbox" value="">TASK1</label></div>
            </li>
            <li class="ui-state-default">
                <div class="checkbox"><label><input type="checkbox" value="">TASK1</label></div>
            </li>
            <li class="ui-state-default">
                <div class="checkbox"><label><input type="checkbox" value="">TASK1</label></div>
            </li>
            <li class="ui-state-default">
                <div class="checkbox"><label><input type="checkbox" value="">TASK1</label></div>
            </li>
        </ul>
        <div class="todo-footer">
            <strong><span class="count-todos">4</span></strong> Items Left
        </div>
    </div>
</div>


<div class="col-md-6">
    <div class="todolist">
        <h1>Already Done</h1>
        <ul id="done-items" class="list-unstyled">
            <li>Some item
                <button class="remove-item btn btn-default btn-xs pull-right"><span class="glyphicon glyphicon-remove"></span>
                </button>
            </li>

        </ul>
    </div>
</div>

</div>


</html>