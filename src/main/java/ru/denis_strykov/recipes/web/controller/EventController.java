package ru.denis_strykov.recipes.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.Node;
import ru.denis_strykov.recipes.web.dto.EventDto;
import ru.denis_strykov.recipes.web.models.Event;
import ru.denis_strykov.recipes.web.service.EventService;

@Controller
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events/{recipeId}/new")
    public String createEventForm(@PathVariable("recipeId") Long recipeId, Model model) {
        Event event = new Event();
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @PostMapping("/events/{recipeId}")
    public String createEvent(@PathVariable("recipeId") Long recipeId, @ModelAttribute("event")EventDto eventDto, Model model) {
        eventService.createEvent(recipeId, eventDto);
        return "redirect:/recipes/" + recipeId;
    }

}
