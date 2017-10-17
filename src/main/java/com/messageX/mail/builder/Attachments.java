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
 * Provides capability to add properties related to document attachment in an email.<br><br>
 *
 * @package com.messageX.mail.builder
 *
 * @author Shruti Sinha shruti.sinha@smsglobal.com
 */

import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Attachments sets up Attachment properties.<br>
 * Attachment have properties - content, type, filename, disposition, content_id.<br>
 */
@JsonInclude(Include.NON_DEFAULT)
public class Attachments {

  @JsonProperty("name") private String  name;
  @JsonProperty("content") private String  content;
  @JsonProperty("contentType") private String  mimeType;

  /**
   * Sets the content for Attachment object.<br>
   * Encrypted format of Content.<br>
   * @param Filepath it is the path to file which is to be attached
   */
  public void setContent(String Filepath)
  {
    File originalFile = new File(Filepath);
    String encodedBase64 = null;
    try {
      FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
      byte[] bytes = new byte[(int)originalFile.length()];
      fileInputStreamReader.read(bytes);
      encodedBase64 = new String(Base64.encodeBase64(bytes));
      this.content= encodedBase64;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Sets the encrypted content for Attachment object.<br>
   * Encrypted format of Content.<br>
   * @param EncryptedContent it is the path to file which is to be attached
   */
  public void setEncryptedContent(String EncryptedContent)
  {
    this.content= EncryptedContent;
  }

  /**
   * Returns JSON object "content".
   * @return content It is base64 of the file.
   */
  @JsonProperty("content")
  public String getContent(){return this.content;}

  /**
   * Sets the filename for Attachment object.<br>
   * Example readme.txt<br>
   * @param filename Sets the filename for Attachment object.<br>
   */
  public void setName(String filename){  this.name=filename; }

  /**
   * Returns JSON object "filename".
   * @return filename Returns JSON object "filename".
   */
  @JsonProperty("name")
  public String getName(){return this.name;}

  /**
   * Sets the mime-type for Attachment object.<br>
   * Example application/pdf, image/png.<br>
   * @param mimeType  Sets the mime-type for Attachment object.<br>
   */
  public void setMime(String mimeType){  this.mimeType=mimeType; }

  /**
   * Returns JSON object "contentType".<br>
   * @return mimeType It is the format of file
   */
  @JsonProperty("contentType")
  public String getMime(){return this.mimeType;}
}
