<#import "/spring.ftl" as spring/>
<form action="" method="POST">
<@spring.bind "newTask"/>

<@spring.formInput "newTask.message"/>
    <input type="submit" value="submit"/>
</form>