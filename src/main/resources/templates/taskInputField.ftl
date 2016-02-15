<#import "/spring.ftl" as spring/>
<form action="" method="POST">
<@spring.bind "newTask"/>

    <@spring.formInput "newTask.message", 'class="form-control add-todo"'/>
    <input type="submit" class="btn btn-success" value="Add todo"/>
</form>