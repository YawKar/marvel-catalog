package com.yawkar.marvelcatalog.controller.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class HeroView {

    private long id;
    @JsonProperty("real_name")
    private String realName;
    private String alias;
    private List<String> superpowers;
}
