package test.component.actors;

import com.wincom.actor.adaptor.compmgr.Port;
import com.wincom.actor.adaptor.compmgr.Subscriber;

import akka.actor.ActorRef;

public class AkkaActorInputWrapper implements Port, ActorRefable  {
	ActorRef actor;
	
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
