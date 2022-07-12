package com.yawkar.marvelcatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "A hero entity")
public class HeroDTO {

    @Schema(description = "Internal identification number of an entity")
    private long id;
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

    public HeroDTO() {}

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<String> getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(List<String> superpowers) {
        this.superpowers = superpowers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
