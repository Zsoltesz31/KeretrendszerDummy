package hu.uni.eku.tzs.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paragraphs {
    private int id;

    private int paragraph_num;

    private String plain_text;

    private int chracater_id;

    private int chapter_id;
}
