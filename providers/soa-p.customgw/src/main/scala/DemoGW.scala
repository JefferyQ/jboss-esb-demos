/**
 *  todo  
 */

package demo

import org.jboss.soa.esb.helpers.ConfigTree
import org.jboss.soa.esb.listeners.ListenerTagNames
import org.jboss.soa.esb.client.ServiceInvoker
import org.jboss.soa.esb.listeners.lifecycle.AbstractThreadedManagedLifecycle
import org.jboss.soa.esb.message.format.MessageFactory
import java.net.ServerSocket
import java.io.{BufferedReader, InputStreamReader}

class DemoGW(config: ConfigTree) extends
  AbstractThreadedManagedLifecycle(config) {

  val targetServiceCategory = config.getAttribute(ListenerTagNames.TARGET_SERVICE_CATEGORY_TAG)
  val targetServiceName = config.getAttribute(ListenerTagNames.TARGET_SERVICE_NAME_TAG)
  val port = config.getAttribute("port","7007").toInt

  var invoker :ServiceInvoker = _

  def doInitialise() {
    invoker =new ServiceInvoker(targetServiceCategory, targetServiceName)
  }

  def doRun() {
    while (isRunning) {
      val payLoad = waitForPayload
      val message = createMessage(payLoad)
      invoker.deliverAsync(message)
    }
  }

  def createMessage(payLoad : Object)={
    val message = MessageFactory.getInstance.getMessage
    message.getBody.add(payLoad)
    message
  }

  def waitForPayload: String = using(new ServerSocket(port)) {
    listener => using(listener.accept) {
      socket => using(new BufferedReader(new InputStreamReader(socket.getInputStream))) {
        reader => reader.readLine()
      }
    }
  }

  def using[T <: {def close()}, R](resource: T)(block: T => R): R = {
    try {
      block(resource)
    } finally {
      if (resource != null) resource.close()
    }
  }


}
