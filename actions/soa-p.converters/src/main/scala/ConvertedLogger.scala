package demo

import org.jboss.soa.esb.actions.annotation.Process

import org.jboss.soa.esb.configure.ConfigProperty
import org.jboss.soa.esb.configure.ConfigProperty.Use
import org.jboss.soa.esb.message.Message

/**
 *  todo
 */

class ConvertedLogger {


  @ConfigProperty(use = Use.OPTIONAL)
  var text : String = _


  @Process
  def log(m : Message){
    println(text+m.getBody)
  }

}