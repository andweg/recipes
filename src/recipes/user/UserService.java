package recipes.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepo,
                       PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public void add(User user) {
        if (userRepo.existsById(user.getEmail())) {
            throw new UserAlreadyExistsException();
        } else {
            user.setPassword(
                    encoder.encode(user.getPassword())
            );
            userRepo.save(user);
        }
    }
}
