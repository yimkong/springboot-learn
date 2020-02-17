package com.example.demo.utils;

import java.net.InetAddress;
import java.net.Socket;

/**
 * author yg
 * description
 * date 2020/2/16
 */
public class NetUtils {
    public static boolean isLocalPortUsing(int port) {
        boolean flag = true;
        try {
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
        }
        return flag;
    }

    private static boolean isPortUsing(String host, int port) {
        boolean flag = false;
        try {
            InetAddress theAddress = InetAddress.getByName(host);
            Socket socket = new Socket(theAddress, port);
            socket.close();
            flag = true;
        } catch (Exception e) {

        }
        return flag;
    }
}
