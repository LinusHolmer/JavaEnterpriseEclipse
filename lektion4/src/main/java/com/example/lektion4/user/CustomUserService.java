package com.example.lektion4.user;

import org.springframework.stereotype.Service;

@Service
public class CustomUserService {

    // replace this with repository implementation
    public CustomUser createNewCustomUser(CustomUser customUser) {



        // Error handling?
        // return

        return new CustomUser(
                customUser.getUsername(),
                customUser.getPassword()
        );
    }

    public static void mockRepository(){

    }

}
