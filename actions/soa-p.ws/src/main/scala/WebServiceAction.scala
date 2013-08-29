package demo
import org.jboss.soa.esb.actions.annotation.Process
import org.jboss.soa.esb.message.Message

/**
 *  todo  
 */

class WebServiceAction  {

  @Process
  def process(message: Message) : Message = {
    println("received: " +message)
    val response = "<a:activation-code xmlns:a='http://www.highview.com/types'>" +
      "123</a:activation-code>"
    message.getBody.add(response)
    message
  }

}
