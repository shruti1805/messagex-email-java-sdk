/**
 * This has all the test cases and examples to send mails.
 * @author shruti.sinha
 *
 */
package com.messageX.test;

        import java.io.IOException;
        import com.messageX.mail.builder.*;
        import org.junit.Assert;
        import org.junit.Test;
        import com.messageX.mail.formatter.Mail;
        import junit.framework.TestCase;
/**
 * <br>
 * It includes all the test cases for Email Builder. Email Builder has objects to build an email.<br><br>
 * It uses the below classes to build and format it.    <br><br>
 *     Content - text as plain or html                      <br>
 *     Add recipients in "to", "cc" or in "bcc"             <br>
 *     Add multiple recipients in "to", "cc" or in "bcc"    <br>
 *     Headers                                              <br>
 *     Mail Merge                                           <br>
 *     Options                                              <br>
 */
public class MailTestAllScenerio extends TestCase {

    /**
     * This test is to test json request format for sending mail to for 1 recipient
     * in to list.  <br>
     * content used for this test - plain<br>
     * @throws IOException set for mail.build()
     */

    @Test
    public void test_SendMail_Plain_Content() throws IOException {
        String fromMailId = new String("shruti@smsglobal.com");
        String to = new String("sinha@smsglobal.com");
        EmailContent content = new EmailContent("plain", "This is a simple mail.");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo(to);
        Assert.assertEquals(mail.build(),"{\"from\":\"shruti@smsglobal.com\",\"subject\":\"" +
                "Test mail\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is a simple " +
                "mail.\"},\"to\":[\"sinha@smsglobal.com\"]}");
    }

    /**
     * This test is to test json request format for sending mail to for 1 recipient
     * in to list.  <br>
     * content used for this test - html<br>
     * @throws IOException set for mail.build()
     */

    @Test
    public void test_SendMail_Html_Content() throws IOException {
        String fromMailId = new String("shruti@smsglobal.com");
        String to = new String("sinha@smsglobal.com");
        EmailContent content = new EmailContent("html", "<b>Hi<\\/b>,This is a simple mail.");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo(to);
        Assert.assertEquals(mail.build(),"{\"from\":\"shruti@smsglobal.com\",\"subject\":\"" +
                "Test mail\",\"body\":{\"mime\":\"text\\\\/html\",\"content\":\"<b>Hi<\\\\/b>,This " +
                "is a simple mail.\"},\"to\":[\"sinha@smsglobal.com\"]}");
    }

    /**
     * This test is to test json request foramt for sending mail to recipient in "to",
     * "cc" and "bcc" list.<br>
     *  @throws IOException set for mail.build()
     */
    @Test
    public void test_SendMail_One_Recipient_In_ToCcBcc() throws IOException {
        String fromMailId = new String("shruti.sinha@smsglobal.com");
        EmailContent content = new EmailContent("plain", "This is a simple mail.");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("simon@domain.com");
        mail.setCc("kiara@domain.com");
        mail.setBcc("wayer@domain.com");
        Assert.assertEquals(mail.build(),"{\"from\":\"shruti.sinha@smsglobal.com\",\"subject" +
                "\":\"Test mail\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is a simple" +
                " mail.\"},\"to\":[\"simon@domain.com\"],\"cc\":[\"kiara@domain.com\"],\"bcc\":" +
                "[\"wayer@domain.com\"]}");
    }

