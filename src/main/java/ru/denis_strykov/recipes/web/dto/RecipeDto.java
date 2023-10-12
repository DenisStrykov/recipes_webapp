package ru.denis_strykov.recipes.web.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Builder
public class RecipeDto {

    private long id;
    @NotEmpty(message = "Название рецепта не должно быть пустым")
    private String recipeTitle;
    @NotEmpty(message = "Ссылка на фото не должна быть пустой")
    private String photoUrl;
    @NotEmpty(message = "Рецепт не должен быть пустым")
    private String recipeContent;
    private LocalDateTime createdDateTime;
    private LocalDateTime updateDateTime;

}
