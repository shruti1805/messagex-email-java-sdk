/**
 * This file is part of the MessageX Java SDK package.<br>
 *
 * For the full copyright and license information, please view the LICENSE<br>
 * file that was distributed with this source code.<br>
 *
 * MessageX Email supportive builder file<br>
 */

package com.messageX.mail.builder;

/**
 * Class EmailMultipleToCcBcc <br>
 * @package com.messageX.mail.builder<br>
 * @author Shruti Sinha shruti.sinha@smsglobal.com<br>
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EmailMultipleToCcBcc sets up EmailMultipleToCcBcc object with email-id of the recipient in "to","cc" or "bcc".<br>
 * Each EmailMultipleToCcBcc object has initializes Email object which stores recipient name and email id or only the email id.<br>
 */
@JsonInclude(Include.NON_DEFAULT)
public class EmailMultipleToCcBcc {

	  @JsonProperty("to") private List<Email> multipleReciepients;
	  @JsonProperty("cc") private List<Email> multipleReciepientsCc;
	  @JsonProperty("bcc") private List<Email> multipleReciepientsBcc;

	/**
	 * Returns "to" of EmailMultipleToCcBcc and sets up JSON object as "to".
	 * @return multipleReciepients Returns "to" of EmailMultipleToCcBcc and sets up JSON object as "to".
	 */
	@JsonProperty("to")
	  public List<Email> getTo() {
	    if(multipleReciepients == null)
	       return Collections.<Email>emptyList();
	    return multipleReciepients;
	  }

	/**
	 * Adds Email object for recipient in "to" list.
	 * @param email Adds Email object for recipient in "to" list.
	 */
	public void addTo(Email email) {
		  Email newEmail = new Email();
	    newEmail.setName(email.getName());
	    newEmail.setEmail(email.getEmail());
	   
	    if (multipleReciepients == null) {
	    	multipleReciepients = new ArrayList<Email>();
	    	multipleReciepients.add(newEmail);
	    } else {
	    	multipleReciepients.add(newEmail);
	    }
	  }
	  
	/**
	 * Returns "cc" of EmailMultipleToCcBcc and sets up JSON object as "cc".
	 * @return multipleReciepientsCc Returns "cc" of EmailMultipleToCcBcc and sets up JSON object as "cc".
	 */
	@JsonProperty("cc")
	  public List<Email> getCc() {
	    if(multipleReciepientsCc == null)
	       return Collections.<Email>emptyList();
	    return multipleReciepientsCc;
	  }

	/**
	 * Adds Email object for recipient in "cc" list.
	 * @param email Adds Email object for recipient in "cc" list.
	 */
	public void addCc(Email email) {
		  Email newEmail = new Email();
	    newEmail.setName(email.getName());
	    newEmail.setEmail(email.getEmail());
	   
	    if (multipleReciepientsCc == null) {
	    	multipleReciepientsCc = new ArrayList<Email>();
	    	multipleReciepientsCc.add(newEmail);
	    } else {
	    	multipleReciepientsCc.add(newEmail);
	    }
	  }
	  
	/**
	 * Returns "bcc" of EmailContent and sets up JSON object as "bcc"
	 * @return multipleReciepientsBcc Returns "bcc" of EmailContent and sets up JSON object as "bcc"
	 */
	@JsonProperty("bcc")
	  public List<Email> getBcc() {
	    if(multipleReciepientsBcc == null)
	       return Collections.<Email>emptyList();
	    return multipleReciepientsBcc;
	  }

	/**
	 * Adds Email object for recipient in "bcc" list.
	 * @param email Adds Email object for recipient in "bcc" list.
	 */
	public void addBcc(Email email) {
		  Email newEmail = new Email();
	    newEmail.setName(email.getName());
	    newEmail.setEmail(email.getEmail());
	   
	    if (multipleReciepientsBcc == null) {
	    	multipleReciepientsBcc = new ArrayList<Email>();
	    	multipleReciepientsBcc.add(newEmail);
	    } else {
	    	multipleReciepientsBcc.add(newEmail);
	    }
	  }

}
