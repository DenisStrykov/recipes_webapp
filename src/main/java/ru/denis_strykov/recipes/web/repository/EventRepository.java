package ru.denis_strykov.recipes.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis_strykov.recipes.web.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
