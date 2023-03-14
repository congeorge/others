package com.george.accounts.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Getter @Setter @ToString
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "loan_number", nullable = false)
    private Long loan_number;

    @Column(name = "customer_id", nullable = false)
    private Long customer_id;

    @Column(name = "start_dt", nullable = false)
    private Date start_dt;

    @Column(name = "loan_type", nullable = false)
    private String loan_type;

    @Column(name = "total_loan", nullable = false)
    private int total_loan;

    @Column(name = "amount_paid", nullable = false)
    private int amount_paid;

    @Column(name = "outstanding_amount", nullable = false)
    private int outstanding_amount;

    @Column(name = "create_dt", nullable = false)
    private String create_dt;


}
