package dev.medi.meditime.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.medi.meditime.model.dto.UserDTO;
import dev.medi.meditime.model.entity.User;
import dev.medi.meditime.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    // 회원가입
    @Override
    public void insertUser(UserDTO userDTO) {

        User user = new User();

        System.out.println("service 에 들어왔다 " + userDTO.getUserId());
        
        user.setUserId(userDTO.getUserId());
        user.setUserPw(userDTO.getUserPw());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserBorn(userDTO.getUserBorn());
        user.setUserGender(userDTO.getUserGender());
        user.setRegDate(userDTO.getRegDate());

        userRepository.save(user);
    }

    

    // 회원 정보 업데이트
    @Override
    public void updateUser(UserDTO userDTO) {
        System.out.println(userDTO.getUserId());
        System.out.println(userDTO.getUserPw());

        
        userRepository.findByUpdate(userDTO.getUserId(), userDTO.getUserPw());
        
        // if (userDTO.getUserPw() != user.getUserPw()) {
        //     user.setUserPw(userDTO.getUserPw());
        // } else {
        //     System.out.println("같은 비밀번호 입니다.");
        // }
        
        
        
        // user.ifPresent(selectUser -> {

        //     selectUser.setUserId(userDTO.getUserId());
        //     User newUser = userRepository.save(selectUser);
        //     System.out.println("user: " + newUser);
        // });



        

        // if (userDTO.getUserId() != null) {
        //     // update
        //     //user.updateId(userDTO.getUserId());
        //     userDTO.setUserId(userDTO.getUserId());
        // } else if (userDTO.getUserPw() != null) {
        //    // user.setUserPw(userDTO.getUserPw());
        // } else if (userDTO.getUserEmail() != null) {
        //     //user.setUserEmail(userDTO.getUserEmail());
        // } else if (userDTO.getUserBorn() != null) {
        //     //user.setUserBorn(userDTO.getUserBorn());
        // } else if (userDTO.getUserGender() != null) {
        //    // user.setUserGender(userDTO.getUserGender());
        // }

        
        // userRepository.save(user);
    }

    // 회원 정보 조회
    @Override
    public UserDTO selectUser(UserDTO userDTO) {
        System.out.println("받아온 User 아이디 : " + userDTO.getUserId());

        // DB  
        User user = userRepository.findByUserId(userDTO.getUserId());

        System.out.println(user.getUserEmail());

        UserDTO sUserDTO = new UserDTO();

        sUserDTO.setUserId(user.getUserId());
        sUserDTO.setUserPw(user.getUserPw());
        sUserDTO.setUserEmail(user.getUserEmail());
        sUserDTO.setUserBorn(user.getUserBorn());
        sUserDTO.setUserGender(user.getUserGender());
        
        return sUserDTO;

    }

    // 로그인
    @Override
    public String loginUser(UserDTO userDTO) {
        // 받아온 id/ pw 확인
        System.out.println(userDTO.getUserId());
        System.out.println(userDTO.getUserPw());
        // System.out.println(userDTO.getUserEmail()); 넘어 온 값이 없으니 null
        
        // repo 값 가져오기
        User user = userRepository.findByUserId(userDTO.getUserId());
        System.out.println(userDTO.getUserId() + "유저 비밀번호" + user.getUserPw());
        
        if(userDTO.getUserPw().equals(user.getUserPw())) {
            return "login success";
        } 
        
        return "login fail";
    }

    // 회원 탈퇴
    @Override
    public void deleteUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findById(userDTO.getUserId());

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });
    }

    
    
}

// @Override
// public String validateEmail(String email) {
//     System.out.println("받아온 이메일" + email);
 
//     User user = userRepository.findByUserEmail(email);
//     System.out.println("이메일" + user);

//     if (user ==null) {
//         return "suceess";
//     }

//     return "fail";
// }