package com.yawkar.marvelcatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "A hero entity")
@Data
@NoArgsConstructor
public class HeroDTO {

    @Schema(description = "The real name of a hero", example = "Clark Kent")
    @JsonProperty("real_name")
    @NotBlank(message = "Name can't be blank or null")
    private String realName;
    @Schema(description = "The alias of a hero", example = "Superman")
    @NotBlank(message = "Alias can't be blank or null")
    private String alias;
    @Schema(description = "Superpowers of a hero", example = "['Laser beam eyes', 'Super strength']")
    @NotNull(message = "The superpowers list can't be null")
    private List<String> superpowers;
}
