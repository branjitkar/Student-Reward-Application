package edu.miu.AuthorizationServer.securityconfig;

import edu.miu.AuthorizationServer.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@EnableFeignClients
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserFeignClient userFeignClient;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userFeignClient.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toUpperCase()));
        return new User(user.getUserName(), user.getPassword(), authorities);
    }

    @FeignClient("UserService")
    public interface UserFeignClient {
        @GetMapping("/users")
        public List<UserDTO> getAllUser();

        @GetMapping("/users/{userName}")
        UserDTO getUser(@PathVariable String userName);
    }
}
