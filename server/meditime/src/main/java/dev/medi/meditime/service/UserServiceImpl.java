package dev.medi.meditime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.medi.meditime.model.dto.UserDTO;
import dev.medi.meditime.model.entity.User;
import dev.medi.meditime.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserPw(userDTO.getUserPw());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserBorn(userDTO.getUserBorn());
        user.setUserGender(userDTO.getUserGender());
        user.setRegDate(userDTO.getRegDate());

        userRepository.save(user);
    }
    
}
