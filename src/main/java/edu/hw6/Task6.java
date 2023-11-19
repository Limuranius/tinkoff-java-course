package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;
import static java.util.Map.entry;

public final class Task6 {
    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 49151;
    private static final String USED = "Used";
    private static final String FREE = "Free";

    private static final Map<Integer, String> COMMON_PORTS = Map.ofEntries(
        entry(80, "HTTP"),
        entry(443, "HTTPS"),
        entry(21, "FTP"),
        entry(22, "FTPS / SSH"),
        entry(110, "POP3"),
        entry(995, "POP3 SSL"),
        entry(143, "IMAP"),
        entry(993, "IMAP SSL"),
        entry(25, "SMTP"),
        entry(587, "SMTP SSL"),
        entry(3306, "MySQL"),
        entry(2082, "cPanel"),
        entry(2083, "cPanel SSL"),
        entry(2086, "WHM (Webhost Manager)"),
        entry(2087, "WHM (Webhost Manager) SSL"),
        entry(2095, "Webmail"),
        entry(2096, "Webmail SSL"),
        entry(2077, "WebDAV/WebDisk"),
        entry(2078, "WebDAV/WebDisk SSL")
    );

    private Task6() {
    }

    private static boolean isTCPPortFree(int port) {
        try (ServerSocket socket = new ServerSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static boolean isUDPPortFree(int port) {
        try (DatagramSocket socket = new DatagramSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String getPortInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Port     TCP     UDP     Port info\n");
        for (int port = MIN_PORT; port < MAX_PORT; port++) {
            String tcpStatus = USED;
            String udpStatus = USED;
            String protocolInfo = "";
            if (isTCPPortFree(port)) {
                tcpStatus = FREE;
            }
            if (isUDPPortFree(port)) {
                udpStatus = FREE;
            }
            if (COMMON_PORTS.containsKey(port)) {
                protocolInfo = COMMON_PORTS.get(port);
            }
            sb.append(port)
                .append("\t")
                .append(tcpStatus)
                .append("\t")
                .append(udpStatus)
                .append("\t")
                .append(protocolInfo)
                .append("\n");
        }
        return sb.toString();
    }
}
