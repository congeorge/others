package com.george.accounts.services;

import com.george.accounts.entity.Customer;
import com.george.accounts.entity.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value ="loans" )
public interface LoansService {

    @RequestMapping(method = RequestMethod.GET, value="/loans",consumes = "application/json")
    public Iterable<Loans> getLoanInfo();
}
