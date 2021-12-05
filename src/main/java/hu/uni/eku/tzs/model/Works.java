package hu.uni.eku.tzs.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Works {
    private int id;

    private String title;

    private String long_title;

    private int date;

    private String genre_type;

}
