package com.xcy.wedding.pojo;

public class Address {
    private Integer id;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", log=" + log +
                ", lat=" + lat +
                '}';
    }

    private String log;

    private String lat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}