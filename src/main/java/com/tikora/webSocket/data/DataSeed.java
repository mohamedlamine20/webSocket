package com.tikora.webSocket.data;



import com.tikora.webSocket.models.Role;
import com.tikora.webSocket.models.User;
import com.tikora.webSocket.models.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataSeed implements CommandLineRunner {

    private final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
//     User user= new User();
//     user.setEmail("mbounab@wissalgroup.com");
//     user.setPassword(passwordEncoder.encode("123"));
//     user.setRole(Role.ADMIN);
//     userRepository.save(user);
    }
}
