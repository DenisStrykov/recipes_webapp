package ru.denis_strykov.recipes.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis_strykov.recipes.web.models.Recipe;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findByRecipeTitle(String url);

}
