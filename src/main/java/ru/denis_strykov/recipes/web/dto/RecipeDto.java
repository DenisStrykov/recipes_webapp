package ru.denis_strykov.recipes.web.dto;


import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Builder
public class RecipeDto {

    private long id;
    private String recipeTitle;
    private String photoUrl;
    private String recipeContent;
    private LocalDateTime createdDateTime;
    private LocalDateTime updateDateTime;

}
