package com.hashlama.hackathon.api.job;

import java.util.Objects;

public class TakeOfferRequest {

    private String interestedInJobId;
    private String offeredJobId;

    public TakeOfferRequest(String interestedInJobId, String offeredJobId) {
        this.interestedInJobId = interestedInJobId;
        this.offeredJobId = offeredJobId;
    }

    public String getInterestedInJobId() {
        return this.interestedInJobId;
    }

    public void setInterestedInJobId(String interestedInJobId) {
        this.interestedInJobId = interestedInJobId;
    }

    public String getOfferedJobId() {
        return this.offeredJobId;
    }

    public void setOfferedJobId(String offeredJobId) {
        this.offeredJobId = offeredJobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakeOfferRequest that = (TakeOfferRequest) o;
        return Objects.equals(interestedInJobId, that.interestedInJobId) &&
                Objects.equals(offeredJobId, that.offeredJobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interestedInJobId, offeredJobId);
    }

    @Override
    public String toString() {
        return "TakeOfferRequest{" +
                "InterestedInJobId='" + interestedInJobId + '\'' +
                ", offeredJobId='" + offeredJobId + '\'' +
                '}';
    }
}
