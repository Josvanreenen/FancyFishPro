package nl.hu.bep.example.fancyfishpro.service;

import nl.hu.bep.example.fancyfishpro.model.MyUser;
import nl.hu.bep.example.fancyfishpro.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = repository.findByUsername(username);
        if (myUser==null){
            throw new UsernameNotFoundException(username);
        }
        return myUser;
    }
}
