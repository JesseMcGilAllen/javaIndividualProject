package com.jessemcgilallen.lc.entity;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by jessemcgilallen on 4/29/16.
 */
public class Topic {


    private int id;
    private String name;
    private String description;
    private String videoURL;
    private Type type;
    private Set<Language> languages;
    private Set<Example> examples;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public void addLanguage(Language language) {
        if (languages == null) {
            languages = new HashSet<Language>();
        }

        if (languages.contains(language)) {
            return;
        }

        languages.add(language);
    }

    public Set<Example> getExamples() {
        return examples;
    }

    public void setExamples(Set<Example> examples) {
        this.examples = examples;
    }
}
