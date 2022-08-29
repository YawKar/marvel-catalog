package com.yawkar.marvelcatalog.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class HeroDTO {

    @Schema(example = "Clark Kent")
    @JsonProperty("real_name")
    @NotBlank(message = "Name can't be blank or null")
    private String realName;

    @Schema(example = "Superman")
    @NotBlank(message = "Alias can't be blank or null")
    private String alias;

    @Schema(example = "[Laser beam eyes, Super strength]")
    @NotNull(message = "The superpowers list can't be null")
    private List<String> superpowers;
}
