package demo

import org.jboss.soa.esb.actions.annotation.Process
import org.jboss.soa.esb.message.Message
import org.jboss.soa.esb.http.HttpRequest

/**
 *  todo
 */

class HttpLogger {

  @Process
  def log(m : Message) {
    println(m)
    val request = m.getProperties.getProperty("org.jboss.soa.esb.http.HttpRequest#request").asInstanceOf[HttpRequest]


    println("query string is "+request.getQueryString)



  }

}