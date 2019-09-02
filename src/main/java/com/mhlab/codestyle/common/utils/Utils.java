package com.mhlab.codestyle.common.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

public class Utils {

    /**
     * 암호화 처리 메서드
     * @param normalString
     * @return
     */
    public static String encryptStr(String normalString) {
        return BCrypt.hashpw(normalString, BCrypt.gensalt());
    }

    /**
     * 암호 검증을 처리하는 메서드
     * @param sendStr
     * @param targetStr
     * @return
     */
    public static boolean validEncryptStr(String sendStr, String targetStr) {
        return BCrypt.checkpw(sendStr, targetStr);
    }

}
