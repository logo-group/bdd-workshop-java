package com.lbs.test.steps;

import com.lbs.test.configuration.AppConfiguration;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import javafx.application.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@ContextConfiguration(classes = AppConfiguration.class)
public class CommonSteps {

    private TransactionStatus transactionStatus;

    @Autowired
    private ApplicationContext applicationContext;

    @Before(value = "@txn")
    public void startTxn(){
        transactionStatus = applicationContext.getBean(PlatformTransactionManager.class).getTransaction(new DefaultTransactionDefinition());
    }

    @After(value = "@txn")
    public void rollbackTxn(){
        applicationContext.getBean(PlatformTransactionManager.class).rollback(transactionStatus);
    }
}
