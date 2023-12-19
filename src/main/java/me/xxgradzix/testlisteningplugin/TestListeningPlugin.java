package me.xxgradzix.testlisteningplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.net.http.WebSocket;

public final class TestListeningPlugin extends JavaPlugin {

    private MyWebSocketServer webSocketServer;

    @Override
    public void onEnable() {
        // Inicjalizacja i uruchomienie serwera WebSocket
        webSocketServer = new MyWebSocketServer(8080); // Wybierz odpowiedni port
        webSocketServer.start();
    }

    @Override
    public void onDisable() {
        try {
            webSocketServer.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
