package recipes.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.UpdateTimestamp;
import recipes.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Recipe {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name of the recipe cannot be empty!")
    private String name;

    @NotBlank(message = "You need to specify the recipe's category!")
    private String category;

    @UpdateTimestamp
    private LocalDateTime date;

    @NotBlank(message = "The description of the recipe cannot be empty!")
    private String description;

    @NotNull(message = "You need to list the ingredients!")
    @Size(min = 1, message = "There should be at least one ingredient listed!")
    @ElementCollection
    private List<String> ingredients;

    @NotNull(message = "You need to specify the directions!")
    @Size(min = 1, message = "There should be at least one step on the directions list!")
    @ElementCollection
    private List<String> directions;

    @JsonIgnore
    @ManyToOne
    private User author;

    public Recipe(Long id,
                  String name,
                  String category,
                  LocalDateTime date,
                  String description,
                  List<String> ingredients,
                  List<String> directions,
                  User author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        this.author = author;
    }

    public Recipe() {
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", directions=" + directions +
                ", author=" + author +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public User getAuthor() {
        return author;
    }
}
