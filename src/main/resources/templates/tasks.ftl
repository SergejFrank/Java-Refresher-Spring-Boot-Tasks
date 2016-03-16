<!DOCTYPE html>

<html lang="en">
<head>
<#include "head.ftl">
</head>
<body>


<div class="flex-row">
    <div class="col-md-6 flex">
        <div class="todolist not-done">
            <h1>Todos</h1>

        <#include "taskInputField.ftl">

        <#if addTaskError??>
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <span class="sr-only">Error:</span>
                ${addTaskError}
            </div>
        </#if>

            <ul class="list-unstyled task-items">

            <#list notDoneTasks?values as notDoneTask>
                <form action="/done" method="POST">
                    <li class="todo-task task">
                    ${notDoneTask.message}
                        <input type="hidden" name="id" value="${notDoneTask.id?c}">
                        <button type="submit" class="remove-item btn btn-default btn-xs pull-right"><span
                                class="glyphicon glyphicon-ok"></span>
                        </button>
                    </li>
                </form>
            </#list>
            </ul>
            <div class="todo-footer">
                <strong><span class="count-todos">${notDoneTasks?size}</span></strong> Tasks Left
            </div>
        </div>
    </div>


    <div class="col-md-6 flex">
        <div class="todolist">
            <h1>Already Done</h1>
            <ul class="list-unstyled task-items doneTasks">

            <#list doneTasks?values as doneTask>
                <form action="/del" method="POST">
                    <li class="done-task task">
                    ${doneTask.message}
                        <input type="hidden" name="id" value="${doneTask.id?c}">
                        <button type="submit" class="remove-item btn btn-default btn-xs pull-right"><span
                                class="glyphicon glyphicon-remove"></span>
                        </button>

                    </li>
                </form>
            </#list>
            </ul>
            <div class="todo-footer">
                <strong><span class="count-todos">${doneTasks?size}</span></strong> Tasks accomplished
            </div>
        </div>
    </div>

</div>

</body>
</html>