package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.*;

public class MailComposerWithEcoFriendlyFooter implements MailComposer, EmailBodyVisitor<EmailBody> {

    private static final String ECO_FRIENDLY_PLAIN_TEXT_FOOTER = "\n\nPlease, do not print this email.";
    private static final String ECO_FRIENDLY_HTML_FOOTER = "<br><i>Please, do not print this email.</i>";

    private final MailComposer mailComposer;

    public MailComposerWithEcoFriendlyFooter(MailComposer mailComposer) {
	this.mailComposer = mailComposer;
    }

    @Override public EmailBody visit(EmailBodyPlainText emailBodyPlainText) {
	return new EmailBodyPlainText(emailBodyPlainText.getRawBody() + ECO_FRIENDLY_PLAIN_TEXT_FOOTER);
    }

    @Override public EmailBody visit(EmailBodyHtml emailBodyHtml) {
	return new EmailBodyHtml(emailBodyHtml.getRawBody() + ECO_FRIENDLY_HTML_FOOTER);
    }

    @Override public Email composeEmail(MailBoxUser sender, EmailAddress receiver, EmailBody body) {
	Email email = mailComposer.composeEmail(sender, receiver, body);
	return new Email(email.getReceiver(), body.acceptEmailBodyVisitor(this), email.getDate());
    }
}
