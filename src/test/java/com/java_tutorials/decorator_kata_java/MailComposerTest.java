package com.java_tutorials.decorator_kata_java;

import com.java_tutorials.decorator_kata_java.impl.EmailBodyHtml;
import com.java_tutorials.decorator_kata_java.impl.EmailBodyPlainText;
import com.java_tutorials.decorator_kata_java.impl.MailComposerFactoryImpl;
import com.java_tutorials.decorator_kata_java.impl.MailBoxLogsInMemory;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.java_tutorials.decorator_kata_java.MailBoxLog.LOG_EVENT.COMPOSED_EMAIL;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class MailComposerTest {

    @SuppressWarnings("SameParameterValue") private Date buildDate(int year, int month, int dayOfMonth, int hour24h, int minutes) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.HOUR_OF_DAY, hour24h);
        calendar.set(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    @Test
    public void shouldReturnPlainTextEmail() {

        Date expectedDateOfEmail = buildDate(2021, Calendar.FEBRUARY, 1, 15, 1);
        MailComposer mailComposer = new MailComposerFactoryImpl(() -> expectedDateOfEmail).buildMailComposer();

        EmailAddress emailAddress = new EmailAddress("john@example.com");
        EmailBody emailBody = new EmailBodyPlainText("Lorem Ipsum.");
        Email expected = new Email(emailAddress, emailBody, expectedDateOfEmail);

        MailBoxUser mailBoxUser = new MailBoxUser("user_1");
        assertEquals(expected, mailComposer.composeEmail(mailBoxUser, emailAddress, emailBody));
    }

    @Test
    public void shouldReturnHtmlEmail() {

        Date expectedDateOfEmail = buildDate(2021, Calendar.FEBRUARY, 1, 15, 1);
        MailComposer mailComposer = new MailComposerFactoryImpl(() -> expectedDateOfEmail).buildMailComposer();

        EmailAddress emailAddress = new EmailAddress("john@example.com");
        EmailBody emailBody = new EmailBodyHtml("<h1>Lorem Ipsum.</h1>");
        Email expected = new Email(emailAddress, emailBody, expectedDateOfEmail);

        MailBoxUser mailBoxUser = new MailBoxUser("user_1");
        assertEquals(expected, mailComposer.composeEmail(mailBoxUser, emailAddress, emailBody));
    }

    @Test
    public void shouldAddEcoFriendlyFooterToPlainTextEmail() {

        Date expectedDateOfEmail = buildDate(2021, Calendar.FEBRUARY, 1, 15, 1);
        MailComposer mailComposer = new MailComposerFactoryImpl(() -> expectedDateOfEmail).buildMailComposer();

        EmailAddress emailAddress = new EmailAddress("john@example.com");
        String plainTextBody = "Lorem Ipsum.";
        EmailBody mailBody = new EmailBodyPlainText(plainTextBody);
        Email expected = new Email(emailAddress,
                                   new EmailBodyPlainText(plainTextBody + "\n\nPlease, do not print this email."),
                                   expectedDateOfEmail);

        MailBoxUser mailBoxUser = new MailBoxUser("user_1");
        assertEquals(expected, mailComposer.composeEmail(mailBoxUser, emailAddress, mailBody));
    }

    @Test
    public void shouldAddEcoFriendlyFooterToHtmlEmail() {

        Date expectedDateOfEmail = buildDate(2021, Calendar.FEBRUARY, 1, 15, 1);
        MailComposer mailComposer = new MailComposerFactoryImpl(() -> expectedDateOfEmail).buildMailComposer();

        EmailAddress emailAddress = new EmailAddress("john@example.com");
        String htmlBodyCode = "<h1>Lorem Ipsum.</h1>";
        EmailBody mailBody = new EmailBodyHtml(htmlBodyCode);
        Email expected = new Email(emailAddress,
                                   new EmailBodyHtml(htmlBodyCode + "<br><i>Please, do not print this email.</i>"),
                                   expectedDateOfEmail);

        MailBoxUser mailBoxUser = new MailBoxUser("user_1");
        assertEquals(expected, mailComposer.composeEmail(mailBoxUser, emailAddress, mailBody));
    }

    @Test
    public void shouldAddEcoFriendlyFooterAndRecordLog() {

        MailBoxLogs mailBoxLogs = new MailBoxLogsInMemory();

        Date expectedDateOfEmail = buildDate(2021, Calendar.FEBRUARY, 1, 15, 1);
        MailComposer mailComposer = new MailComposerFactoryImpl(() -> expectedDateOfEmail).buildMailComposer();

        EmailAddress emailAddress = new EmailAddress("john@example.com");
        String plainTextBody = "Lorem Ipsum.";
        EmailBody mailBody = new EmailBodyPlainText(plainTextBody);
        Email expected = new Email(emailAddress,
                                   new EmailBodyPlainText(plainTextBody + "\n\nPlease, do not print this email."),
                                   expectedDateOfEmail);

        /*
        Please note that we always want to have full control about time in tests:
        therefore, access to present time should be testable in classes under test.
         */
        Date expectedDateOfSaveEvent = buildDate(2021, Calendar.FEBRUARY, 1, 15, 2);
        MailBoxUser mailBoxUser = new MailBoxUser("user_1");
        MailBoxLog expectedMailBoxLog = new MailBoxLog(expected, expectedDateOfSaveEvent, COMPOSED_EMAIL, mailBoxUser);

        mailComposer.composeEmail(mailBoxUser, emailAddress, mailBody);

        assertEquals(singletonList(expectedMailBoxLog), mailBoxLogs.listLogsForUser());
    }
}
