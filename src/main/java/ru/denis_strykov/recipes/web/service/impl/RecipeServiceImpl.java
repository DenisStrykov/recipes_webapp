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

    @Override
    public Recipe saveRecipe(RecipeDto recipeDto) {
        Recipe recipe = mapToRecipe(recipeDto);
        return recipeRepository.save(recipe);
    }

    @Override
    public RecipeDto findRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        return mapToRecipeDto(recipe);
    }

    @Override
    public void updateRecipe(RecipeDto recipeDto) {
        Recipe recipe = mapToRecipe(recipeDto);
        recipeRepository.save(recipe);
    }

    @Override
    public void delete(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    @Override
    public List<RecipeDto> searchRecipes(String query) {
        List<Recipe> recipes = recipeRepository.searchRecipes(query);
        return recipes.stream().map(recipe -> mapToRecipeDto(recipe)).collect(Collectors.toList());
    }

    private Recipe mapToRecipe(RecipeDto recipe) {
        Recipe recipeDto = Recipe.builder()
                .id(recipe.getId())
                .recipeTitle(recipe.getRecipeTitle())
                .photoUrl(recipe.getPhotoUrl())
                .recipeContent(recipe.getRecipeContent())
                .createdDateTime(recipe.getCreatedDateTime())
                .updateDateTime(recipe.getUpdateDateTime())
                .build();
        return recipeDto;
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
