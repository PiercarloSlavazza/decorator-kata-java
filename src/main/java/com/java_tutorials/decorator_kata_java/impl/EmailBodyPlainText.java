package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.EmailBody;
import com.java_tutorials.decorator_kata_java.EmailBodyVisitor;

import java.util.Objects;

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

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	EmailBodyPlainText that = (EmailBodyPlainText) o;
	return Objects.equals(plainTextBody, that.plainTextBody);
    }

    @Override public int hashCode() {
	return Objects.hash(plainTextBody);
    }

    @Override public String toString() {
	return "EmailBodyPlainText{" +
			"plainTextBody='" + plainTextBody + '\'' +
			'}';
    }
}
