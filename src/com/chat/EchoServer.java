package com.chat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable; 
@ServerEndpoint(value = "/chao/{username}")
public class EchoServer {
	protected static Set<Session> sessions = new HashSet<Session>();
	protected static Hashtable userMap = new Hashtable();
	
	Session session;
	
	@OnOpen
	public void open(Session ses, @PathParam("username") String username) {
		this.session = ses;
		synchronized (sessions) {
			sessions.add(session);
		}
		synchronized (userMap) {
			if (userMap.contains(username)) {
				userMap.put(session.getId(), new User(username + "2"));
			} else {
				userMap.put(session.getId(), new User(username));
			}
		}
	}
	
	@OnMessage
	public void echo(String incommingMessage) {
		System.out.println("receive");
		try {
			Iterator<Session> sesite = sessions.iterator();
			while (sesite.hasNext()) {
				Session session2 = sesite.next();  
				System.out.println(session2.getId());
				User u =  (User) userMap.get(session.getId());
				session2.getBasicRemote().sendText("<b style='color:" + u.getColor() + "'>" + u.getUsername().toUpperCase() + ": " + incommingMessage  + "</b> ") ;
			}
		} catch (IOException e) { 
			System.out.println("some thing wrong"); 
		}
	}
	
	@OnError
	public void error(Throwable error) {
		System.out.println("error"); 
	}
	
	@OnClose
	public void userExit() {
		System.out.println("user with ID " + session.getId() + "exit");
		updateSession(session);
	}

	private void updateSession(Session session) {  
		synchronized (userMap) {
			userMap.remove(userMap.get(session.getId()));
		}
		synchronized (sessions) {
			sessions.remove(session);
		}
	}
}
