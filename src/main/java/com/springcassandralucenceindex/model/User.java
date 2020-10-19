package com.springcassandralucenceindex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.w3c.dom.Text;

import java.sql.Timestamp;


@Table("users")
public class User {

    @PrimaryKey
    private int id;
    private String name;
    private String body;
    private float latitude;
    private float longitude;
    private Timestamp time;
    private String user;

    public User() {
    }

    public User(int id, String name, String body, float latitude, float longitude, Timestamp time, String user) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.user = user;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", time=" + time +
                ", user='" + user + '\'' +
                '}';
    }
}
