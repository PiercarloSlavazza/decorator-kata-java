package com.java_tutorials.decorator_kata_java.impl;

import com.java_tutorials.decorator_kata_java.MailBoxLog;
import com.java_tutorials.decorator_kata_java.MailBoxLogs;

import java.util.ArrayList;
import java.util.List;

public class MailBoxLogsInMemory implements MailBoxLogs {

    private final List<MailBoxLog> mailBoxLogs = new ArrayList<>();

    @Override public List<MailBoxLog> listLogsForUser() {
	return new ArrayList<>(mailBoxLogs);
    }
}
