package hu.uni.eku.tzs.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParagraphsDto {

    private int id;

    @NotBlank(message="paragraphNum can't be empty")
    private int paragraph_num;

    @NotBlank(message="PlainText can't be empty")
    private String plain_text;

    private int character_id;

    private int chapter_id;
}
