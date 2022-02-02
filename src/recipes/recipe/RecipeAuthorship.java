package recipes.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import recipes.user.UserDetailsImpl;

@Component("recipeAuthorship")
public class RecipeAuthorship {

    private final RecipeService recipeService;

    @Autowired
    public RecipeAuthorship(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public boolean isAuthor(long id, UserDetailsImpl userDetails) {
        return recipeService.findById(id)
                .getAuthor().getEmail()
                .equals(
                        userDetails.getUsername()
        );
    }
}
