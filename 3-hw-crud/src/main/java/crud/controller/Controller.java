package crud.controller;

import crud.entity.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class Controller {
    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") Long id) {
        User userFromDB = userService.read(id);
        if (userFromDB == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userFromDB);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@PathVariable(name = "id") Long id, @RequestBody User user) {
        User updatedUser = userService.update(user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedUser);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> delete(@PathVariable(name = "id") Long id) {
        if (userService.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
