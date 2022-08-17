package com.skillip.java;

import com.jcraft.jsch.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class Demo {
    public static void main(String[] args) {
        String user = "root";
        String host = "localhost";
        String password = "112358";
        int port = 10004;


        String command = "shutdown -h now \n";

        JSch jsch=new JSch();
        try {
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setUserInfo(new UserInfo() {
                @Override
                public String getPassphrase() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return null;
                }

                @Override
                public boolean promptPassword(String message) {
                    return false;
                }

                @Override
                public boolean promptPassphrase(String message) {
                    return false;
                }

                @Override
                public boolean promptYesNo(String message) {
                    return true;
                }

                @Override
                public void showMessage(String message) {

                }
            });
            session.connect(10000);
            boolean isConnected = session.isConnected();

            System.out.println(isConnected);
            Channel channel = session.openChannel("shell");

            channel.setInputStream(new ByteArrayInputStream(command.getBytes()));

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            channel.setOutputStream(System.out);

            System.out.println(new String(outputStream.toByteArray()));

            channel.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }
}
