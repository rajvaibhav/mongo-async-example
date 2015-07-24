# mongo-async-example
Run main method of Seed.java twice for starting the seeds of cluster.
 * 1st time run --> akka.remote.netty.tcp.port=2251 in application.conf
 * 2nd time run --> akka.remote.netty.tcp.port=2252 in application.conf
 * Then akka.remote.netty.tcp.port=0.
 
 Then run MainApplication.java. 
