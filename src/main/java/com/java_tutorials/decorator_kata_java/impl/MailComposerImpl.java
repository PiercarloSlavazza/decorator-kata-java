package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.*;

import java.util.Date;
import java.util.function.Supplier;

public class MailComposerImpl implements MailComposer {

    private final Supplier<Date> currentDateSupplier;

    public MailComposerImpl(Supplier<Date> currentDateSupplier) {
	this.currentDateSupplier = currentDateSupplier;
    }

    /*
    ☠️ DO NOT CHANGE THIS CLASS IN ANY WAY: all additional behaviours must be implemented via decorators.
     */
    @Override public synchronized Email composeEmail(MailBoxUser sender, EmailAddress receiver, EmailBody body) {
	return new Email(receiver, body, currentDateSupplier.get());
    }

}
