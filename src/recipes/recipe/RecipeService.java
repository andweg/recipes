package recipes.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import recipes.user.UserDetailsImpl;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepo;

    @Autowired
    public RecipeService(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    public void updateById(Long id, Recipe newRecipe) {
        Recipe oldRecipe = findById(id);
        newRecipe.setId(oldRecipe.getId());
        newRecipe.setAuthor(oldRecipe.getAuthor());
        recipeRepo.save(newRecipe);
    }

    public void deleteById(long id) {
        recipeRepo.deleteById(id);
    }

    public long add(Recipe recipe) {
        recipe.setAuthor(((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                          .getUser());
        return recipeRepo.save(recipe).getId();
    }

    public Recipe findById(long id) {
        return recipeRepo.findById(id).orElseThrow(RecipeNotFoundException::new);
    }

    public List<Recipe> searchByName(String name) {
        return recipeRepo.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
    }

    public List<Recipe> searchByCategory(String category) {
        return recipeRepo.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
    }

    public List<Recipe> searchByNameAndCategory(String name, String category) {
        return recipeRepo.findAllByNameContainingIgnoreCaseAndCategoryIgnoreCaseOrderByDateDesc(name, category);
    }

}
