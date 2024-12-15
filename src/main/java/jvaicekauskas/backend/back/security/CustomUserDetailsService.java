package jvaicekauskas.backend.back.security;

import jvaicekauskas.backend.back.model.User;
import jvaicekauskas.backend.back.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        userBuilder.password(user.getPassword());


        userBuilder.roles("USER");

        return userBuilder.build();
    }
}


//package jvaicekauskas.backend.back.security;
//
//
//import jvaicekauskas.backend.back.model.User;
//import jvaicekauskas.backend.back.service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    private final UserService userService;
//
//
//    public CustomUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//
//        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
//        userBuilder.password(user.getPassword());
//        userBuilder.roles("USER");
//
//        return userBuilder.build();
//    }
//}
