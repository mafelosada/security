package com.modelo.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.modelo.seguridad.DTO.ResponsesDTO;
import com.modelo.seguridad.DTO.UserDTO;
import com.modelo.seguridad.model.Roles;
import com.modelo.seguridad.model.Users;
import com.modelo.seguridad.repository.Irole;
import com.modelo.seguridad.repository.Iuser;


@Service
public class UserService {
  @Autowired
    private Iuser data;

    @Autowired
    private Irole roleRepository;

    public List<Users> findAll() {
        return data.findAll();
    }

    public Optional<Users> findById(int id) {
        return data.findById(id);
    }

    public Optional<Users> findByUsername(String username) {
        return data.findByUsername(username);
    }

    public ResponsesDTO deleteUser(int id) {
        Optional<Users> usuario = findById(id);
        if (!usuario.isPresent()) {
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "El usuario no existe");
        }

        data.deleteById(id);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Usuario eliminado correctamente");
    }

    public ResponsesDTO save(UserDTO userDTO) {
        Users usuario = convertToModel(userDTO);
        data.save(usuario);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Usuario guardado correctamente");
    }

    public ResponsesDTO updateUser(int id, UserDTO userDTO) {
        Optional<Users> usuario = findById(id);
        if (!usuario.isPresent()) {
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "El usuario no existe");
        }

        Users updatedUser = usuario.get();
        updatedUser.setUsername(userDTO.getUsername());
        updatedUser.setPassword(userDTO.getPassword());
        updatedUser.setEmail(userDTO.getEmail());
        updatedUser.setEnabled(userDTO.isEnabled());
        updatedUser.setRole(userDTO.getRole());

        data.save(updatedUser);
        return new ResponsesDTO(HttpStatus.OK.toString(), "Usuario actualizado correctamente");
    }

    public UserDTO convertToDTO(Users usuario) {
        return new UserDTO(
            usuario.getUserid(),
            usuario.getUsername(),
            usuario.getPassword(),
            usuario.getEmail(),
            usuario.getRole(),
            usuario.isEnabled()
        );
    }

    public Users convertToModel(UserDTO userDTO) {
        Roles rol = roleRepository.findById(userDTO.getRole().getRoleid())
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        return new Users(
            0,
            userDTO.getUsername(),
            userDTO.getPassword(),
            userDTO.getEmail(),
            userDTO.isEnabled(),
            rol
        );
    }
}
