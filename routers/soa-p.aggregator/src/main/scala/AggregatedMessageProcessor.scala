package demo

import org.jboss.soa.esb.message.Message
import org.jboss.soa.esb.actions.annotation.Process
import java.io.Serializable
import org.jboss.soa.esb.util.Util

/**
 * todo  
 */
class AggregatedMessageProcessor {

  @Process
  def process(m: Message): Unit = {
    val count = m.getAttachment.getUnnamedCount
    if (count == 2){
      val m1 = Util.deserialize( m.getAttachment.itemAt(0).asInstanceOf[Serializable] )
      val m2 = Util.deserialize( m.getAttachment.itemAt(1).asInstanceOf[Serializable] )

      val b1 = m1.getBody.get()
      val b2 = m2.getBody.get()

      println("body1: " +b1)
      println("body2: " +b2)

    }


  }

}
