package main.java.com.atelier_jenkins.security;

import main.java.com.atelier_jenkins.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    CustomerService userDetailsService;

    UsernamePasswordAuthenticationToken auth ; ;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        auth = (UsernamePasswordAuthenticationToken) authentication;
        String name = auth.getName();
        String password = auth.getCredentials().toString();

        System.out.println("ici ?????############AUTHENTICATE########################");
        System.out.println(name);

        UserDetails user = userDetailsService.loadUserByUsername(name);
        if (user == null) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    public Object getPrincipal(){
        return auth.getPrincipal();
    }
}