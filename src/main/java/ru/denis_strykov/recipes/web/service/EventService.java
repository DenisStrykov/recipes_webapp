package ru.denis_strykov.recipes.web.service;


import ru.denis_strykov.recipes.web.dto.EventDto;

public interface EventService {

    void createEvent(Long recipeId, EventDto eventDto);

}
