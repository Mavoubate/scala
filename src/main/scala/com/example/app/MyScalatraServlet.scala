package com.example.app

import org.scalatra._
import scalate.ScalateSupport

// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._

import com.microsoft.windowsazure.storage._

import com.microsoft.windowsazure.storage.blob._




// A Flower object to use as a faked-out data model
case class Flower(slug: String, name: String)



	object FlowerData {

  
		  var all = List(
			      Flower("yellow-tulip", "Yellow Tulip"),
			      Flower("red-rose", "Red Rose"),
			      Flower("black-rose", "Black Rose"))
		}


class MyScalatraServlet extends MyScalatraWebAppStack with JacksonJsonSupport {


// Define the connection-string with your values
private implicit val storageConnectionString: String = 
    "DefaultEndpointsProtocol=http;" + 
    "AccountName=;" + 
    "AccountKey=";

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit val jsonFormats: Formats = DefaultFormats
 

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

 



  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
  get("/articles/:id") {  //  <= this is a route matcher
    // this is an action
    // this action would show the article which has the specified :id

    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate pierreL4 {params("id")}</a>.
      </body>
    </html>
  }


   get("/program/:id") {    
       /*val account = CloudStorageAccount.parse(storageConnectionString);
       val blobClient = account.createCloudBlobClient();

       // Get a reference to a container.
       // The container name must be lower case
       val container = blobClient.getContainerReference("cache-full-most-watched");

        val blob = container.getBlockBlobReference("most-watched");

	blob.downloadText();*/

	FlowerData.all
   }
}
