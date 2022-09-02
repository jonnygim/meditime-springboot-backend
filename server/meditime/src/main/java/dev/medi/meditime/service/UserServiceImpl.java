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
        
        user.setUserId(userDTO.getUserId());
        user.setUserPw(userDTO.getUserPw());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserBorn(userDTO.getUserBorn());
        user.setUserGender(userDTO.getUserGender());
        user.setRegDate(userDTO.getRegDate());

        userRepository.save(user);

    }

    // 닉네임 변경
    @Override
    public void updateUserId(UserDTO userDTO) {
        System.out.println(userDTO.getUserId());

        User user = new User();
        if(userRepository.findByUserEmail(userDTO.getUserEmail()) != null) {
            user = User.builder()
                    .userEmail(userDTO.getUserEmail())
                    .userId(userDTO.getUserId())
                    .regDate(userDTO.getRegDate())
                    .build();
        }

        userRepository.save(user);
    }

    // 비밀번호 변경
    @Override
    public void updateUserPassword(UserDTO userDTO){

        User userSave = userRepository.findByUserEmail(userDTO.getUserEmail());

        userSave.setUserPw(userDTO.getUserPw());

        userRepository.save(userSave);
    }

    // 회원 정보 조회
    @Override
    public UserDTO selectUser(String userId) {
        System.out.println("받아온 User 아이디 : " + userId);

        // DB  
        User user = userRepository.findByUserId(userId);

        UserDTO sUserDTO = new UserDTO();

        sUserDTO.setUserId(user.getUserId());
        sUserDTO.setUserPw(user.getUserPw());
        sUserDTO.setUserEmail(user.getUserEmail());
        sUserDTO.setUserBorn(user.getUserBorn());
        sUserDTO.setUserGender(user.getUserGender());
        sUserDTO.setRegDate(user.getRegDate());
        
        return sUserDTO;

    }

    @Override
    public Boolean validateUserId(String userId) {
        System.out.println("받아온 아이디" + userId);
    
        try {
            User dbUserId = userRepository.findByUserId(userId);

            if (dbUserId.getUserId().equals(userId) && !userId.isEmpty()) {
                System.out.println("DB아이디 : " + dbUserId.getUserId());

                return true;
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("error: " + e); // 다른 항목들 null 값이라서 
        }

        return false;
    }


    // 로그인
    @Override
    public Boolean loginUser(UserDTO userDTO) {
        // 받아온 id/ pw 확인
        System.out.println(userDTO.getUserId());
        System.out.println(userDTO.getUserPw());
        // System.out.println(userDTO.getUserEmail()); 넘어 온 값이 없으니 null
        
        // repo 값 가져오기
        try {
            User user = userRepository.findByUserId(userDTO.getUserId());
            System.out.println(userDTO.getUserId() + "유저 비밀번호" + user.getUserPw());

            if(userDTO.getUserPw().equals(user.getUserPw())) {
                return true;
            } 
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("error : " + e);
        }
        
        return false;
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

