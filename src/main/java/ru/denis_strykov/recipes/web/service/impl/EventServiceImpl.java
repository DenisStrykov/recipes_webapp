package ru.denis_strykov.recipes.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis_strykov.recipes.web.dto.EventDto;
import ru.denis_strykov.recipes.web.models.Event;
import ru.denis_strykov.recipes.web.models.Recipe;
import ru.denis_strykov.recipes.web.repository.EventRepository;
import ru.denis_strykov.recipes.web.repository.RecipeRepository;
import ru.denis_strykov.recipes.web.service.EventService;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private RecipeRepository recipeRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, RecipeRepository recipeRepository) {
        this.eventRepository = eventRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void createEvent(Long recipeId, EventDto eventDto) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        Event event = mapToEvent(eventDto);
        event.setRecipe(recipe);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .photoUrl(eventDto.getPhotoUrl())
                .location(eventDto.getLocation())
                .tradition(eventDto.getTradition())
                .date(eventDto.getDate())
                .build();
    }

}
