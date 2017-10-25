/**
 * This has all the test cases and examples to send mails.
 * @author shruti.sinha
 *
 */

package com.messageX.test;

import client.*;
import transport.RestTransport;
import com.messageX.mail.builder.*;
import com.messageX.mail.formatter.Mail;

/**
 * Example Class has a main function to send a simple mail using - Email SDK<br>
 * Inputs :<br>
 *  fromMailId has the sender's email ID<br>
 *  setTo has the receiver email ID<br>
 *  subject has email Subject<br>
 *  Content will have the email content.
 */
public class MailTest {
    public static void main (String s[]) throws Exception {

        String fromMailId = new String("sendersMailId");
        EmailContent content = new EmailContent("plain", "This is a simple mail");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("ReceiversMailId");
        MailMessage messageToBeSent = new MailMessage(mail.build());

        RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");

        Client client = new Client(restTransport);
        client.sendMessage(messageToBeSent);
    }
}
