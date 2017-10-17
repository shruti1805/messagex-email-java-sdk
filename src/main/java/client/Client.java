/**
 * This file is part of the MessageX Java SDK package.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package client;

/**
 * Client supports email SDK in sending mail
 *
 * @author Shruti Sinha shruti.sinha@smsglobal.com
 */

public class Client {

    private Transport transport;

    /**
     * @param transport
     */
    public Client(Transport transport) {
        this.transport = transport;
    }

    /**
     * @param mailMessage
     * @return
     * @throws Exception
     */
    public String sendMessage(MailMessage mailMessage) throws Exception {
        return transport.sendMessage(mailMessage);
    }
}
