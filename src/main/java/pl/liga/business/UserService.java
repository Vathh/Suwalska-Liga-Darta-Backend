//package pl.liga.business;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Slf4j
//@Service
//@AllArgsConstructor
//public class UserService {
//
//    private final UserDAO userDAO;
//    private final RoleDAO roleDAO;
//    private final PasswordEncoder passwordEncoder;
//
//    @Transactional
//    public List<User> findAll(){
//        return userDAO.findAll();
//    }
//
//    @Transactional
//    public void addUser(UserDTO userDTO){
//        UserDTO userToAdd = userDTO.withPassword(passwordEncoder.encode(userDTO.getPassword()));
//
//        User user = User.builder()
//                .userName(userToAdd.getUserName())
//                .password(userToAdd.getPassword())
//                .roles(userDTO.getRoles().stream().map(role -> roleDAO.findRole(role).get()).toList())
//                .active(true)
//                .build();
//
//        userDAO.addUser(user);
//    }
//
//    @Transactional
//    public void deleteUser(Integer userId){
//        userDAO.deleteUser(userId);
//    }
//}
