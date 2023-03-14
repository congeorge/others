package com.george.accounts.repository;

import com.george.accounts.entity.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts,Long>
{

    Accounts findByCustomerId(int customerid);


}
