jboss-esb-demos
===============

Setup
-----

Make sure [Maven](http://maven.apache.org/) is installed. Then edit the `pom.xml` in the root and change:

- change the location of your JBoss installation in property "jbossesb.home" 
- your `depoy` directory  (e.g, change it to 'deploy")
- change the name of your server profile 

Run a demo
----------

Go into particular directory (e.g, `providers/soa-p.helloworld`)
and execute the following command `mvn package`
This will package and deploy (copy) the esb file to your JBoss Application Server.




