# Recipes
Multi-user web service for storing cooking recipes.

## Endpoints
* ```GET /api/register``` user signup
* ```GET /api/recipe/{id}``` returns the recipe with the specified id
* ```POST /api/recipe/new``` adds a new recipe to the database
* ```PUT /api/recipe/{id}``` updates an existing recipe; only accessible for the original author of the recipe
* ```DELETE /api/recipe/{id}``` removes an existing recipe; only accessible for the original author of the recipe
* ```GET /api/recipe/search?name={n}&category={c}``` searches for recipes by name and/or category, returns a list

## Sources
This application was created as a graduate project for the [JetBrains Academy](https://www.jetbrains.com/academy/)'s Java Backend track.
