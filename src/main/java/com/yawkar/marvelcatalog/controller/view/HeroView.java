package com.yawkar.marvelcatalog.controller.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class HeroView {

    private long id;
    @JsonProperty("real_name")
    private String realName;
    private String alias;
    private List<String> superpowers;
}
