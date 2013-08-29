package demo
import org.jboss.soa.esb.actions.annotation.Process
import org.jboss.soa.esb.configure.ConfigProperty
import org.jboss.soa.esb.configure.ConfigProperty._


/**
 *  todo
 */

class SetPayloadAction {
  @ConfigProperty(use = Use.REQUIRED)
  var text : String = _

  @Process
  def process(t: String) = text

}
