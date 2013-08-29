
import org.jboss.soa.esb.client.ServiceInvoker
import org.jboss.soa.esb.message.format.MessageFactory
import org.jboss.soa.esb.message.Message

/**
 *  todo  
 */

object SmokeTestClient {
  System.setProperty("javax.xml.registry.ConnectionFactoryClass", "org.apache.ws.scout.registry.ConnectionFactoryImpl")

  def main(args: Array[String]) {
    val serviceInvoker = new ServiceInvoker("aggregatorDemo", "main")
    val message = MessageFactory.getInstance.getMessage
    message.getBody.add("Hi there!!")
    serviceInvoker.deliverAsync(message)
    println("Done, message has been sent")
  }

}
