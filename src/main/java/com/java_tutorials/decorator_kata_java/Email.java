package com.java_tutorials.decorator_kata_java;

import java.util.Date;
import java.util.Objects;

public class Email {

    private final EmailAddress receiver;
    private final EmailBody emailBody;
    private final Date date;

    public Email(EmailAddress receiver, EmailBody emailBody, Date date) {
	this.receiver = receiver;
	this.emailBody = emailBody;
	this.date = date;
    }

    public EmailBody getEmailBody() {
	return emailBody;
    }

    public Date getDate() {
	return date;
    }

    public EmailAddress getReceiver() {
	return receiver;
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Email email = (Email) o;
	return Objects.equals(receiver, email.receiver) && Objects.equals(emailBody, email.emailBody) && Objects.equals(date, email.date);
    }

    @Override public int hashCode() {
	return Objects.hash(receiver, emailBody, date);
    }

    @Override public String toString() {
	return "Email{" +
			"receiver=" + receiver +
			", emailBody=" + emailBody +
			", date=" + date +
			'}';
    }
}
