package ru.denis_strykov.recipes.web.mapper;

import ru.denis_strykov.recipes.web.dto.EventDto;
import ru.denis_strykov.recipes.web.models.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .photoUrl(eventDto.getPhotoUrl())
                .location(eventDto.getLocation())
                .tradition(eventDto.getTradition())
                .date(eventDto.getDate())
                .recipe(eventDto.getRecipe())
                .build();
    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .photoUrl(event.getPhotoUrl())
                .location(event.getLocation())
                .tradition(event.getTradition())
                .date(event.getDate())
                .recipe(event.getRecipe())
                .build();
    }

}