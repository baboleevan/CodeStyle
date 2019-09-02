package com.mhlab.codestyle.common.exceptions;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by mhlab(dex) on 2019-05-20.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomRuntimeException extends RuntimeException {

    @Getter(AccessLevel.NONE)
    private static final long serialVersionUID = -5454752167947497760L;

    private Object targetObj; //에러 대상
    private String message; //에러 메세지

    @Builder
    public CustomRuntimeException(Object targetObj, String message) {
        this.targetObj = targetObj;
        this.message = message;
    }

}
