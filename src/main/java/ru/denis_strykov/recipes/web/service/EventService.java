package ru.denis_strykov.recipes.web.service;


import ru.denis_strykov.recipes.web.dto.EventDto;
import ru.denis_strykov.recipes.web.dto.RecipeDto;

import java.util.List;

public interface EventService {

    void createEvent(Long recipeId, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findByEventId(Long eventId);
    void updateEvent(EventDto eventDto);
}
