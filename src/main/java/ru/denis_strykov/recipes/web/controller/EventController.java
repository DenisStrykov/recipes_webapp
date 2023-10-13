package ru.denis_strykov.recipes.web.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.Node;
import ru.denis_strykov.recipes.web.dto.EventDto;
import ru.denis_strykov.recipes.web.dto.RecipeDto;
import ru.denis_strykov.recipes.web.models.Event;
import ru.denis_strykov.recipes.web.service.EventService;

import java.util.List;

@Controller
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";
    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model) {
        EventDto eventDto = eventService.findByEventId(eventId);
        model.addAttribute("event", eventDto);
        return "events-detail";
    }

    @GetMapping("/events/{recipeId}/new")
    public String createEventForm(@PathVariable("recipeId") Long recipeId, Model model) {
        Event event = new Event();
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model) {
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @PostMapping("/events/{recipeId}")
    public String createEvent(@PathVariable("recipeId") Long recipeId, @ModelAttribute("event")EventDto eventDto,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", eventDto);
            return "recipes-create";
        }
        eventService.createEvent(recipeId, eventDto);
        return "redirect:/recipes/" + recipeId;
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId
            , @Valid @ModelAttribute("event") EventDto event
            , BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        EventDto eventDto = eventService.findByEventId(eventId);
        event.setId(eventId);
        event.setRecipe(eventDto.getRecipe());
        eventService.updateEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

}
