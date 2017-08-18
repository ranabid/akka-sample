package com.project.akka.helloworld;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.project.akka.helloworld.Greeter.*;

public class AkkaHelloWorld {
	public static void main(String[] args) {
		// Create a Actor System
		final ActorSystem actorSystem = ActorSystem.create("akkahelloworld");
		try {
			final ActorRef printerActor = actorSystem.actorOf(Printer.props(), "printerActor");
			final ActorRef howdyGreeter = actorSystem.actorOf(Greeter.props("howdy", printerActor), "howdyGreeter");
			final ActorRef helloGreeter = actorSystem.actorOf(Greeter.props("hello", printerActor), "HelloGreeter");
			
			
			howdyGreeter.tell(new WhoToGreet("Akka"), ActorRef.noSender());
		      howdyGreeter.tell(new Greet(), ActorRef.noSender());;
			
		}finally {
			actorSystem.terminate();
		}
		
		
	}
}
