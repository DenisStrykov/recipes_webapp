package ru.denis_strykov.recipes.web.mapper;

import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.models.Recipe;

import java.util.stream.Collectors;

import static ru.denis_strykov.recipes.web.mapper.EventMapper.mapToEventDto;

public class RecipeMapper {

    public static Recipe mapToRecipe(RecipeDto recipe) {
        Recipe recipeDto = Recipe.builder()
                .id(recipe.getId())
                .recipeTitle(recipe.getRecipeTitle())
                .photoUrl(recipe.getPhotoUrl())
                .recipeContent(recipe.getRecipeContent())
                .createdBy(recipe.getCreatedBy())
                .createdDateTime(recipe.getCreatedDateTime())
                .updateDateTime(recipe.getUpdateDateTime())
                .build();
        return recipeDto;
    }

    public static RecipeDto mapToRecipeDto(Recipe recipe) {
        RecipeDto recipeDto = RecipeDto.builder()
                .id(recipe.getId())
                .recipeTitle(recipe.getRecipeTitle())
                .photoUrl(recipe.getPhotoUrl())
                .recipeContent(recipe.getRecipeContent())
                .createdBy(recipe.getCreatedBy())
                .createdDateTime(recipe.getCreatedDateTime())
                .updateDateTime(recipe.getUpdateDateTime())
                .events(recipe.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return recipeDto;
    }

}