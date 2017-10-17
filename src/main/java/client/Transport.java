/**
 * This file is part of the MessageX Java SDK package.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */


package client;

/**
 * Mail Transport
 *
 * @author Shruti Sinha shruti.sinha@smsglobal.com
 */

public interface Transport {

    /**
     * @param mailMessage This is the Mailmessage object which will be sent in HttpRequest.
     * @throws Exception
     */
    String sendMessage(MailMessage mailMessage) throws Exception;
}
