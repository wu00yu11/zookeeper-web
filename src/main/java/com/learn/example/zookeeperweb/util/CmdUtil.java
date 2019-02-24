package com.learn.example.zookeeperweb.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public enum CmdUtil {

    INSTANCE;
    private final static Logger logger = LoggerFactory.getLogger(CmdUtil.class);

    public String executeCmd(String cmd, String zkServer, String zkPort) throws IOException {
        StringBuilder sb;
        try (Socket s = new Socket(zkServer, Integer.parseInt(zkPort)); PrintWriter out = new PrintWriter(s.getOutputStream(), true); BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
            out.println(cmd);
            String line = reader.readLine();
            sb = new StringBuilder();
            while (line != null) {
                sb.append(line);
                sb.append("<br/>");
                line = reader.readLine();
            }
        }
        return sb.toString();
    }
}
