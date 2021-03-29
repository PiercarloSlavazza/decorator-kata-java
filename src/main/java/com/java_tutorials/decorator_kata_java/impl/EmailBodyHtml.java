package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.EmailBody;
import com.java_tutorials.decorator_kata_java.EmailBodyVisitor;

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
}
