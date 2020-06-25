package com.datavence.datavencejobs.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="tb_applied")
public class Applied {
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

    private String url_linkdin;

    @NotNull
    private String url_github;

    @NotNull
    private String english_level;

    @NotNull
    private String wage_claim;

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

    public String getUrl_linkdin() {
        return url_linkdin;
    }

    public void setUrl_linkdin(String url_linkdin) {
        this.url_linkdin = url_linkdin;
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
}
