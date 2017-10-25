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
 * Class Options<br>
 * 
 * @package com.messageX.mail.builder<br>
 *
 * @author Shruti Sinha shruti.sinha@smsglobal.com<br>
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <br>Example : "options": {"transactional": true }<br><br>
 */
@JsonInclude(Include.NON_DEFAULT)
public class Options {
	@JsonProperty("transactional") private boolean transactional;

	public Options() {
	    return;
	  }

	 /**
	 * Options constructor sets up "transactional" value as true or false
	 * @param transactional its value can be true or false
	 */
	public Options(boolean transactional) {
	    this.setTransactional(transactional);
	  }

	/**
	 * Returns "transactional" value as true or false for Options and sets up JSON object as "transactional"
	 * @return transactional Its value is set as true or false
	 */
	@JsonProperty("transactional")
	  public boolean getTransactional() {
	    return this.transactional;
	  }

	/**
	 * Sets up "transactional" tag and sets its value as true or false for Options tag.
	 * @param transactional Sets up "transactional" tag and sets its value as true or false for Options tag.
	 */
	public void setTransactional(boolean transactional) {
	    this.transactional = transactional;
	  }

}
