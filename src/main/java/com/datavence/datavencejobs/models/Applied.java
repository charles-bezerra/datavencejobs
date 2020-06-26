package com.datavence.datavencejobs.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_applied")
public class Applied implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String namedev;

    @NotNull
    private String emaildev;

    @NotNull
    private String phonedev;

    private String details;

    private String url_linkedin;

    @NotNull
    private String url_github;

    @NotNull
    private String english_level;

    @NotNull
    private String wage_claim;

    @NotNull
    private Long id_curriculum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamedev() {
        return namedev;
    }

    public void setNamedev(String namedev) {
        this.namedev = namedev;
    }

    public String getEmaildev() {
        return emaildev;
    }

    public void setEmaildev(String emaildev) {
        this.emaildev = emaildev;
    }

    public String getPhonedev() {
        return phonedev;
    }

    public void setPhonedev(String phonedev) {
        this.phonedev = phonedev;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUrl_linkedin() {
        return url_linkedin;
    }

    public void setUrl_linkedin(String url_linkedin) {
        this.url_linkedin = url_linkedin;
    }

    public String getUrl_github() {
        return url_github;
    }

    public void setUrl_github(String url_github) {
        this.url_github = url_github;
    }

    public String getEnglish_level() {
        return english_level;
    }

    public void setEnglish_level(String english_level) {
        this.english_level = english_level;
    }

    public String getWage_claim() {
        return wage_claim;
    }

    public void setWage_claim(String wage_claim) {
        this.wage_claim = wage_claim;
    }

    public Long getId_curriculum() {
        return id_curriculum;
    }

    public void setId_curriculum(Long id_curriculum) {
        this.id_curriculum = id_curriculum;
    }
}
