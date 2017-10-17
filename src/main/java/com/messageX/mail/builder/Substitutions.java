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
 * Class Substitutions<br>
 * 
 * @package com.messageX.mail.builder<br>
 *
 * @author Shruti Sinha <shruti.sinha@smsglobal.com><br>
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Substitutions sets up object to do MailMerge by replacing the "name" with provided name.<br>
 * Example : "substitutions": {"name": ["Shruti"]}
 *
 */
@JsonInclude(Include.NON_DEFAULT)
public class Substitutions {
	@JsonProperty("name") private List<String> nameList;

	public Substitutions() {
	    return;
	  }

	 /**
	 * Substitutions constructor sets up "name"
	 * @param name This is the name that will be replaced with the name provided.
	 */
	public Substitutions(String name) {
	    this.setName(name);
	  }

	/**
	 * Returns "name" of Substitutions and sets up JSON object as "name"
	 * @return Returns the name List.
	 */
	@JsonProperty("name")
	  public List<String> getName() {
	    return nameList;
	  }

	/**
	 * Sets up "name" for Substitutions
	 * @param name Sets up name for mail merge.
	 */
	public void setName(String name) {
		if (nameList == null) {
			nameList = new ArrayList<String>();
			nameList.add(name);
		} else {
			nameList.add(name);
		}
	  }

}
