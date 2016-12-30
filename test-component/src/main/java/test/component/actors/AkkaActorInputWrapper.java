package test.component.actors;

import com.wincom.actor.adaptor.compmgr.Port;
import com.wincom.actor.adaptor.compmgr.Subscriber;

import akka.actor.ActorRef;

/**
 * Wrapper the {@code ActorRef} as a {@link Port}.
 */
public class AkkaActorInputWrapper implements Port, ActorRefable  {
	ActorRef actor;

    /**
     * Send message to the Wrapped actor. 
     * If the sender is {@link ActorRefable} that refers to an 
     * {@link ActorRef}, then set the wrapped {@link ActorRef} 
     * as the sender to call {@link ActorRef#tell(Object, ActorRef)},
     * otherwise, {@link ActorRef#noSender()} is used. 
     * See {@link #enqueue(Port, Object)}.
     * 
     * @param sender the sender
     * @param msg the message
     */	
	@Override
	public <T> void enqueue(Port sender, T msg) {
		ActorRef ref = ActorRef.noSender();
		if(sender instanceof ActorRefable) {
			ref = ((ActorRefable) sender).getActorRef();
		}
		actor.tell(msg, ref);
	}

	@Override
	public void subscribe(Subscriber subscriber) {
		throw new RuntimeException("Not allowed.");
	}

	@Override
	public void unsubscribe(Subscriber subscriber) {
		throw new RuntimeException("Not allowed.");
	}

	@Override
	public ActorRef getActorRef() {
		return actor;
	}

}
