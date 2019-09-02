package com.mhlab.codestyle.common.exceptions;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Jpa내에서 데이터를 못 찾을 때 발생한 예외
 *
 * Created by mhlab(dex) on 2018-12-17.
 */

@Getter
public class JpaDataNotFoundException extends CustomRuntimeException {
    @Getter(AccessLevel.NONE)
    private static final long serialVersionUID = 2787230264111535390L;

    private Object entityObj; //예외가 발생한 entity 클래스

    /**
     * 기본 생성자
     * @param message
     * @param targetObj
     * @param entityObj
     */
    public JpaDataNotFoundException(String message, Object targetObj, Object entityObj) {
        super(targetObj, message);
        this.entityObj = entityObj;
    }


}
