package demo

import org.jboss.soa.esb.actions.annotation.{PropertyParam, Process}

import org.jboss.soa.esb.configure.ConfigProperty
import org.jboss.soa.esb.configure.ConfigProperty.Use

import org.jboss.soa.esb.message.Message
import org.jboss.soa.esb.http.HttpRequest
import scala.collection.JavaConversions._
/**
 *  todo
 */

class HttpBodyConverter {



  @Process
  def log(msg : Message, @PropertyParam requestInfo : HttpRequest ) = {
    val age = requestInfo.getQueryParams.get("age")(0).toInt

    val name = requestInfo.getQueryParams.get("name")(0)

    msg.getBody.add("Customer",Customer(name,age,true))
    msg
  }

}