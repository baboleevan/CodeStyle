package com.mhlab.codestyle.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 계정 정보 담당 Repo 객체
 * Created by mhlab(dex) on 2019-09-02.
 */

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    /**
     * [로그인] 계정이 존재하는지 체크하는 메서드
     * @param id
     * @param enPw
     * @return
     */
    boolean existsByIdAndPassword(String id, String enPw);

    /**
     * [로그인] ID와 PW로 사용자 검색
     * @param id
     * @param enPw
     * @return
     */
    Optional<Account> findByIdAndPassword(String id, String enPw);



}
