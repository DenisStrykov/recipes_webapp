package ru.denis_strykov.recipes.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private long id;
    private String name;
    private String photoUrl;
    private String location;
    private String tradition;
    private String date;

}
