package jvaicekauskas.backend.back.service;

import jvaicekauskas.backend.back.model.User;
import jvaicekauskas.backend.back.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}


//package jvaicekauskas.backend.back.service;
//
//import jvaicekauskas.backend.back.model.User;
//import jvaicekauskas.backend.back.repository.UserRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    // Constructor injection (preferred over field injection)
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public User saveUser(User user) {
//        // Ensure password is hashed before saving, if applicable
//        return userRepository.save(user);
//    }
//
//    public Optional<User> findById(Long id) {
//        return userRepository.findById(id);
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public boolean deleteUser(Long id) {
//        if (userRepository.existsById(id)) {
//            userRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//
//    @Transactional
//    public Optional<User> updateUser(Long id, User updatedUser) {
//
//        return userRepository.findById(id).map(existingUser -> {
//
//            existingUser.setUsername(updatedUser.getUsername());
//            existingUser.setPassword(updatedUser.getPassword());  // Hash password before saving
//
//
//            existingUser.setRoles(updatedUser.getRoles());
//
//
//            return userRepository.save(existingUser);
//        });
//    }
////
//
////    public boolean existsByUsername(String username) {
////        return userRepository.findByUsername(username).isPresent();
////
////    }
//}
