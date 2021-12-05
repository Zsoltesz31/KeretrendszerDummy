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
public class WorksDto {
    private int id;

    @NotBlank(message="title can't be empty")
    private String title;

    @NotBlank(message="long_title can't be empty")
    private String long_title;

    @NotBlank(message="date can't be empty")
    private int date;

    @NotBlank(message="genre_type can't be empty")
    private String genre_type;
}
