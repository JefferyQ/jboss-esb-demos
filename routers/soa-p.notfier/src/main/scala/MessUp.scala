package demo

import org.jboss.soa.esb.actions.annotation.Process

/**
 *  todo
 */

class MessUp {




  @Process
  def log(txt : String) =
   txt match{
      case "error" => throw new Exception("Explicit error request :)")
      case  _ => txt.toUpperCase
  }



}