    /**
     * This test is to test json request format for sending mail to multiple 
     * recipients in "to", "cc" and "bcc" list.<br>
     * @throws IOException set for mail.build()
     */
    @Test
    public void test_SendMail_Multiple_Recipients_In_ToCcBcc() throws IOException {
        String from = new String("shruti.sinha@sms.com");

        EmailContent content = new EmailContent("plain", "This is the mail content" +
                " is for multiple recipients in to/cc/bcc list");
        String subject = "This is the subject line";
        Mail mail = new Mail(from, subject, content);
        mail.setTo("sinha@dummy.com");
        mail.setTo("kayse@yahoo.com");
        mail.setTo("shruti.sds@gmail.co.in");
        mail.setTo("user2.unknown@global.com");
        mail.setCc("sinha@dummy.com");
        mail.setCc("kayseku@yahoo.com");
        mail.setCc("user2.unknown@global.com");
        mail.setCc("inara@yahoo.com");
        mail.setBcc("aika@yahoo.com");
        mail.setBcc("kohi@yahoo.com");

        Assert.assertEquals(mail.build(),"{\"from\":\"shruti.sinha@sms.com\",\"subject\":" +
                "\"This is the subject line\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":" +
                "\"This is the mail content is for multiple recipients in to/cc/bcc list\"},\"to" +
                "\":[\"sinha@dummy.com\",\"kayse@yahoo.com\",\"shruti.sds@gmail.co.in\",\"user2." +
                "unknown@global.com\"],\"cc\":[\"sinha@dummy.com\",\"kayseku@yahoo.com\",\"user2" +
                ".unknown@global.com\",\"inara@yahoo.com\"],\"bcc\":[\"aika@yahoo.com\"," +
                "\"kohi@yahoo.com\"]}");
    }

    /**
     * This test is to test json request format for sending mail with headers.   <br>
     * @throws IOException set for mail.build()
     */
    @Test
    public void test_SendMail_With_Headers() throws IOException {

        String fromMailId = new String("shruti.sinha@smsglobal.com");
        EmailContent content = new EmailContent("plain", "This is a simple mail.");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("shruti.sinha@smsglobal.com");
        Headers header1 = new Headers();
        header1.setName("Header1");
        header1.setValue("Header Value1");
        mail.addHeaders(header1);
        header1.setName("Header2");
        header1.setValue("Header Value2");
        mail.addHeaders(header1);

        Assert.assertEquals(mail.build(),"{\"from\":\"shruti.sinha@smsglobal.com\",\"subject" +
                "\":\"Test mail\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is a sim" +
                "ple mail.\"},\"to\":[\"shruti.sinha@smsglobal.com\"],\"headers\":[{\"name\":\"Heade" +
                "r1\",\"value\":\"Header Value1\"},{\"name\":\"Header2\",\"value\":\"Header Value2\"}]}");
    }

    /**
     * This test is to test json request format for sending mail with substitution.   <br>
     * @throws IOException set for mail.build()
     */
    @Test
    public void test_SendMail_With_MailMerge() throws IOException {
        String fromMailId = new String("shruti@smsglobal.com");
        EmailContent content = new EmailContent("plain", "Hello {{name}},\n\nThis is a " +
                "simple mail.\n\nRegards,\nShruti");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("sinha@smsglobal.com");
        Substitutions substitution = new Substitutions();
        substitution.setName("Shruti");

        Assert.assertEquals(mail.build(),"{\"from\":\"shruti@smsglobal.com\",\"subject\":\"Test" +
                " mail\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":\"Hello {{name}},\\n\\nThis " +
                "is a simple mail.\\n\\nRegards,\\nShruti\"},\"to\":[\"sinha@smsglobal.com\"]}");
    }
    /**
     * This test is to test json request format for sending mail with tags.   <br>
     * @throws IOException set for mail.build()
     */
    @Test
    public void test_SendMail_With_Tags() throws IOException {

        String fromMailId = new String("shruti@smsglobal.com");
        EmailContent content = new EmailContent("plain", "This is a simple mail.");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("sinha@smsglobal.com");
        mail.setTags("Custom-Tag");

        Assert.assertEquals(mail.build(),"{\"from\":\"shruti@smsglobal.com\",\"subject\":\"Test " +
                "mail\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is a simple mail.\"}," +
                "\"to\":[\"sinha@smsglobal.com\"],\"tags\":[\"Custom-Tag\"]}");
    }

    /**
     * This test is to test json request format for sending mail with options.   <br>
     * @throws IOException set for mail.build()
     */

