package com.george.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.george.accounts.config.AccountsConfig;
import com.george.accounts.entity.*;
import com.george.accounts.repository.AccountsRepository;
import com.george.accounts.services.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountsController {
    @Autowired
    AccountsRepository repository;

    @Autowired
    AccountsConfig config;

    @Autowired
    LoansService loansService;

    @PostMapping (value = "/accounts")
    public Accounts getAccounts(@RequestBody Customer customer)
    {
        System.out.println("Calling repo with" +customer);
        Accounts accounts=repository.findByCustomerId(customer.getCustomerId());
        System.out.println("Received "+accounts);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

    @PostMapping (value = "/getall")
    public CustomerDetails getAllAccounts(@RequestBody Customer customer)
    {
        System.out.println("Calling repo with" +customer);
        Accounts accounts=repository.findByCustomerId(customer.getCustomerId());
        System.out.println("Received "+accounts);
        Iterable<Loans> loansIterable =loansService.getLoanInfo();
        ArrayList<Loans> list=new ArrayList<Loans>();
        for (Loans loans : loansIterable) {
            list.add(loans);
        }
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccounts(accounts);
        customerDetails.setLoansList(list);
        return customerDetails;
     /*
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }*/
    }



    @GetMapping(value = "/accounts/config")
    public String getConfig() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Properties prop = new Properties(config.getMsg(),config.getBuildVersion(),config.getMailDetails(),config.getActiveBranches());
        return ow.writeValueAsString(prop);
    }

}
