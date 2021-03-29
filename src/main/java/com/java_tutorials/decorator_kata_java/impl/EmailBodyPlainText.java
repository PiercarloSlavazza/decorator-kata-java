package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.EmailBody;
import com.java_tutorials.decorator_kata_java.EmailBodyVisitor;

public class EmailBodyPlainText implements EmailBody {

    private final String plainTextBody;

    public EmailBodyPlainText(String plainTextBody) {
	this.plainTextBody = plainTextBody;
    }

    @Override public String getRawBody() {
	return plainTextBody;
    }

    @Override public <T> T acceptEmailBodyVisitor(EmailBodyVisitor<T> emailBodyVisitor) {
	return emailBodyVisitor.visit(this);
    }
}
