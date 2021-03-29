package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.MailBoxLogs;
import com.java_tutorials.decorator_kata_java.MailComposer;
import com.java_tutorials.decorator_kata_java.MailComposerFactory;

import java.util.Date;
import java.util.function.Supplier;

public class MailComposerWithEcoFriendlyFooterAndLogsFactory implements MailComposerFactory {

    private final MailComposerFactory mailComposerFactory;
    private final MailBoxLogs mailBoxLogs;
    private final Supplier<Date> currentDate;

    public MailComposerWithEcoFriendlyFooterAndLogsFactory(MailComposerFactory mailComposerFactory,
							   MailBoxLogs mailBoxLogs, Supplier<Date> currentDate) {
	this.mailComposerFactory = mailComposerFactory;
	this.mailBoxLogs = mailBoxLogs;
	this.currentDate = currentDate;
    }

    @Override public MailComposer buildMailComposer() {
	return new MailComposerThatRecordsLogs(mailComposerFactory.buildMailComposer(), mailBoxLogs, currentDate);
    }
}
