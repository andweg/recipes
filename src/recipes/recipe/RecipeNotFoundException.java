package recipes.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Requested recipe does not exist in the database.")
public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException() {
    }

}
