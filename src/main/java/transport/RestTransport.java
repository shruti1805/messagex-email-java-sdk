
/**
 * This file is part of the MessageX Java SDK package.<br><br>
 *
 * For the full copyright and license information, please view the LICENSE<br>
 * file that was distributed with this source code.<br><br>
 * 
 * MessageX transport extension - File to edit and customize key, URL, methos, secret-key, etc values<br>
 * 
 */


package transport;

/**
 * Class RestTransport<br>
 * @author Shruti Sinha shruti.sinha@smsglobal.com
 */

import client.MailMessage;
import client.Transport;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.codec.binary.Base64;
import java.util.Date;
import java.util.TimeZone;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

/**
 * <br>
 * RestTransport uses below data to generate requests:<br><br>
 * API Key,<br>secret Key, <br>URL exposed to send email, <br>method,<br>
 * Authorization header - combination of Keys, Content-Type, Content-Length, Content-MD5, Date.<br>
 */
public class RestTransport implements Transport {

	private String 	key;
	private String 	secret;
	private String 	baseUrl;
	private String 	version;
	private String 	method;
	private String 	Content_Type;
	private int 	Content_Length;
	private String 	Content_MD5;
	private String	messageToBeSent;
	private String 	date;
	
	/**
	 * HMAC_ALGORITHM to be used for example HmacSHA1, HmacSHA256.
	 */
	public static final String HMAC_ALGORITHM="HmacSHA256";
	
	/**
	 * Release VERSION of Email SDK. It could be v1, v2.
	 */
	public static final String VERSION="v1";
	
	/**
	 * It returns the content_type for example - application/json.  
	 * @return Content_Type
	 */
	public String getContent_Type() {
		return this.Content_Type;
	}

	/**
	 * It returns the content_type for example - application/json.  
	 * @return Content_Type
	 */
	public String setContent_Type() {
		this.Content_Type = "application/json";
		return Content_Type;
	}

	/**
	 * It returns the message Length.  
	 * @return Content_Length
	 */
	public int getContent_Length() {
		return this.Content_Length;
	}

	/**
	 * It returns the message Length.  
	 * @param content_Length - This is the JSON mail message length.
	 * @return Content_Length
	 */
	public int setContent_Length(int content_Length) {
		this.Content_Length = content_Length;
		return Content_Length;
	}

	/**
	 * The encrypted MD5 for content is returned to the calling method.  
	 * @return Content_MD5
	 */
	public String getContent_MD5() {
		return this.Content_MD5;
	}

