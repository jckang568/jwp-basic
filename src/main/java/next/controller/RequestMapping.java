package next.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RequestMapping {
    private final Map<String, Controller> mappings = new HashMap<>();
    public void initMapping() {
        mappings.put("/", new HomeController());
        mappings.put("/user/form", new ForwardController("/user/form.jsp"));
        mappings.put("/users/loginForm", new ForwardController("/user/login.jsp"));
        mappings.put("/users", new ListUserController());
        mappings.put("/users/login", new LoginController());
        mappings.put("/users/profile", new ProfileController());
        mappings.put("/users/logout", new LogoutController());
        mappings.put("/users/create", new CreateUserController());
        mappings.put("/users/updateForm", new UpdateUserController());
        mappings.put("/users/update", new UpdateUserController());
        log.info("Initialized Request Mapping!");
    }
    public Controller findController(String url) {
        return mappings.get(url);
    }
    void put(String url, Controller controller) {
        mappings.put(url, controller);
    }
}
