package Com.ttn.Services.ServiceClasses;


import Com.ttn.Domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Com.ttn.Services.ServiceInterfaces.UserService;

import java.util.ArrayList;
import java.util.List;

@Service("cutomeUserDetailsService")

public class cutomeUserDetailsService implements UserDetailsService{


        @Autowired
        private UserService userService;

        @Transactional(readOnly=true)
        public UserDetails loadUserByUsername(String email)
                throws UsernameNotFoundException {
            User user = userService.findBySso(email);

            System.out.println("User : "+user);
            if(user==null){
                System.out.println("User not found");
                throw new UsernameNotFoundException("Email not found");
            }

            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                    user.isEnabled(), true, true, true, getGrantedAuthorities(user));
        }
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        private List<GrantedAuthority> getGrantedAuthorities(User user){

            authorities.add(new SimpleGrantedAuthority(user.getAuthorities()));

            System.out.println(user.getAuthorities());
            System.out.print("authorities :"+authorities);
            return authorities;
        }


    }
