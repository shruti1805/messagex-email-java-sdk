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
 * Class Email
 *
 * @package com.messageX.mail.builder
 *
 * @author Shruti Sinha <shruti.sinha@smsglobal.com>
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Email sets up email-id and name for an Email Object.<br>
 * Email set up is done for recipients in "to", "cc" and "bcc" list.<br>
 */
@JsonInclude(Include.NON_DEFAULT)
public class Email {
	@JsonProperty("name") private String name;
	@JsonProperty("email") private String email;

	public Email() {
		return;
	}

	/**
	 * Sets Email object with "email-id" only
	 * @param email Sets Email object with "email-id" only
	 */
	public Email(String email) {
		this.setEmail(email);
	}

	/**
	 * Sets Email object with provided ""email-id" and "name".
	 * @param email Sets Email object with "email-id" only
	 * @param name Sets name for an email-id
	 */
	public Email(String email, String name) {
		this.setEmail(email);
		this.setName(name);
	}

	/**
	 * Returns JSON object "name"
	 * @return name Returns JSON object "name"
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * Set up name for an "email-id".
	 * @param name Set up name for an "email-id".
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns JSON object for "email-id"
	 * @return email Returns JSON object "email-id"
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	/**
	 * Sets "email-id"
	 * @param email Sets "email-id"
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
