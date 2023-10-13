package ru.denis_strykov.recipes.web.service;


import ru.denis_strykov.recipes.web.dto.EventDto;

import java.util.List;

public interface EventService {

    void createEvent(Long recipeId, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findByEventId(Long eventId);
}
