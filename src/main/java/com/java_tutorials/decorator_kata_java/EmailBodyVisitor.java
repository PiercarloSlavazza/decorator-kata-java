package com.java_tutorials.decorator_kata_java;

import com.java_tutorials.decorator_kata_java.impl.EmailBodyHtml;
import com.java_tutorials.decorator_kata_java.impl.EmailBodyPlainText;

public interface EmailBodyVisitor<T> {

    T visit(EmailBodyPlainText emailBodyPlainText);

    T visit(EmailBodyHtml emailBodyHtml);
}
