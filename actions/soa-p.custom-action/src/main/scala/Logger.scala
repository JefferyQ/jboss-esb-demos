import org.jboss.soa.esb.actions.annotation.Process

import org.jboss.soa.esb.configure.ConfigProperty
import org.jboss.soa.esb.configure.ConfigProperty.Use
import scala.Predef.String

/**
 *  todo
 */

class Logger {


  @ConfigProperty(use = Use.OPTIONAL,
                  choice = Array("info","warn"),
                  defaultVal = "info")
  var level : String = _

  @Process
  def log(m : String) = {
    level match {
      case  "info" => println("INFO msg="+m)
      case  "warn" => println("WARN msg="+m)
    }


  }

}