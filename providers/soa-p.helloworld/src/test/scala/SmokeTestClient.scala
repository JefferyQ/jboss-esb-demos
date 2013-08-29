import org.jboss.soa.esb.client.ServiceInvoker
import org.jboss.soa.esb.message.format.MessageFactory

/**
 * todo
 */

object SmokeTestClient extends App {

  System.setProperty("javax.xml.registry.ConnectionFactoryClass",
    "org.apache.ws.scout.registry.ConnectionFactoryImpl")

  val serviceInvoker = new ServiceInvoker("demo", "echoService")
  val message = MessageFactory.getInstance.getMessage
  //message.getProperties.setProperty("org.jboss.soa.esb.dls.redeliver","false")

  message.getBody.add("Hi there, we need lunch we are tired!!")
  // message.getBody.add("a","Hi there!")

  serviceInvoker.deliverAsync(message)
  println("Done, message has been sent")

}
