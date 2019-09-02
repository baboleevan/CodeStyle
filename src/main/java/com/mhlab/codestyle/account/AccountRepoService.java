package com.mhlab.codestyle.account;

import com.mhlab.codestyle.common.CommonRepoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Created by mhlab(dex) on 2019-09-02.
 */

@Transactional
public class AccountRepoService implements CommonRepoService<Account> {

    @Autowired private AccountRepo accountRepo;


    /////////////////////////
    //      Login 관련
    /////////////////////////

    AccountDto.LoginResult login(AccountDto.Login dto) {
        return null;
    }


    /////////////////////////
    //      Count
    /////////////////////////

    /**
     * 현재 사용자 전체 카운트를 가져오는 메서드
     * @return
     */
    long countByAllUser() {
        return accountRepo.count();
    }


    /////////////////////////
    //      Get
    /////////////////////////

    @Override
    public Account getDataByIdx(Long idx) {
        return null;
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
