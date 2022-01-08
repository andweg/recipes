package recipes.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,
                reason = "A user registered using the provided e-mail address already exists in the database.")
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException() {
    }

}
