package com.java_tutorials.decorator_kata_java;

public interface EmailBody {

    String getRawBody();
    <T> T acceptEmailBodyVisitor(EmailBodyVisitor<T> emailBodyVisitor);

}
