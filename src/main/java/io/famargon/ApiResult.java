package io.famargon;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * ApiResult
 */
@RegisterForReflection
public class ApiResult {

    private String result;
    private String error;

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static ApiResult success(String result) {
        ApiResult ar = new ApiResult();
        ar.setResult(result);
        return ar;
    }

}