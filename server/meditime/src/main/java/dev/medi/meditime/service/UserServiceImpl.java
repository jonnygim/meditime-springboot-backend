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
        System.out.println("service 에 들어왔다 " + userDTO.getUserEmail());
        
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

        userRepository.findByUpdate(userDTO.getUserId(), userDTO.getUserPw());
        
    }

    // 회원 정보 조회
    @Override
    public UserDTO selectUser(UserDTO userDTO) {
        System.out.println("받아온 User 아이디 : " + userDTO.getUserId());

        // DB  
        User user = userRepository.findByUserId(userDTO.getUserId());

        UserDTO sUserDTO = new UserDTO();

        sUserDTO.setUserId(user.getUserId());
        sUserDTO.setUserPw(user.getUserPw());
        sUserDTO.setUserEmail(user.getUserEmail());
        sUserDTO.setUserBorn(user.getUserBorn());
        sUserDTO.setUserGender(user.getUserGender());
        
        return sUserDTO;

    }

    @Override
    public Boolean validateUserId(UserDTO userDTO) {
        System.out.println("받아온 아이디" + userDTO.getUserId());
    
        try {
            User dbUserId = userRepository.findByUserId(userDTO.getUserId());

            if (dbUserId.getUserId().equals(userDTO.getUserId()) && !userDTO.getUserId().isEmpty()) {
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

