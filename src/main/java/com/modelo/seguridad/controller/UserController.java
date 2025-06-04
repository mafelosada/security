package com.modelo.seguridad.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.modelo.seguridad.DTO.ResponsesDTO;
import com.modelo.seguridad.DTO.UserDTO;
import com.modelo.seguridad.model.user;
import com.modelo.seguridad.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
     @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Object> saveUser(@RequestBody UserDTO userDTO) {
        ResponsesDTO response = userService.save(userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        Optional<user> usuario = userService.findById(id);
        if (!usuario.isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Object> getUserByUsername(@PathVariable String username) {
        Optional<user> usuario = userService.findByUsername(username);
        if (!usuario.isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        ResponsesDTO response = userService.deleteUser(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        ResponsesDTO response = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
