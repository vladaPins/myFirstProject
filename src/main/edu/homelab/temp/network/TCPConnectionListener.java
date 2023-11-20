package edu.homelab.temp.network;

public interface TCPConnectionListener {
    void onConnectionReader(TCPConnection tcpConnection);
    void onReceiveString(TCPConnection tcpConnection, String value);
    void onDisconnect(TCPConnection tcpConnection);
    void onException(TCPConnection tcpConnection, Exception e);
}

