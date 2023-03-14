package com.george.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.george.accounts.config.CardsConfig;
import com.george.accounts.model.Loans;
import com.george.accounts.model.Properties;
import com.george.accounts.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository repository;

    @Autowired
   private CardsConfig config;

    @GetMapping(value = "/loans")
   public Iterable<Loans> giveLoanInfo()
   {
       ArrayList<Loans> loanslist=new ArrayList<Loans>();
      Iterable<Loans> loansIterable= repository.findAll();
       loansIterable.forEach(loan->loanslist.add(loan));
       return loanslist;
   }


    @GetMapping(value = "/loans/config")
    public String getConfig() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Properties prop = new Properties(config.getMsg(),config.getBuildVersion(),config.getMailDetails(),config.getActiveBranches());
        return ow.writeValueAsString(prop);
    }
}
