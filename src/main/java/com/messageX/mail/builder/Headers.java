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
 * Class Headers
 * @package com.messageX.mail.builder
 * @author Shruti Sinha shruti.sinha@smsglobal.com
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.*;

/**
 * Headers sets up name and value for mail headers.<br>
 * Each EmailMultipleToCcBcc object has initializes Email object which stores recipient name and email id or only the email id.<br>
 */
@JsonInclude(Include.NON_DEFAULT)
public class Headers {
	@JsonProperty("name") private String name;
	@JsonProperty("value") private String value;

	/**
	 * Returns "name" of Header
	 * @return
	 */
	@JsonProperty("name") 
	public String getName() {
		return name;
	}

	/**
	 * Sets "name" of Header
	 * @param name Sets "name" of Header
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns "value" of Header
	 * @return Returns "value" of Header
	 */
	@JsonProperty("value") 
	public String getValue() {
		return value;
	}

	/**
	 * Sets "value" of Header
	 * @param value Sets "value" of Header
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
