package com.hashlama.hackathon.api.job;

import java.util.Objects;

public class JobOfferRequest {

    private String offerJobUserId;
    private String details;
    private Integer price;

    public JobOfferRequest(String offerJobUserId, String details, Integer price) {
        this.offerJobUserId = offerJobUserId;
        this.details = details;
        this.price = price;
    }

    public String getOfferJobUserId() {
        return offerJobUserId;
    }

    public void setOfferJobUserId(String offerJobUserId) {
        this.offerJobUserId = offerJobUserId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobOfferRequest that = (JobOfferRequest) o;
        return Objects.equals(offerJobUserId, that.offerJobUserId) &&
                Objects.equals(details, that.details) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerJobUserId, details, price);
    }

    @Override
    public String toString() {
        return "JobOfferRequest{" +
                "offerJobUserId='" + offerJobUserId + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                '}';
    }
}
