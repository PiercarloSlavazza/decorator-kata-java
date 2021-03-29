package com.java_tutorials.decorator_kata_java;

import java.util.Date;
import java.util.Objects;

public class MailBoxLog {

    public enum LOG_EVENT {
        SAVED_TO_DRAFT
    }

    private final Email email;
    private final Date dateOfEvent;
    private final LOG_EVENT logEvent;
    private final MailBoxUser mailBoxUser;

    public MailBoxLog(Email email, Date dateOfEvent, LOG_EVENT logEvent,
		      MailBoxUser mailBoxUser) {
	this.email = email;
	this.dateOfEvent = dateOfEvent;
	this.logEvent = logEvent;
	this.mailBoxUser = mailBoxUser;
    }

    public LOG_EVENT getLogEvent() {
	return logEvent;
    }

    public MailBoxUser getMailBoxUser() {
	return mailBoxUser;
    }

    public Email getPlainTextEmail() {
	return email;
    }

    public Date getDateOfEvent() {
	return dateOfEvent;
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	MailBoxLog that = (MailBoxLog) o;
	return Objects.equals(email, that.email) && Objects.equals(dateOfEvent, that.dateOfEvent) && logEvent == that.logEvent && Objects.equals(mailBoxUser, that.mailBoxUser);
    }

    @Override public int hashCode() {
	return Objects.hash(email, dateOfEvent, logEvent, mailBoxUser);
    }

    @Override public String toString() {
	return "MailBoxLog{" +
			"plainTextEmail=" + email +
			", dateOfEvent=" + dateOfEvent +
			", logEvent=" + logEvent +
			", mailBoxUser=" + mailBoxUser +
			'}';
    }
}
