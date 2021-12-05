package hu.uni.eku.tzs.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Characters {
    private int id;

    private String char_name;

    private String abbrev;

    private String description;
}
