package com.mhlab.codestyle.account.enums;

import java.util.Arrays;

/**
 * 사용자 타입
 * Created by mhlab(dex) on 2019-09-02.
 */

public enum Type {
    ROOT, //사이트 관리자

    ADMIN, //일반 관리자
    USER, //일반 사용자

    GUEST, //손님
    WAIT, //대기용
    ETC; //기타

    /**
     * 슈퍼 관리자인지 체크하는 메서드
     * @return
     */
    boolean isSuperUser() {
        return this.equals(ROOT);
    }

    /**
     * 일반 사용자인지 체크해주는 메서드
     * @return
     */
    boolean isNormalUser() {
        return Arrays.asList(ADMIN, USER).contains(this);
    }

    /**
     * 기타 사용자 인 경우
     * @return
     */
    boolean isEtcUser() {
        return Arrays.asList(GUEST, WAIT, ETC).contains(this);
    }

}
