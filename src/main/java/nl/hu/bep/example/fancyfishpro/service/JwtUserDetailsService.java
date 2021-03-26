package nl.hu.bep.example.fancyfishpro.service;

import java.util.ArrayList;

import lombok.extern.log4j.Log4j2;
import nl.hu.bep.example.fancyfishpro.model.MyUser;
import nl.hu.bep.example.fancyfishpro.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("got here");
        MyUser toLogin = repository.findByUsername(username);
        if(toLogin!=null){
            log.info("user found");
            return new User(toLogin.getUsername(), toLogin.getPassword(),
                    new ArrayList<>());
        }
         else {
             log.warn("no user found!");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}