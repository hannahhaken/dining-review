package com.hannahhaken.dining_review.dto;

public class AdminReviewAction {

    private Long reviewId;
    private boolean isAccepted;

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
