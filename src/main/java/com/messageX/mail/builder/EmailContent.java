/**
 * This file is part of the MessageX Java SDK package.<br><br>
 *
 * For the full copyright and license information, please view the LICENSE<br>
 * file that was distributed with this source code.<br><br>
 *
 * MessageX Email supportive builder file<br>
 */


package com.messageX.mail.builder;

/**
 * Class EmailContent - Sets the mime and content of the email body
 * 
 * @package com.messageX.mail.builder
 *
 * @author Shruti Sinha <shruti.sinha@smsglobal.com>
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EmailContent sets up EmailContent object with the "mime" of content sent and the "content" of the mail.<br>
 * Each EmailContent has pair of "mime" and "content".<br>
 * For Example mime could be "text\\/plain" or "text\\/html", "content" could be any text.<br>
 *
 */
@JsonInclude(Include.NON_DEFAULT)
public class EmailContent {
	@JsonProperty("mime") private String mime;
	@JsonProperty("content") private String  content;
	
	public EmailContent() {
	    return;
	  }

	 /**
	 * EmailContent constructor sets up "mime" and "content"
	 * @param mime EmailContent constructor sets up "mime"
	 * @param content EmailContent constructor sets up "content"
	 */
	public EmailContent(String mime, String content) {
	    this.setMime(mime);
	    this.setContent(content);
	  }

	/**
	 * Returns "mime" of EmailContent and sets up JSON object as "mime"
	 * @return mime Returns "mime" of EmailContent and sets up JSON object as "mime"
	 */
	@JsonProperty("mime")
	  public String getMime() {
	    return mime;
	  }

	/**
	 * Sets up "mime" for EmailContent
	 * @param mime Sets up "mime" for EmailContent
	 */
	public void setMime(String mime) {
		if (mime.equals("plain")){
			this.mime = "text\\/" + mime;
		}
		else if(mime.equals("html")){
			this.mime = "text\\/" + mime;
		}
		else
	    	this.mime = mime;
	  }

	 /**
	  * Returns "content" of EmailContent and sets up JSON object as "content"
	  * @return content Returns "content" of EmailContent and sets up JSON object as "content"
	  */
	@JsonProperty("content")
	  public String getContent() {
	    return content;
	  }

	 /**
	  * Sets up "content" for EmailContent, "content" is the body of email content
	  * @param content Sets up "content" for EmailContent, "content" is the body of email content
	  */
	public void setContent(String content) {
	    this.content = content;
	  }
}
