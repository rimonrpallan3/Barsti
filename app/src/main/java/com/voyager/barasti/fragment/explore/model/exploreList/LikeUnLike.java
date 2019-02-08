package com.voyager.barasti.fragment.explore.model.exploreList;

/**
 * Created by User on 08-Feb-19.
 */

public class LikeUnLike {

    String status;
    Boolean error;
    String error_status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getError_status() {
        return error_status;
    }

    public void setError_status(String error_status) {
        this.error_status = error_status;
    }
}
