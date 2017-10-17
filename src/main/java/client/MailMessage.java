/**
 * This file is part of the MessageX Java SDK package.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */


package client;

/**
 * It creates the mail object - it has JSON mail message to be sent to EMAIL SDK API
 *
 * @author Shruti Sinha shruti.sinha@smsglobal.com
 */

public class MailMessage {

    private String mailMessage;
   
    public MailMessage() {}

    /**
     * This sets the message to be sent as request.
     * @param mailMessage
     */
    public MailMessage(String mailMessage) {
        this.mailMessage = mailMessage;
    }  
    
    /**It returns the mailMessage set.
     * @return
     */
    public String getMessage() {
        return mailMessage;
    }     
}