	/**
	 * Content_MD5 in Base64 encodeBase64 encrypted format.  
	 * @param messageToEncodeToMD5 This is the Json message that has to be encoded to MD5 format.
	 * @return Content_MD5
	 * @throws NoSuchAlgorithmException This is thrown when the name of algorithm is incorrect.
	 * @throws UnsupportedEncodingException This is thrown when the Charset name is incorrect.
	 */
	public String setContent_MD5(String messageToEncodeToMD5) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		md.update(messageToEncodeToMD5.getBytes("UTF-8"));
		this.Content_MD5 =  Base64.encodeBase64String(md.digest());
		return Content_MD5;
	}

	/**
	 * Returns the JSON messsage. 
	 * @return messageToBeSent
	 */
	public String getMessageToBeSent() {
		return messageToBeSent;
	}

	/**
	 * Sets the json messsage containing - mail id'd - from to, ss, bcc, content, attachments.<br>
	 * @param messageToBeSent This is the mail Message containing all details.<br>
	 */
	public void setMessageToBeSent(String messageToBeSent) {
		this.messageToBeSent = messageToBeSent;
	}
	
	public RestTransport() {
	}

	/**
	 * <br>Initializes the RestTransport object with API key, Secret key, BaseURL and method.<br>
	 * @param key Its the API key
	 * @param secret Its the secret key
	 */
	public RestTransport(String key, String secret) {
		this.key = key;
		this.secret = secret;
		setBaseUrl();
		setMethod();
	}

	/**
	 * It prepares the HttpPost httpRequest creates HttpClientBuilder. <br>
	 * Uses HttpClient and sends the HttpResponse.<br>
	 */

	/* (non-Javadoc)
	 * @see client.Transport#sendMessage(client.Message)
	 */
	public String sendMessage(MailMessage mailMessage) throws Exception {

		HttpPost httpRequest = null;
		httpRequest = new HttpPost (baseUrl);
		StringEntity stringEntity = new StringEntity(mailMessage.getMessage(), ContentType.APPLICATION_JSON);

		httpRequest.setHeader("Content-Type", setContent_Type());
		httpRequest.setHeader("Content-MD5", setContent_MD5(mailMessage.getMessage()));
		httpRequest.setEntity(stringEntity);
		setContent_Length(mailMessage.getMessage().length());
		httpRequest.setHeader("Authorization", authHeader());
		httpRequest.setHeader("Date", getDate());

		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse httpResponse = client.execute(httpRequest);

		System.out.println(httpResponse.getStatusLine()
				+"\nResponse ID -" + (EntityUtils.toString(httpResponse.getEntity())));

		return  httpResponse.toString();
	}

	/**
	 * Date gets set using SimpleDateFormat and TimeZone.<br>
	 * For example EEE, dd MMM yyyy HH:mm:ss z where z could be GMT, AEST
	 * @return date
	 */
	public String setDate() {
		DateFormat gmtFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		gmtFormat.setTimeZone(gmtTime);
		Date date = new Date();
		this.date = gmtFormat.format(date) + "";
		return this.date;
	}
	/**
	 * Date gets set using SimpleDateFormat and TimeZone.<br>
	 * For example EEE, dd MMM yyyy HH:mm:ss z where z could be GMT, AEST<br>
	 * @return date
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * returns version
	 * @return version If this is set.
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * This will be used to version maintenance of the SDK  
	 * @param version This is the SDK version. v2, v2.
	 */
	public void setVersion(String version){
		this.version = VERSION;
	}

	/**
	 * This method results the Base64 encodeBase64 String based on secret key, algorithm and headers- <br>
	 * Calculation of signature is based on -  <br>
	 * content-type,  <br>
	 * content-md5,  <br>
	 * content-length,  <br>
	 * Date,  <br>
	 * <p>
	 * <b>Step1</b> - gets secret hash for the secret key shared using hmac-sha256 and initializing the same using mac- <br>
	 * 	     1. Mac.getInstance(HMAC_ALGORITHM) <br>
	 * 	     2. SecretKeySpec(secret.getBytes(), HMAC_ALGORITHM)<br>
	 * 	     3. mac.init(secretHash) <br><br>
	 * 
	 * <b>Step2</b> - encoding the encrypted message with signature-<br>
	 * 	      1. mac.doFinal(message.getBytes("UTF-8") <br>
	 * 	      2. Base64.encodeBase64String of the above<br>
	 * 	</p>
	 *
	 * @return message - message is the encoded MacSignature
	 * @throws NoSuchAlgorithmException This is thrown when the name of algorithm is incorrect.
	 * @throws InvalidKeyException This is thrown when key sent is invalid.
	 * @throws UnsupportedEncodingException This is thrown when the Charset name is incorrect.
	 */
	public String getMacSignature() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		String message = "content-type: "+getContent_Type()  + "\n" + "content-md5: "+ getContent_MD5() + "\n" + "content-length: " + getContent_Length() + "\n"
				+ "date: "+ setDate();		
		SecretKeySpec secretHash = new SecretKeySpec(secret.getBytes("UTF-8"), HMAC_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(secretHash);       
		return Base64.encodeBase64String(mac.doFinal(message.getBytes("UTF-8")));
	}

	/**
	 * It sets the Authentication header. <br>
	 * The format used is: hmac username apiKey algorithm name headers signature. <br>
	 * hmac username is the API key shared with user, <br>
	 * headers is combination of content-type content-md5 content-length, <br>
	 * Algorithm used is HmacSHA256, <br>
	 * Signature is generated using getMacSignature method.  <br><br>
	 * 
	 * @return authHeader Authentication header
	 * @throws NoSuchAlgorithmException This is thrown when the name of algorithm is incorrect.
	 * @throws InvalidKeyException This is thrown when key sent is invalid.
	 * @throws UnsupportedEncodingException This is thrown when the Charset name is incorrect.
	 */
	public String authHeader() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		String authHeader = "hmac username=" + "\"" + key + "\"" + "," +
				"algorithm=\"hmac-sha256\""  + "," +
				"headers=" + "\"content-type content-md5 content-length date\"" + "," +
				"signature=" + "\"" + getMacSignature() + "\"";

		return authHeader;
	}

	/**
	 * Returns API key
	 * @return key Returns the API Key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * API key
	 * @param key API key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Returns the Secret key
	 * @return secret -It is the Secret key
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * Sets secret key
	 * @param secret This is the secret key
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * returns the base URL
	 * @return baseUrl Returns the base URL
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * Sets baseUrl this is set in descriptor.json file.<br>
	 */
	public void setBaseUrl() {
		this.baseUrl = SetEnv.BASE_URL;
	}

	/**
	 * returns method
	 * @return method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Sets method
	 */
	public void setMethod() {
		this.method = SetEnv.METHOD;
	}
}