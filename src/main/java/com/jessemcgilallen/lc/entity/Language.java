package com.jessemcgilallen.lc.entity;

import java.util.Set;

/**
 * Created by jessemcgilallen on 3/27/16.
 */
public class Language {

    private int id;
    private String name;
    private Set<Topic> topics;

    public Language() {

    }
    public Language(String name) {
        this.name = name;
    }

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


    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
