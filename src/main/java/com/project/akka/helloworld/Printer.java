package com.project.akka.helloworld;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Printer extends AbstractActor {
	private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	
	public Printer() {	}
	
	static public Props props() {
		return Props.create(Printer.class, () -> new Printer());
	}
	
	static public class Greeting{
		public final String message;
		public Greeting(String msg) {
			this.message = msg;
		}
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(
				Greeting.class, greeting -> 
					{log.info(greeting.message);
		}).build();
	}

}
