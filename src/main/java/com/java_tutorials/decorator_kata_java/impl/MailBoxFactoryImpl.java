package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.MailComposer;
import com.java_tutorials.decorator_kata_java.MailBoxFactory;

import java.util.Date;
import java.util.function.Supplier;

/*
👉🏻 Please consider that different factories might be used in order to build different instances of the MailBox interface:
generally speaking, the code who is in charge to instantiate the MailBox should receive an instance of MailBoxFactory.
 */
public class MailBoxFactoryImpl implements MailBoxFactory {

    private final Supplier<Date> currentDateSupplier;

    public MailBoxFactoryImpl(Supplier<Date> currentDateSupplier) {
	this.currentDateSupplier = currentDateSupplier;
    }

    @Override public MailComposer openMailBox() {
	return new MailComposerImpl(currentDateSupplier);
    }
}
