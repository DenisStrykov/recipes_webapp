package ru.denis_strykov.recipes.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.models.Recipe;
import ru.denis_strykov.recipes.web.repository.RecipeRepository;
import ru.denis_strykov.recipes.web.service.RecipeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {


    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeDto> findAllRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map((recipe) -> mapToRecipeDto(recipe)).collect(Collectors.toList());
    }

    private RecipeDto mapToRecipeDto(Recipe recipe) {
        RecipeDto recipeDto = RecipeDto.builder()
                .id(recipe.getId())
                .recipeTitle(recipe.getRecipeTitle())
                .photoUrl(recipe.getPhotoUrl())
                .recipeContent(recipe.getRecipeContent())
                .createdDateTime(recipe.getCreatedDateTime())
                .updateDateTime(recipe.getUpdateDateTime())
                .build();
        return recipeDto;
    }

}
