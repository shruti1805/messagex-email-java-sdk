JAVA SDK for EMAIL API
===============
# Introduction
Official Java SDK for MessageX Email API. It provides easy integration with MessageX Email API. <br />
We want this SDK to be community driven and led by us. You can get started in minutes by installing SDK through downloading a zip file. <br />

The REST API allows programmatic access to MessageX services. To use the REST API, you will need an MessageX account and an API key and secret. 
You can generate those inside your MessageX account. The REST API can be accessed at api.messagex.com. Use of SSL is supported and strongly encouraged. 
The REST API takes full advantage of all HTTP headers. Each part of a request and response is meaningful, including the request method (GET/POST, etc.), 
the individual headers (Location, Content-Type, Accept, etc.), and the response status code (200, 400, 404, etc.). Use of this API assumes a working 
knowledge of these HTTP components, and general use of RESTful web APIs. 

# Table of Contents

* [Installation](#installation)
    * [Prerequisites](#prerequisites)
    * [Key Setup](#key-setup)
    * [Install Package](#install-package)
* [Quickstart](#quickstart)
    * [Send Email](#send-an-email)
        * [Without Mail Builder](#without-mail-builder-classes) 
        * [With Mail Builder](#with-mail-builder-classes) 
    * [Add CC and BCC](#add-cc-and-bcc)
    * [Add Headers](#add-headers) 
    * [Add Multiple Tags](#add-multiple-tags) 
    * [Add Attachments](#add-attachments) 
    * [Add Mail Merge](#add-mail-merge) 
* [Versioning](#versioning)
* [Documentation](#documentation)
    * [SDK Reference](#sdk-reference)

# Installation

## Prerequisites

* Java >= 1.8
* API and Secret Key from your MessageX account

## Key Setup 
Register yourself on **https://account.messagex.com** to get your API and Secret keys <br />

## Install Package
Choose the installation method in your IDE - Maven or Gradle. <br />
This package has all the files for both.

# Quickstart
This library allows you to quickly and easily use the MessageX Web API v1 via Java Email SDK.

## Send an Email
You can find examples in the test folder of this package.<br /><br />

Below are few more examples which are ready to use.<br />
The following is the is a minimal code sample needed in order to send a basic email using SDK.

You can use MailTest.java to send mails. It is located at <br />
messagex-email-java-sdk/src/test/java/com/messageX/test


### Without Mail Builder Classes
*Just update the Keys and email-ids of the sender and reciever in the below examples-*

```java
        MailMessage messageToBeSent = new MailMessage("{\"from\":\"fromMailId@domain.com\",\"subject\":\"" +
                "Test mail\",\"body\":{\"mime\":\"text\\\\/plain\",\"content\":\"This is a simple " +
                "mail.\"},\"to\":[\"RecipientMailId@domain.com\"]}");
				
		RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");
				
		Client client = new Client(restTransport);
		String response = client.sendMessage(messageToBeSent);
```
The Mail constructor creates a Mail object for you. Here is an example of how to add to it.

### With Mail Builder Classes

```java
	    String fromMailId = new String("fromMailId@domain.com");
		EmailContent content = new EmailContent("plain", "This is a simple mail.");
		String subject = "Test mail";
		Mail mail = new Mail(fromMailId, subject, content);
		mail.setTo("recipientMailId@domain.com");

		MailMessage messageToBeSent = new MailMessage(mail.build());
		RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");
		Client client = new Client(restTransport);
		String response = client.sendMessage(messageToBeSent);
```

Name of the reciever or sender can be added using notation shown in code sample above.<br />
Adding a name is not required, adding just email address is supported.  <br />
At the moment only following content types are support for the email body

* html
* plain

## Add CC and BCC
Adding CC and BCC is also simple

```java
		String fromMailId = new String("fromMailId@domain.com");
		EmailContent content = new EmailContent("plain", "This is a simple mail.");
		String subject = "Test mail";
		Mail mail = new Mail(fromMailId, subject, content);
		
		mail.setTo("simon@domain.com");
		mail.setCc("kiara@domain.com");
		mail.setBcc("wayer@domain.com");

		MailMessage messageToBeSent = new MailMessage(mail.build());
		RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");
		Client client = new Client(restTransport);
		String response = client.sendMessage(messageToBeSent);
```

## Add Headers

You can add one or more headers to the email as following

```java
        String fromMailId = new String("fromMailId@domain.com");
		EmailContent content = new EmailContent("plain", "This is a simple mail.");
		String subject = "Test mail";
		Mail mail = new Mail(fromMailId, subject, content);
		mail.setTo("recipientMailId@domain.com");

		Headers header1 = new Headers();
		header1.setName("Header1");
		header1.setValue("Header Value1");
		mail.addHeaders(header1);

		MailMessage messageToBeSent = new MailMessage(mail.build());
	    RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");
		Client client = new Client(restTransport);
		String response = client.sendMessage(messageToBeSent);
```

## Add Multiple Tags

Tags are custom text labels associated with the the email. Adding custom tags as showed in sample below

```java
        String fromMailId = new String("fromMailId@domain.com");
		EmailContent content = new EmailContent("plain", "This is a simple mail.");
		String subject = "Test mail";
		Mail mail = new Mail(fromMailId, subject, content);
		mail.setTo("recipientMailId@domain.com");

		mail.setTags("Custom-Tag");

		MailMessage messageToBeSent = new MailMessage(mail.build());
		RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");
		Client client = new Client(restTransport);
		String response = client.sendMessage(messageToBeSent);
```

## Add Attachments

You can add one or more attachments to the email as following.<br>

```java
        String fromMailId = new String("fromMailId@domain.com");
        EmailContent content = new EmailContent("plain", "This mail is with an attachment");
        String subject = "Test mail";
        Mail mail = new Mail(fromMailId, subject, content);
        mail.setTo("recipientMailId@domain.com");
        
        Attachments attachments = new Attachments();
        attachments.setContent("Complete path to File\\Filename.extenstion");
        attachments.setName("Filename.txt");
        attachments.setMime("text\\/plain");
        mail.addAttachment(attachments);
        
        MailMessage messageToBeSent = new MailMessage(mail.build());
        RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");
        Client client = new Client(restTransport);
        String response = client.sendMessage(messageToBeSent);
```
Mime is the file type, you can find the details in MimeType.html<br>
This file is located at -> messagex-email-java-sdk\doc\com\messageX\mail\builder

Some commonly used mime<br>
application\\/pdf<br>
text\\/plain<br>
image\\/jpeg<br>

## Add Mail merge

Properties are representing placeholder strings in email body and value for each property is array of replacements for all recipients. <br />
Number of replacements for each placeholder must match number of recipients. Order of replacements for each placeholder must match order of recipients. <br />
Mail merge can be added as shown in the sample below

```java
        String fromMailId = new String("fromMailId@domain.com");
		EmailContent content = new EmailContent("plain", "Hello {{name}},\n\nThis is a simple mail.\n\nRegards,\nMailUser");
		String subject = "Test mail";
		Mail mail = new Mail(fromMailId, subject, content);
		mail.setTo("recipientMailIdOne@domain.com");
		mail.setTo("recipientMailIdTwo@domain.com");

		Substitutions substitution = new Substitutions();
		substitution.setName("recipientOne");
		substitution.setName("recipientTwo");
        mail.setSubstitutions(substitution);

		MailMessage messageToBeSent = new MailMessage(mail.build());
		RestTransport restTransport = new RestTransport("API_KEY", "SECRET_KEY");
		Client client = new Client(restTransport);
		String response = client.sendMessage(messageToBeSent);
```

# Versioning
Our API will be versioned with "v1", "v2" etc. in the URL path. We will ensure that our API is as much as possible backwards compatible, but if we have to break backwards compatibility, we will increment the API version and make sure that we will continue to support the old version until you are ready to upgrade so we will never break your code. We will make sure that your code works with the API in case of following changes.

Adding a new optional parameters or changing the order of parameters of existing resources, both for requests and responses. <br />
Adding new API resources.

# Documentation

https://www.messagex.com/docs/

You can go through detailed Java Documentation of the methods and parameters.<br />
Generate Java Doc in your IDE for the package and open index.html <br />

## SDK Reference

# Getting help
