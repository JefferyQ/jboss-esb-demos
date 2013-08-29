package demo

import org.jboss.soa.esb.actions.annotation.Process

import org.jboss.soa.esb.configure.ConfigProperty
import org.jboss.soa.esb.configure.ConfigProperty.Use
import org.jboss.soa.esb.listeners.ScheduledEventMessageComposer
import org.jboss.soa.esb.message.Message
import org.jboss.soa.esb.message.helper.content.XMLMessageFactory
import org.jboss.soa.esb.helpers.ConfigTree
import org.jboss.soa.esb.message.format.MessageFactory

/**
 *  todo
 */

class DemoScheduledEventMessageComposer extends ScheduledEventMessageComposer{

  def composeMessage() =
    XMLMessageFactory.getInstance.createTextMessage("It's time...again")

  def onProcessingComplete(message: Message) = message

  def initialize(config: ConfigTree) {}

  def uninitialize() {}
}