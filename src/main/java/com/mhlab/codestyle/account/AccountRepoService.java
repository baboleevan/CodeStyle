package com.mhlab.codestyle.account;

import com.mhlab.codestyle.common.CommonRepoService;
import com.mhlab.codestyle.common.exceptions.JpaDataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

@Transactional
public class AccountRepoService implements CommonRepoService<Account> {

    @Autowired private AccountRepo accountRepo;


    /////////////////////////
    //      Count
    /////////////////////////

    /**
     * 현재 사용자 전체 카운트를 가져오는 메서드
     * @return
     */
    public long countByAllUser() {
        return accountRepo.count();
    }


    /////////////////////////
    //      Get
    /////////////////////////

    /**
     * 사용자 계정 idx로 데이터를 조회하는 메서드
     * @param idx
     * @return
     */
    @Override
    public Account getDataByIdx(Long idx) {
        return null;
    }

    /**
     * 사용자 계정 ID로 데이터를 조회하는 메서드
     * @param id
     * @return
     */
    public Account getDataById(String id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new JpaDataNotFoundException("User id not found.", this, Account.class));
    }


    /////////////////////////
    //      Exist
    /////////////////////////

    /**
     * 전달된 계정 id가 존재하는지 체크하는 메서드
     * @param id
     * @return
     */
    boolean isExistId(String id) {
        return accountRepo.existsById(id);
    }


    /////////////////////////
    //      Save
    /////////////////////////

    @Override
    public Account saveData(Account account) {
        return accountRepo.save(account);
    }

    /////////////////////////
    //      Update
    /////////////////////////

    @Override
    public Account updateData(Account account) {
        return accountRepo.saveAndFlush(account);
    }

    /////////////////////////
    //      Delete
    /////////////////////////

    @Override
    public void deleteDataByIdx(Long idx) {
        accountRepo.deleteById(idx);
    }
}
