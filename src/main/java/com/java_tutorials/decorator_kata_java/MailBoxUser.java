package com.java_tutorials.decorator_kata_java;

import java.util.Objects;

public class MailBoxUser {

    private final String userId;

    public MailBoxUser(String userId) {
	this.userId = userId;
    }

    public String getUserId() {
	return userId;
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	MailBoxUser that = (MailBoxUser) o;
	return Objects.equals(userId, that.userId);
    }

    @Override public int hashCode() {
	return Objects.hash(userId);
    }

    @Override public String toString() {
	return "MailBoxUser{" +
			"userId='" + userId + '\'' +
			'}';
    }
}
