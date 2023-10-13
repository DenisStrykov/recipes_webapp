package ru.denis_strykov.recipes.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis_strykov.recipes.web.dto.EventDto;
import ru.denis_strykov.recipes.web.models.Event;
import ru.denis_strykov.recipes.web.models.Recipe;
import ru.denis_strykov.recipes.web.repository.EventRepository;
import ru.denis_strykov.recipes.web.repository.RecipeRepository;
import ru.denis_strykov.recipes.web.service.EventService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.denis_strykov.recipes.web.mapper.EventMapper.mapToEvent;
import static ru.denis_strykov.recipes.web.mapper.EventMapper.mapToEventDto;

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

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }


}
