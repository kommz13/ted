/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers;

import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.RoleMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class AccountManagementController {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Inject
    RoleMapper roleMapper;

    private static String hash(String originalString) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            return originalString;
        }
        byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public List createUser(RegisterDTO dto) throws UserValidationException {

        List errors = new ArrayList();

        User entity = userMapper.toEntity(dto);

        List<Role> roles = roleMapper.toEntities(dto);

        if (!userRepository.findByUserName(entity.getUsername()).isEmpty()) {
            errors.add("username already exists");
        }

        if (!userRepository.findByPhone(entity.getPhone()).isEmpty()) {
            errors.add("phone already exists");
        }

        if (!errors.isEmpty()) {
            throw new UserValidationException(errors);
        } else {
            
            entity.setPassword(hash(entity.getPassword()));

            userRepository.create(entity, roles);

            List l = new ArrayList();

            UserDTO dto_out = userMapper.toDTO(entity);

            l.add(dto_out);

            return l;
        }
    }

    public List viewUserByID(Integer id) {
        List<User> users = userRepository.find(id);

        List dtos = userMapper.profiletoDTO(users);

        return dtos;
    }

    public List editUser(int id, RegisterDTO dto) throws UserValidationException {
        List<User> users = userRepository.find(id);
        List errors = new ArrayList();

        if (users.isEmpty()) {
            errors.add("user does not exist");
            throw new UserValidationException(errors);
        }

        User thisUser = users.get(0);

////       
        if (!dto.getFirstname().isEmpty()) {
            thisUser.setFirstname(dto.getFirstname());
        }

        if (!dto.getLastname().isEmpty()) {
            thisUser.setLastname(dto.getLastname());
        }
        if (!dto.getPassword().isEmpty()) {
            thisUser.setPassword(dto.getPassword());
        }
        List<User> userWithPhone = userRepository.findByPhone(dto.getPhone());

        if (!dto.getPhone().isEmpty()) {
            if (!userWithPhone.isEmpty()) {
                errors.add("phone already exists");
                throw new UserValidationException(errors);
            }
            thisUser.setPhone(dto.getPhone());
        }

        List<User> userWithEmail = userRepository.findByEmail(dto.getEmail());

        if (!dto.getEmail().isEmpty()) {
            if (!userWithEmail.isEmpty()) {
                errors.add("E-mail already exists");
                throw new UserValidationException(errors);
            }
            thisUser.setEmail(dto.getEmail());
        }

//        if (dto.getEmail() != "") {
//            thisUser.setEmail(dto.getEmail());
//        }
////        if (!dto.getBirthdate().isEmpty) {
////            thisUser.setBirthdate(dto.getBirthdate());
////        }
//        if (!dto.getPhone().isEmpty()) {
//            thisUser.setPhone(dto.getPhone());
//        }
        if (!dto.getPhotoUrl().isEmpty()) {
            thisUser.setPhotoUrl(dto.getPhotoUrl());
        }
//        //is host/customer
//
        users = userRepository.update(thisUser);

        List dtos = userMapper.toDTO(users);

        return dtos;

    }
}
