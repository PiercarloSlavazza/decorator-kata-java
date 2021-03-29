package com.java_tutorials.decorator_kata_java;

import java.util.List;

public interface MailBoxLogs {

    void logEventForUser(MailBoxLog mailBoxLog);
    List<MailBoxLog> listLogsForUser();

}
