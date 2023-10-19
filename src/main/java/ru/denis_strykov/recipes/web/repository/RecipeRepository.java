package ru.denis_strykov.recipes.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.denis_strykov.recipes.web.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findByRecipeTitle(String url);

    @Query("SELECT c from Recipe c WHERE c.recipeTitle LIKE CONCAT('%', :query, '%')")
    List<Recipe> searchRecipes(String query);

}