
import org.jboss.soa.esb.client.ServiceInvoker
import org.jboss.soa.esb.message.format.MessageFactory

/**
 * todo
 */

object SmokeTestClient extends App {

  System.setProperty("javax.xml.registry.ConnectionFactoryClass",
    "org.apache.ws.scout.registry.ConnectionFactoryImpl")

  val serviceInvoker = new ServiceInvoker("demo", "ejbService")
  val message = MessageFactory.getInstance.getMessage

  message.getBody.add("username", "jennifer")
  message.getBody.add("password", "p@$$w0rd")

  serviceInvoker.deliverAsync(message)
  println("Done, message has been sent")

}
