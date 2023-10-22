package ru.denis_strykov.recipes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.denis_strykov.recipes.web.dto.EventDto;
import ru.denis_strykov.recipes.web.models.Event;
import ru.denis_strykov.recipes.web.models.UserEntity;
import ru.denis_strykov.recipes.web.security.SecurityUtil;
import ru.denis_strykov.recipes.web.service.EventService;
import ru.denis_strykov.recipes.web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventController {

    private EventService eventService;
    private UserService userService;

    @Autowired
    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    /**
     * Get method for view events-list page
     * @param model : model to add user & event
     * @return : events-list.html
     */
    @GetMapping("/events")
    public String eventList(Model model) {
        UserEntity user = new UserEntity();
        List<EventDto> events = eventService.findAllEvents();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("events", events);
        return "events-list";
    }

    /**
     * Get method for view event by id page
     * @param eventId : variable to get event by id
     * @param model : model to add user & event & recipe
     * @return : events-detail.html
     */
    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model) {
        UserEntity user = new UserEntity();
        EventDto eventDto = eventService.findByEventId(eventId);
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("recipe", eventDto);
        model.addAttribute("user", user);
        model.addAttribute("event", eventDto);
        return "events-detail";
    }

    /**
     * Get method for view event create form page
     * @param recipeId : variable to get recipe by id
     * @param model : model to add recipeId & event
     * @return : events-create.html
     */
    @GetMapping("/events/{recipeId}/new")
    public String createEventForm(@PathVariable("recipeId") Long recipeId, Model model) {
        Event event = new Event();
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("event", event);
        return "events-create";
    }

    /**
     * Get method for view event edit form page
     * @param eventId :  variable to get event by id
     * @param model : model to add event
     * @return : events-edit.html
     */
    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model) {
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    /**
     * Post method to create event
     * @param recipeId : variable to get recipe by id
     * @param eventDto : class variable to create event
     * @param result : variable Errors class for check err exists
     * @param model : model to add event
     * @return : redirect to recipes.html if request success
     */
    @PostMapping("/events/{recipeId}")
    public String createEvent(@PathVariable("recipeId") Long recipeId, @ModelAttribute("event") EventDto eventDto,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", eventDto);
            return "recipes-create";
        }
        eventService.createEvent(recipeId, eventDto);
        return "redirect:/recipes/" + recipeId;
    }

    /**
     * Post method to update event
     * @param eventId :  variable to get event by id
     * @param event : class variable to update event
     * @param result : variable Errors class for check err exists
     * @param model : model to add event
     * @return : redirect to events.html if request success
     */
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

    /**
     * Get method for delete event
     * @param eventId : variable to get event by id
     * @return : redirect to events.html
     */
    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

}