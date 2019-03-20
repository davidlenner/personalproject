package com.lenner.personalprojectwithapis.models;

import javax.persistence.*;

@Entity
public class SpaceXData {

    @Id
    @GeneratedValue
    private Long id;
    private String missionName;
    private String launchDateLocal;
    private String payloadType;
    private String siteNameLong;
    @Lob
    private String details;
    private String rocketName;

    public SpaceXData() {
    }

    public SpaceXData(String missionName, String launchDateLocal, String payloadType,
                      String siteNameLong, String details, String rocketName) {
        this.missionName = missionName;
        this.launchDateLocal = launchDateLocal;
        this.payloadType = payloadType;
        this.siteNameLong = siteNameLong;
        this.details = details;
        this.rocketName = rocketName;
    }

    public Long getId() {
        return id;
    }

    public String getMissionName() {
        return missionName;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public String getDetails() {
        return details;
    }

    public String getRocketName() {
        return rocketName;
    }
}
