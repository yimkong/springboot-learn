package com.example.demo;

import com.example.demo.utils.NetUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * author yg
 * description
 * date 2020/2/16
 */
@Slf4j
public class StartCommand {
    public StartCommand(String[] args) {
        boolean isServerPort = false;
        String serverPort = "";
        if (args != null) {
            for (String arg : args) {
                if (StringUtils.hasText(arg) && arg.startsWith("--server.port")) {
                    isServerPort = true;
                    serverPort = arg;
                    break;
                }
            }
        }
        //没有指定端口则随机一个端口
        if (!isServerPort) {
            int port = getAvailablePort();
            log.info("current port:[{}]", port);
            System.setProperty("server.port", String.valueOf(port));
        } else {
            log.info("current port:[{}]", serverPort.split("=")[1]);
        }
    }

    private static int getAvailablePort() {
        int max = 65535;
        int min = 2000;
        Random ran = new Random();
        int port = ran.nextInt(max) % (max - min + 1) + min;
        boolean localPortUsing = NetUtils.isLocalPortUsing(port);
        if (localPortUsing) {
           return getAvailablePort();
        } else {
            return port;
        }
    }

}
