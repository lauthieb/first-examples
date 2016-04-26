package fr.lauthieb.business;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Book {

    private String title;
    private Integer price;

}
