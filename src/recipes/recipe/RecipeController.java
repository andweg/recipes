package recipes.recipe;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RestController
@Validated
@RequestMapping("/api/recipe/")
class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recipe getRecipe(@PathVariable long id) {
        return recipeService.findById(id);
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> addRecipe(@Valid @RequestBody Recipe recipe) {
        return Map.of("id", recipeService.add(recipe));
    }

    @PutMapping("{id}")
    @PreAuthorize("@recipeAuthorship.isAuthor(#id, principal)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRecipe(@Valid @RequestBody Recipe recipe,
                             @PathVariable long id) {
        recipeService.updateById(id, recipe);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("@recipeAuthorship.isAuthor(#id, principal)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable long id) {
        recipeService.deleteById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> search(@RequestParam(required = false) String name,
                                               @RequestParam(required = false) String category) {
        if (name == null && category == null) {
            return ResponseEntity.status(400).build();
        }
        List<Recipe> searchResults;
        if (name == null) {
            searchResults = recipeService.searchByCategory(category);
        } else if (category == null) {
            searchResults = recipeService.searchByName(name);
        } else {
            searchResults = recipeService.searchByNameAndCategory(name, category);
        }
        return ResponseEntity.status(200).body(searchResults);
    }

}