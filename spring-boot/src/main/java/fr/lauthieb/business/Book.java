package fr.lauthieb.business;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private String title;
    private Integer price;

}
