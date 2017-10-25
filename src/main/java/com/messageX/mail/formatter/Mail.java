/**
 * This file is part of the MessageX Java SDK package.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 * 
 * MessageX Email - File to create JSON structure for the API
 */

package com.messageX.mail.formatter;

/**
 * Class Mail
 * 
 * @package com.messageX.mail.formatter
 *
 * @author Shruti Sinha <shruti.sinha@smsglobal.com>
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.messageX.mail.builder.*;

@JsonInclude(Include.NON_DEFAULT)
public class Mail {

	/**
	 * It prepares from tag in JSON mail format  
	 */
	@JsonProperty("from") public String from;

	/**
	 * It prepares subject tag in JSON mail format  
	 */
	@JsonProperty("subject") public String subject;

	/**
	 * It prepares body tag in JSON mail format 
	 */
	@JsonProperty("body") public EmailContent emailContent;

	/**
	 * It prepares substitutions tag in JSON mail format
	 */
	@JsonProperty("substitutions") public Substitutions substitutions;

	/**
	 * It prepares options tag in JSON mail format
	 */
	@JsonProperty("options") public Options options;

	/**
	 * It prepares to tag in JSON mail format  
	 */
	@JsonProperty("to") public List<String> multipleReciepientsTo;

	/**
	 * It prepares cc tag in JSON mail format 
	 */
	@JsonProperty("cc") public List<String> multipleReciepientsCc;

	/**
	 * It prepares bcc tag in JSON mail format  
	 */
	@JsonProperty("bcc") public List<String> multipleReciepientsBcc;

	/**
	 * It prepares tags tag in JSON mail format
	 */
	@JsonProperty("tags") public List<String> tags;

	/**
	 * It prepares replyTo tag in JSON mail format
	 */
	@JsonProperty("replyTo") public String replyTo;

	/**
	 * 	It prepares attachment tag in JSON mail format  
	 */
	@JsonProperty("attachments") public List<Attachments> attachment;

	/**
	 * It prepares headers tag in JSON mail format  
	 */
	@JsonProperty("headers") public List<Headers> headers;

	private static final ObjectMapper SORTED_MAPPER = new ObjectMapper();
	static {
		SORTED_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
	}

	public Mail() { return;  }

	/**
	 * Sets up Mail object with "email-id", "subject" and "content".
	 * @param from This is senders email id
	 * @param subject It is subject of the email
	 * @param content The data to be sent and its type text/html, text/plain
	 */
	public Mail(String from, String subject, EmailContent content)
	{
		this.setFrom(from);
		this.setSubject(subject);
		this.setContent(content);
	}

	/**
	 * "from" mail id in JSON format.
	 * It is sender's email-id.
	 * @return from
	 */
	@JsonProperty("from")
	public String getFrom() {
		return from;
	}

	/**
	 * Sets senders mail id. 
	 * @param from This is senders email id
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Returns "replyTo" in JSON format. 
	 * It is Recipients email-id.  
	 * @return replyTo
	 */
	@JsonProperty("replyTo")
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * sets recipient mail id.
	 * @param replyTo sets recipient mail id.
	 */
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	/**
	 * This is Subject of the email.
	 * @return subject Returns "subject" in JSON format.
	 */
	@JsonProperty("subject")
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.  
	 * @param subject Sets the subject.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Returns "to" list in JSON format.  
	 * @return multipleReciepientsTo This is the list of recipients
	 */
	@JsonProperty("to")
	public List<String> getTo() {
		return multipleReciepientsTo;
	}

	/**
	 * Sets recipients mail id's in "to" to list format.  
	 * @param newEmail Sets recipients mail id's in "to" to list format.
	 */
	public void setTo(String newEmail) {
		if (multipleReciepientsTo == null) {
			multipleReciepientsTo = new ArrayList<String>();
			multipleReciepientsTo.add(newEmail);
		} else {
			multipleReciepientsTo.add(newEmail);
		}
	}

	/**
	 * Returns list of "cc" in JSON format.  
	 * @return multipleReciepientsCc list of "cc" in JSON format.
	 */
	@JsonProperty("cc")
	public List<String> getCc() {
		return multipleReciepientsCc;
	}

	/**
	 * Recipients mail ids in "cc" to list format. 
	 * @param newEmail Adds new recipient in List
	 */
	public void setCc(String newEmail) {
		if (multipleReciepientsCc == null) {
			multipleReciepientsCc = new ArrayList<String>();
			multipleReciepientsCc.add(newEmail);
		} else {
			multipleReciepientsCc.add(newEmail);
		}
	}

	/**
	 * Returns list of "tags" in JSON format.  
	 * @return tags List of "tags" in JSON format.
	 */
	@JsonProperty("tags")
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Adds "tags" as list.  
	 * @param tagsTemp Adds "tags" as list.
	 */
	public void setTags(String tagsTemp) {
		if (tags == null) {
			tags = new ArrayList<String>();
			tags.add(tagsTemp);
		} else {
			tags.add(tagsTemp);
		}
	}

	/**
	 * Returns list of "bcc" in JSON format.  
	 * @return multipleReciepientsBcc List of "bcc" in JSON format.
	 */
	@JsonProperty("bcc")
	public List<String> getBcc() {
		return multipleReciepientsBcc;
	}

	/**
	 * Adds bcc list of e-mail id's.
	 * @param newEmail  Adds new recipient in List
	 */
	public void setBcc(String newEmail) {
		if (multipleReciepientsBcc == null) {
			multipleReciepientsBcc = new ArrayList<String>();
			multipleReciepientsBcc.add(newEmail);
		} else {
			multipleReciepientsBcc.add(newEmail);
		}
	}

	/**
	 * Returns list of "substitutions" in JSON format.
	 * @return substitutions List of "substitutions" in JSON format.
	 */
	@JsonProperty("substitutions")
	public Substitutions getSubstitutions() {
		return substitutions;
	}

	/**
	 * Adds substitutions for mail merge
	 * @param substitutions Adds substitutions for mail merge in JSON list format.
	 */
	public void setSubstitutions(Substitutions substitutions) {
		this.substitutions = substitutions;
	}

	/**
	 * Returns transactional in JSON format as "options" tag in JSON.
	 * @return options
	 */
	@JsonProperty("options")
	public Options getOptions() { return this.options; }

	/**
	 * This is the Options in mail - added in JSON format.  <br>
	 * For example "options": {"transactional": true}
	 * @param options adds options value as "transactional": true ot false.
	 */
	public void setOptions(Options options) {
		this.options = options;
	}

	/**
	 * Returns content in JSON format as "body" tag in JSON.
	 * @return emailContent
	 */
	@JsonProperty("body")
	public EmailContent getContent() {
		return this.emailContent;
	}

	/**
	 * This is the Content of the mail in added in JSON format.  <br>
	 * @param emailContent Content has "mime" and "content" which is stored in pair.
	 */
	public void setContent(EmailContent emailContent) {
		this.emailContent = emailContent;
	}


	/**
	 * Returns list of "attachments" in a mail in JSON format.<br>
	 * @return attachment Attachments have properties - content, filename, mime.
	 */
	@JsonProperty("attachments")
	public List<Attachments> getAttachment() {
		return attachment;
	}

	/**
	 * Attachment have properties - content, filename, mime.
	 * @param attachment Adds all the Attachment
	 */
	public void addAttachment(Attachments attachment) {
		if (this.attachment == null) {
			this.attachment = new ArrayList<Attachments>();
			this.attachment.add(attachment);
		} else {
			this.attachment.add(attachment);
		}
	}

	/**
	 * Returns "headers" in JSON format.  
	 * @return headers Returns "headers" in JSON format.
	 */
	@JsonProperty("headers")
	public List<Headers> getHeaders() {
		return headers;
	}

	/**
	 * Adds all the "headers" in name value pair
	 * @param headers Adds all the "headers" in name value pair
	 */
	public void addHeaders(Headers headers) {
		Headers newHeader = new Headers();
		newHeader.setName(headers.getName());
		newHeader.setValue(headers.getValue());
		if (this.headers == null) {
			this.headers = new ArrayList<Headers>();
			this.headers.add(newHeader);
		} else {
			this.headers.add(newHeader);
		}
	}

	/**
	 * Create a string representation of the Mail object JSON.  
	 * @return String representation of the Mail object JSON.
	 * @throws IOException For writeValueAsString
	 */
	public String build() throws IOException {
		try {
			return SORTED_MAPPER.writeValueAsString(this);
		} catch (IOException ex) {
			throw ex;
		}
	}

	/**
	 * Create a string representation of the Mail object JSON and pretty print it.
	 */
	/**
	 * @return String representation of the Mail object JSON in pretty format.
	 * @throws IOException For writeValueAsString
	 */
	public String buildPretty() throws IOException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (IOException ex) {
			throw ex;
		}
	}
}