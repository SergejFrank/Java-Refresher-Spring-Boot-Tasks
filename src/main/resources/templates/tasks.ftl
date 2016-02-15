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

    <#include "taskInputField.ftl">

        <hr>
        <ul id="sortable" class="list-unstyled ui-sortable">

        <#list notDoneTasks as notDoneTask>
            <li class="ui-state-default">
                <div class="checkbox"><label>
                    <form action="/done" method="POST">
                        <input type="hidden" name="id" value="${notDoneTask.id}">
                        <button type="submit">Done</button>
                    </form>
                   ${notDoneTask.message}</label>
                </div>
            </li>
        </#list>
        </ul>
        <div class="todo-footer">
            <strong><span class="count-todos">${notDoneTasks?size}</span></strong> Items Left
        </div>
    </div>
</div>


<div class="col-md-6">
    <div class="todolist">
        <h1>Already Done</h1>
        <ul id="done-items" class="list-unstyled">

        <#list doneTasks as doneTask>
            <li>
            ${doneTask.message}
                <button class="remove-item btn btn-default btn-xs pull-right"><span
                        class="glyphicon glyphicon-remove"></span>
                </button>
            </li>
        </#list>


        </ul>
    </div>
</div>

</div>

</body>
</html>