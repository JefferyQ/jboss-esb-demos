from javax.naming import InitialContext 
from javax.jms import *
from java.util import Properties
import time
import sys

# Jython version check
minVersion =(2,5)
thisVersion =(sys.version_info)
if  thisVersion< minVersion :
    print  "ERROR: must be run with at least Jython %(minVersion)s, you are running %(thisVersion)s" % locals()
    sys.exit(1)

def onMessage(m):
    print "received %(m)r" % locals()
    time.sleep(2)

properties = Properties()
properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory")
properties.put("java.naming.provider.url","jnp://localhost:1099")
properties.put("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces")

context = InitialContext(properties)
factory =context.lookup("ConnectionFactory")
destination = context.lookup("queue/DemoJMSProviderGW_reply")

connection =  factory.createConnection()
session = connection.createSession(False, Session.AUTO_ACKNOWLEDGE)
consumer = session.createConsumer(destination)

consumer.setMessageListener(onMessage)


connection.start()

print "Wiling and able..."
while True:
    pass

