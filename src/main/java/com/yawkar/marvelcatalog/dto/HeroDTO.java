package com.yawkar.marvelcatalog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class HeroDTO {

    @NotBlank
    private String realName;
    @NotBlank
    private String alias;
    @NotNull
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
