package com.example.akka.factories;

import akka.actor.ActorRef;
import akka.contrib.pattern.DistributedPubSubExtension;

/**
 * Initializes DistributedPubSubMediator.
 * 
 * @author vaibhavraj
 *
 */
public final class DistributedPubSubMediatorFactory {

    private static volatile ActorRef mediator;

    /**
     * Returns DistributedPubSubMediator for current node in the akka cluster.
     * 
     * @return
     */
    public static final ActorRef getDistributedPubSubMediator() {
	if (null == mediator) {
	    synchronized (DistributedPubSubMediatorFactory.class) {
		if (null == mediator) {
		    mediator = DistributedPubSubExtension.get(
			    ActorSystemFactory.getActorSystem()).mediator();
		}
	    }
	}
	return mediator;
    }
}
