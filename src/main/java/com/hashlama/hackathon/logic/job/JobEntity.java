package com.hashlama.hackathon.logic.job;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Document(collection = "Jobs")
public class JobEntity {

    private String id;
    private String userId;
    private String city;
    private String details;
    private Integer price;
    private String userPhoneNumber;
    private Boolean available;

    public JobEntity(String userId, String city, String details, Integer price, String userPhoneNumber, Boolean available) {
        this.userId = userId;
        this.city = city;
        this.details = details;
        this.price = price;
        this.userPhoneNumber = userPhoneNumber;
        this.available = available;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotBlank
    @Size(max = 40)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @NotBlank
    @Size(max = 40)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotBlank
    @Size(max = 40)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @NotBlank
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @NotBlank
    @Size(max = 40)
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
    @NotEmpty
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobEntity jobEntity = (JobEntity) o;
        return Objects.equals(id, jobEntity.id) &&
                Objects.equals(userId, jobEntity.userId) &&
                Objects.equals(city, jobEntity.city) &&
                Objects.equals(details, jobEntity.details) &&
                Objects.equals(price, jobEntity.price) &&
                Objects.equals(userPhoneNumber, jobEntity.userPhoneNumber) &&
                Objects.equals(available, jobEntity.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, city, details, price, userPhoneNumber, available);
    }

    @Override
    public String toString() {
        return "JobEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", city='" + city + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", available=" + available +
                '}';
    }
}
