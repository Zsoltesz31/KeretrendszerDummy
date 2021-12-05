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
public class CharactersDto {
    private int id;

    @NotBlank(message="CharName can't be empty")
    private String char_name;

    @NotBlank(message="CharName can't be empty")
    private String abbrev;

    @NotBlank(message="Description can't be empty")
    private String description;


}
