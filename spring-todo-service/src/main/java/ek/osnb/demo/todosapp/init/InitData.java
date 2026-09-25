package ek.osnb.demo.todosapp.init;

import ek.osnb.demo.todosapp.todo.CreateTodoRequest;
import ek.osnb.demo.todosapp.todo.TodoService;
import ek.osnb.demo.todosapp.user.AddressRequest;
import ek.osnb.demo.todosapp.user.CreateUserRequest;
import ek.osnb.demo.todosapp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class InitData implements CommandLineRunner {
    private final UserService userService;
    private final TodoService todoService;

    InitData(UserService userService, TodoService todoService) {
        this.userService = userService;
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userService.findAll().isEmpty()) {
            return;
        }
        createUsers();
        createTodos();
    }

    void createUsers() {
        var u1 = new CreateUserRequest(
                "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                new AddressRequest("Kulas Light", "Gwenborough", "92998-3874", "USA")
        );

        var u2 = new CreateUserRequest(
                "Ervin Howell",
                "Antonette",
                "Shanna@melissa.tv",
                new AddressRequest("Victor Plains", "Wisokyburgh", "90566-7771", "USA")
        );

        var u3 = new CreateUserRequest(
                "Clementine Bauch",
                "Samantha",
                "Nathan@yesenia.net",
                new AddressRequest("Douglas Extension", "McKenziehaven", "59590-4157", "USA")
        );

        var u4 = new CreateUserRequest(
                "Patricia Lebsack",
                "Karianne",
                "Julianne.OConner@kory.org",
                new AddressRequest("Hoeger Mall", "South Elvis", "53919-4257", "USA")
        );

        var u5 = new CreateUserRequest(
                "Chelsey Dietrich",
                "Kamren",
                "Lucio_Hettinger@annie.ca",
                new AddressRequest("Skiles Walks", "Roscoeview", "33263", "USA")
        );

        var u6 = new CreateUserRequest(
                "Mrs. Dennis Schulist",
                "Leopoldo_Corkery",
                "Karley_Dach@jasper.info",
                new AddressRequest("Norberto Crossing", "South Christy", "23505-1337", "USA")
        );

        var u7 = new CreateUserRequest(
                "Kurtis Weissnat",
                "Elwyn.Skiles",
                "Telly.Hoeger@billy.biz",
                new AddressRequest("Rex Trail", "Howemouth", "58804-1099", "USA")
        );

        var u8 = new CreateUserRequest(
                "Nicholas Runolfsdottir V",
                "Maxime_Nienow",
                "Sherwood@rosamond.me",
                new AddressRequest("Ellsworth Summit", "Aliyaview", "45169", "USA")
        );

        var u9 = new CreateUserRequest(
                "Glenna Reichert",
                "Delphine",
                "Chaim_McDermott@dana.io",
                new AddressRequest("Dayna Park", "Bartholomebury", "76495-3109", "USA")
        );

        var u10 = new CreateUserRequest(
                "Clementina DuBuque",
                "Moriah.Stanton",
                "Rey.Padberg@karina.biz",
                new AddressRequest("Kattie Turnpike", "Lebsackbury", "31428-2261", "USA")
        );

        List<CreateUserRequest> users = List.of(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10);

        users.forEach(userService::create);
    }

    void createTodos() {
        var t1 = new CreateTodoRequest("Finish project documentation", 1L);
        var t2 = new CreateTodoRequest("Review pull request from backend team", 1L);

        var t3 = new CreateTodoRequest("Prepare slides for Monday meeting", 2L);
        var t4 = new CreateTodoRequest("Book dentist appointment", 2L);

        var t5 = new CreateTodoRequest("Buy groceries for the weekend", 3L);
        var t6 = new CreateTodoRequest("Update profile information", 3L);

        var t7 = new CreateTodoRequest("Send invoice to client", 4L);
        var t8 = new CreateTodoRequest("Plan next sprint", 4L);

        var t9 = new CreateTodoRequest("Clean up old Git branches", 5L);
        var t10 = new CreateTodoRequest("Renew software subscription", 5L);

        var t11 = new CreateTodoRequest("Schedule annual health check", 6L);
        var t12 = new CreateTodoRequest("Finish reading Clean Code", 6L);

        var t13 = new CreateTodoRequest("Deploy new version to staging", 7L);
        var t14 = new CreateTodoRequest("Investigate login timeout issue", 7L);

        var t15 = new CreateTodoRequest("Create monthly expense report", 8L);
        var t16 = new CreateTodoRequest("Organize team lunch", 8L);

        var t17 = new CreateTodoRequest("Backup important documents", 9L);
        var t18 = new CreateTodoRequest("Update dependencies", 9L);

        var t19 = new CreateTodoRequest("Write integration tests for user API", 10L);
        var t20 = new CreateTodoRequest("Refactor notification service", 10L);

        List<CreateTodoRequest> todos = List.of(
                t1, t2, t3, t4, t5, t6, t7, t8, t9, t10,
                t11, t12, t13, t14, t15, t16, t17, t18, t19, t20
        );

        todos.forEach(todoService::create);
    }
}
