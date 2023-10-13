package ru.denis_strykov.recipes.web.dto;


import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

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
    private List<EventDto> events;

}
