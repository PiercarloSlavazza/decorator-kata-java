package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.EmailBody;
import com.java_tutorials.decorator_kata_java.EmailBodyVisitor;

import java.util.Objects;

public class EmailBodyHtml implements EmailBody {

    private final String htmlBody;

    public EmailBodyHtml(String htmlBody) {
	this.htmlBody = htmlBody;
    }

    @Override public String getRawBody() {
	return htmlBody;
    }

    @Override public <T> T acceptEmailBodyVisitor(EmailBodyVisitor<T> emailBodyVisitor) {
	return emailBodyVisitor.visit(this);
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	EmailBodyHtml that = (EmailBodyHtml) o;
	return Objects.equals(htmlBody, that.htmlBody);
    }

    @Override public int hashCode() {
	return Objects.hash(htmlBody);
    }

    @Override public String toString() {
	return "EmailBodyHtml{" +
			"htmlBody='" + htmlBody + '\'' +
			'}';
    }
}
