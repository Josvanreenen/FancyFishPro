package nl.hu.bep.example.fancyfishpro.controller;

import lombok.extern.log4j.Log4j2;
import nl.hu.bep.example.fancyfishpro.config.JwtTokenUtil;
import nl.hu.bep.example.fancyfishpro.model.JwtRequest;
import nl.hu.bep.example.fancyfishpro.model.JwtResponse;
import nl.hu.bep.example.fancyfishpro.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@RestController
@CrossOrigin
@Log4j2
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping( "/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        log.info("yup, : "+authenticationRequest);
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        log.info("Got here!");
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            log.info("authenticate using: {},{}", username, password);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        catch (Exception e){
            log.warn(e.getMessage());
            throw e;
        }
    }
}