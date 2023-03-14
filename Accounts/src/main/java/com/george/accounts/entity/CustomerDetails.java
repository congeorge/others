package com.george.accounts.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter@Setter@ToString
public class CustomerDetails {
    private Accounts accounts;
    private List<Loans> loansList;

}
