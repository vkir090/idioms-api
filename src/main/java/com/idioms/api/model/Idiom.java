package com.idioms.api.model;

import jakarta.persistence.*;

@Entity @Table(name = "idioms")
public class Idiom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private String meaning;
    private String example;
    @Column(nullable = false)
    private int frequency;
    public Idiom() { }

    public long getId() {
        return id;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }

    public String getText() {
        return text;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setText(String text) {
        this.text = text;
    }
}
