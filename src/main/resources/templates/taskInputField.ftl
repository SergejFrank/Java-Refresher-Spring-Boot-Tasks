<form action="/add" method="POST">
    <div class="input-group">
    <@spring.bind "newTask"/>
    <@spring.formInput "newTask.message", 'class="form-control add-todo"'/>
        <span class="input-group-btn">
        <button id="submit_button" class="btn btn-success" type="submit">Add Task</button>
      </span>
    </div>
</form>