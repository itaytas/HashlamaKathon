package com.hashlama.hackathon.api.job;

import java.util.Objects;

public class TakeOfferRequest {

    private String InterestedInJobId;
    private String offeredJobId;

    public TakeOfferRequest(String interestedInJobId, String offeredJobId) {
        InterestedInJobId = interestedInJobId;
        this.offeredJobId = offeredJobId;
    }

    public String getInterestedInJobId() {
        return InterestedInJobId;
    }

    public void setInterestedInJobId(String interestedInJobId) {
        InterestedInJobId = interestedInJobId;
    }

    public String getOfferedJobId() {
        return offeredJobId;
    }

    public void setOfferedJobId(String offeredJobId) {
        this.offeredJobId = offeredJobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakeOfferRequest that = (TakeOfferRequest) o;
        return Objects.equals(InterestedInJobId, that.InterestedInJobId) &&
                Objects.equals(offeredJobId, that.offeredJobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(InterestedInJobId, offeredJobId);
    }

    @Override
    public String toString() {
        return "TakeOfferRequest{" +
                "InterestedInJobId='" + InterestedInJobId + '\'' +
                ", offeredJobId='" + offeredJobId + '\'' +
                '}';
    }
}
