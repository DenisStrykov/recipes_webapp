package ru.denis_strykov.recipes.web.service;

import ru.denis_strykov.recipes.web.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    List<RecipeDto> findAllRecipe();

}