    @Test
    public void test_SendMail_With_Options() throws IOException {

        String fromMailId = new String("shruti.sinha@smsglobal.com");
        EmailContent content = new EmailContent("plain", "This is a simple mail.");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("shruti.sinha@smsglobal.com");
        Options option = new Options(true);
        mail.setOptions(option);

        Assert.assertEquals(mail.build(),"{\"from\":\"shruti.sinha@smsglobal.com\",\"subject\":\"Test" +
                " mail\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is a simple mail.\"},\"" +
                "options\":{\"transactional\":true},\"to\":[\"shruti.sinha@smsglobal.com\"]}");
    }

    /**
     * This test is to test json request format for sending mail with one attachment.   <br>
     * For testing purpose the content has already been encrypted.  <br>
     * @throws IOException set for mail.build()
     */
    @Test
    public void test_SendMail_With_One_Attachment() throws IOException {

        String fromMailId = new String("fromMailId@domain.com");
        EmailContent content = new EmailContent("plain", "This is test mail with an attachment");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("recipientMailId@domain.com");

        Attachments attachments = new Attachments();
        attachments.setEncryptedContent("VGhpcyBpcyB0byB0ZXN0IGF0dGFjaGVtZW50");
        attachments.setName("Email.txt");
        attachments.setMime("text\\/plain");
        mail.addAttachment(attachments);

        Assert.assertEquals(mail.build(),"{\"from\":\"fromMailId@domain.com\",\"subject\":\"Test mail\",\"" +
                "body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is test mail with an attachment\"}" +
                ",\"to\":[\"recipientMailId@domain.com\"],\"attachments\":[{\"name\":\"Email.txt\",\"content\":\"" +
                "VGhpcyBpcyB0byB0ZXN0IGF0dGFjaGVtZW50\",\"contentType\":\"text\\\\/plain\"}]}");
    }

    /**
     * This test is to test json request format for sending mail with multiple attachments.   <br>
     * For testing purpose the content has already been encrypted.  <br>
     * @throws IOException set for mail.build()
     */
    @Test
    public void test_SendMail_With_Multiple_Attachments() throws IOException {

        String fromMailId = new String("fromMailId@domain.com");
        EmailContent content = new EmailContent("plain", "This is test mail with multiple" +
                " attachments");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("recipientMailId@domain.com");

        Attachments attachments = new Attachments();
        attachments.setEncryptedContent("VGhpcyBpcyB0byB0ZXN0IGF0dGFjaGVtZW50");
        attachments.setName("Email.txt");
        attachments.setMime("text\\/plain");
        mail.addAttachment(attachments);

        attachments = new Attachments();
        attachments.setEncryptedContent("cGFja2FnZSBjb20ubWV4Lm1haWw7DQoNCnB1YmxpYyBjbGFzcyBGb3JtYXRFbWFpbCB7DQoJ" +
                "cHVibGljIFN0cmluZyBnZXRFbWFpbCgpIHsNCglwcml2YXRlIFN0cmluZyB0bzsNCn0NCg==");
        attachments.setName("FormatEmail.txt");
        attachments.setMime("text\\/plain");
        mail.addAttachment(attachments);

        Assert.assertEquals(mail.build(),"{\"from\":\"fromMailId@domain.com\",\"subject\":\"Test mail\",\"" +
                "body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is test mail with multiple attachments\"}" +
                ",\"to\":[\"recipientMailId@domain.com\"],\"attachments\":[{\"name\":\"Email.txt\",\"content\":\"" +
                "VGhpcyBpcyB0byB0ZXN0IGF0dGFjaGVtZW50\",\"contentType\":\"text\\\\/plain\"},{\"name\":\"FormatEma" +
                "il.txt\",\"content\":\"cGFja2FnZSBjb20ubWV4Lm1haWw7DQoNCnB1YmxpYyBjbGFzcyBGb3JtYXRFbWFpbCB7DQoJc" +
                "HVibGljIFN0cmluZyBnZXRFbWFpbCgpIHsNCglwcml2YXRlIFN0cmluZyB0bzsNCn0NCg==\",\"contentType\":\"text" +
                "\\\\/plain\"}]}");
    }
}
