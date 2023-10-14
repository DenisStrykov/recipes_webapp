package ru.denis_strykov.recipes.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.models.Recipe;
import ru.denis_strykov.recipes.web.models.UserEntity;
import ru.denis_strykov.recipes.web.repository.RecipeRepository;
import ru.denis_strykov.recipes.web.repository.UserRepository;
import ru.denis_strykov.recipes.web.security.SecurityUtil;
import ru.denis_strykov.recipes.web.service.RecipeService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.denis_strykov.recipes.web.mapper.RecipeMapper.mapToRecipe;
import static ru.denis_strykov.recipes.web.mapper.RecipeMapper.mapToRecipeDto;

@Service
public class RecipeServiceImpl implements RecipeService {


    private RecipeRepository recipeRepository;
    private UserRepository userRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<RecipeDto> findAllRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map((recipe) -> mapToRecipeDto(recipe)).collect(Collectors.toList());
    }

    @Override
    public Recipe saveRecipe(RecipeDto recipeDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Recipe recipe = mapToRecipe(recipeDto);
        recipe.setCreatedBy(user);
        return recipeRepository.save(recipe);
    }

    @Override
    public RecipeDto findRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        return mapToRecipeDto(recipe);
    }

    @Override
    public void updateRecipe(RecipeDto recipeDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Recipe recipe = mapToRecipe(recipeDto);
        recipe.setCreatedBy(user);
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



}
