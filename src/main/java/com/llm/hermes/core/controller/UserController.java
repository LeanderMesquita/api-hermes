package com.llm.hermes.core.controller;

import com.llm.hermes.core.dto.UserDTO;
import com.llm.hermes.core.entity.Post;
import com.llm.hermes.core.entity.User;
import com.llm.hermes.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/view-all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = userService.findAll();
        List<UserDTO> userDTOList = userList.stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail())).toList();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user.getId(), user.getName(), user.getEmail()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        User createdUser = userService.create(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO, @PathVariable String id){
        User user = userService.fromDTO(userDTO);
        user.setId(id);
        User updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User user = userService.findById(id);
        return new ResponseEntity<>(user.getPosts(), HttpStatus.OK);
    }

}
