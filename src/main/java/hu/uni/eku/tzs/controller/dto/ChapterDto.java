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
public class ChapterDto {
    private int id;

    @NotBlank(message = "act can't be empty")
    private int act;

    @NotBlank(message = "scene can't be empty")
    private int scene;

    @NotBlank(message = "description can't be empty")
    private String description;


    private int work_id;
}
