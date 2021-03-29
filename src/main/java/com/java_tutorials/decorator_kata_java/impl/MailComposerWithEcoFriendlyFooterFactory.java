package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.MailComposer;
import com.java_tutorials.decorator_kata_java.MailComposerFactory;

public class MailComposerWithEcoFriendlyFooterFactory implements MailComposerFactory {

    private final MailComposerFactory mailBoxFactory;

    public MailComposerWithEcoFriendlyFooterFactory(MailComposerFactory mailBoxFactory) {
	this.mailBoxFactory = mailBoxFactory;
    }

    @Override public MailComposer buildMailComposer() {
	return new MailComposerWithEcoFriendlyFooter(mailBoxFactory.buildMailComposer());
    }

}
