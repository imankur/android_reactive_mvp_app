package com.ankur.mvp.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Ankur Jain (ankurjainips@gmail.com)
 */
public class QuestionResponse {
    @SerializedName("items")
    private List<Question> questions;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("quota_max")
    private int quotaMax;

    @SerializedName("quota_remaining")
    private int quotaRemaining;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(int quotaMax) {
        this.quotaMax = quotaMax;
    }

    public int getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(int quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }
}
