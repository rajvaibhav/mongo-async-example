package com.example.akka.factories;

import akka.actor.ActorSystem;

import com.typesafe.config.ConfigFactory;

/**
 * Initializes actor system as singlton.
 * 
 * @author vaibhavraj
 *
 */
public final class ActorSystemFactory {

    private static volatile ActorSystem system;

    /**
     * Returns singleton instance of actor system.
     * 
     * @return
     */
    public static final ActorSystem getActorSystem() {
	if (null == system) {
	    synchronized (ActorSystemFactory.class) {
		if (null == system) {
		    system = ActorSystem.create("cluster-example",
			    ConfigFactory.load());
		}
	    }
	}
	return system;
    }
}
