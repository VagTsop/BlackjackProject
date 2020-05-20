
package com.jack.main.sockets;

import com.jack.main.SessionRegistry;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//Define the WebSocket server endpoint path
@ServerEndpoint("/hello")
public class HelloEndpoint {

    private SessionRegistry registry = SessionRegistry.getInstance();

    @OnMessage
    public void onMessage(String message, Session sender) {
        Set<Session> sessions = registry.getAllSessionsLocked();

        for (Session s : sessions) {
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException ex) {
                Logger.getLogger(HelloEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @OnOpen
    public void open(Session session, EndpointConfig conf) throws
            IOException {
        registry.add(session);
    }

    @OnClose
    public void close(Session session) {
        registry.remove(session);
    }

    @OnError
    public void onError(Throwable error) {
    }

}
