package com.example.Assignment.Pothis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiChangeEvent {
    @JsonProperty("page_title")
    public String pageTitle;

    @JsonProperty("performer")
    public Performer performer;

    @JsonProperty("meta")
    public Meta meta;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Performer {
        @JsonProperty("user_text")
        public String userText;

        @JsonProperty("user_is_bot")
        public boolean userIsBot;

        @JsonProperty("user_edit_count")
        public int userEditCount;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meta {
        @JsonProperty("domain")
        public String domain;
    }
}
