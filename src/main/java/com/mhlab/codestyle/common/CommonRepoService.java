package com.mhlab.codestyle.common;

/**
 * 공통 Repo Service
 * Created by mhlab(dex) on 2019-09-02.
 */

public interface CommonRepoService <T> {

    /**
     * idx로 값을 조회하는 메서드
     * @param idx
     * @return
     */
    T getDataByIdx(Long idx);

    /**
     * 데이터를 저장하는 메서드
     * @param t
     * @return
     */
    T saveData(T t);

    /**
     * 데이터를 수정하는 메서드
     * @param t
     * @return
     */
    T updateData(T t);

    /**
     * idx에 해당하는 데이터를 삭제하는 메서드
     * @param idx
     * @return
     */
    void deleteDataByIdx(Long idx);
}
