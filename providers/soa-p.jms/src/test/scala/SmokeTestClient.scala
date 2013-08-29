import org.jboss.soa.esb.client.ServiceInvoker
import org.jboss.soa.esb.message.format.MessageFactory

/**
 * todo
 */

object SmokeTestClient extends App {

  System.setProperty("javax.xml.registry.ConnectionFactoryClass",
    "org.apache.ws.scout.registry.ConnectionFactoryImpl")


  val serviceInvoker = new ServiceInvoker("demo", "jmsService")
  val message = MessageFactory.getInstance.getMessage

  message.getBody.add("Hi there!!")
  val rsp = serviceInvoker.deliverSync(message, 5000)
  println("rply: " + rsp.getBody.get())

}
