package com.java_tutorials.decorator_kata_java;

public interface MailComposer {

    Email composeEmail(MailBoxUser sender, EmailAddress receiver, EmailBody body);

}
