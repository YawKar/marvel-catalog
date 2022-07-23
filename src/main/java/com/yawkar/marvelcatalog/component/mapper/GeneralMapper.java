package com.yawkar.marvelcatalog.component.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GeneralMapper {

    protected String listToTags(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String part : list) {
            sb.append(part).append('|');
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    protected List<String> tagsToList(String tags) {
        return Arrays.stream(tags.split("\\|")).collect(Collectors.toList());
    }
}
