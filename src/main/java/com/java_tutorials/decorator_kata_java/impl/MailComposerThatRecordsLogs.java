package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.*;

import java.util.Date;
import java.util.function.Supplier;

public class MailComposerThatRecordsLogs implements MailComposer {

    private final MailComposer mailComposer;
    private final MailBoxLogs mailBoxLogs;
    private final Supplier<Date> currentDate;

    public MailComposerThatRecordsLogs(MailComposer mailComposer, MailBoxLogs mailBoxLogs, Supplier<Date> currentDate) {
	this.mailComposer = mailComposer;
	this.mailBoxLogs = mailBoxLogs;
	this.currentDate = currentDate;
    }

    @Override public Email composeEmail(MailBoxUser sender, EmailAddress receiver, EmailBody body) {
        Email email = mailComposer.composeEmail(sender, receiver, body);
        MailBoxLog mailBoxLog = new MailBoxLog(email, currentDate.get(), MailBoxLog.LOG_EVENT.COMPOSED_EMAIL, sender);
        mailBoxLogs.logEventForUser(mailBoxLog);
	return email;
    }
}
