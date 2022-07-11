package com.yawkar.marvelcatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class HeroDTO {

    @JsonProperty("real_name")
    @NotBlank(message = "Name can't be blank or null")
    private String realName;
    @NotBlank(message = "Alias can't be blank or null")
    private String alias;
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
}
