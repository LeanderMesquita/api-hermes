package com.llm.hermes.core.service;


import com.llm.hermes.core.dto.UserDTO;
import com.llm.hermes.core.entity.User;
import com.llm.hermes.core.exception.ObjectNotFoundException;
import com.llm.hermes.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("The current user cannot be founded."));
    }

    public User create(User user){
        return userRepository.insert(user);
    }

    public User update(User user){
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    public void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .id(userDTO.getId())
                .build();
    }

}
