package com.lenner.personalprojectwithapis.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    @Lob
    private String explanation;
    @Nullable
    private String mediaType;
    @Nullable
    private String serviceVersion;
    @Nullable
    private String title;
    @Nullable
    private String url;

    public Picture(){
    }

    public Picture(String date, String explanation,
                   String mediaType, String serviceVersion, String title, String url) {
        this.date = date;
        this.explanation = explanation;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
