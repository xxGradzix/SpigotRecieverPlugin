package me.xxgradzix.testlisteningplugin;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class MyWebSocketServer extends WebSocketServer {

    public MyWebSocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("Nowe połączenie: " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Zamknięto połączenie: " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Otrzymano wiadomość od " + conn.getRemoteSocketAddress().getAddress().getHostAddress() + ": " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("Błąd połączenia: " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("Serwer WebSocket został uruchomiony na porcie " + getPort());
    }
}