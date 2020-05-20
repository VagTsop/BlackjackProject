/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.Session;

/**
 *
 * @author Spyros
 */
// Must make this class Singleton
public class SessionRegistry {

    private static SessionRegistry INSTANCE;

    private Set<Session> sessions = new HashSet<>();

    private SessionRegistry() {
    }
// Multi threading

    public synchronized static SessionRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SessionRegistry();
        }
        return INSTANCE;
    }

    public Set<Session> getAllSessionsLocked() {
        return Collections.unmodifiableSet(sessions);
    }

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public int getPeople() {
        return sessions.size();
    }
}
