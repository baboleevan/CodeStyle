package com.mhlab.codestyle.common.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

@Getter
@Accessors(chain = true)
@ToString
public class JsonResult<T> {
    private boolean isSuccess;
    private String code;
    private String msg;
    private T data;

    //Json Deserialize 에서 필요하다.
    public JsonResult() { }

    @Builder
    public JsonResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.isSuccess = isSuccess();
    }

    /**
     * 현재 코드가 성공인지 실패인지 체크하는 메서드
     * @return
     */
    private boolean isSuccess() {
        if (this.code != null && this.code.split("-")[0].toUpperCase().equals("CS")) {
            this.isSuccess = true;
            return true;
        }
        this.isSuccess = false;
        return false;
    }

}
