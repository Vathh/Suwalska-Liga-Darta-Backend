package pl.liga.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(UserController.USER)
public class UserController {

    public static final String USER = "/user";

    @GetMapping
    public UserDTO getUsers(){
        return userService.findUsers().stream()
                .map(userMapper::map).toList();
    }

    @PostMapping
    public ResponseEntity<?> addUser(
            @Valid @RequestBody UserDTO userDTO
    ){
        userService.addUser(userDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(
            @RequestParam("userId") Integer userId
    ){
        try{
            userService.deleteUser(userId);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
