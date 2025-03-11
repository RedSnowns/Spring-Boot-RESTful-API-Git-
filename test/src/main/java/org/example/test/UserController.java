package org.example.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers() {
        List<User> users = userService.getAllUsers();
        Map<String, Object> data = new HashMap<>();
        data.put("users", users);
        ApiResponse response = new ApiResponse(true, "Users retrieved successfully", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user == null) {
            Map<String, Object> data = new HashMap<>();
            ApiResponse response = new ApiResponse(false, "User not found", data);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        ApiResponse response = new ApiResponse(true, "User retrieved successfully", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        Map<String, Object> data = new HashMap<>();
        data.put("user", createdUser);
        ApiResponse response = new ApiResponse(true, "User created successfully", data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser == null) {
            Map<String, Object> data = new HashMap<>();
            ApiResponse response = new ApiResponse(false, "User not found", data);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("user", updatedUser);
        ApiResponse response = new ApiResponse(true, "User updated successfully", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        Map<String, Object> data = new HashMap<>();
        if (deleted) {
            ApiResponse response = new ApiResponse(true, "User deleted successfully", data);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            ApiResponse response = new ApiResponse(false, "User not found", data);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
