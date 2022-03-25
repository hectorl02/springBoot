package com.hectorl.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("ingres met printWithDependency");
        int num = 1;
        LOGGER.debug("el # como param es " + num);
        System.out.println(myOperation.sum(num));
        System.out.println("implem de un bean con dependencia");
    }
}
