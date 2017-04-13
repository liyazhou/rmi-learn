package demo;

/**
 * Created by liyazhou on 2017/4/12.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws MalformedURLException,
            RemoteException, NotBoundException {
        String ServerIP = "192.168.112.245";
        if (args.length > 0) {
            ServerIP = args[0];
        }
        int serverRegPort = 40001;
//        String clientIP = "127.0.0.1";
        String clientIP = "192.168.112.245";
        if (args.length > 1) {
            clientIP = args[1];
        }
        int clientPort = 40003;
        StaticRmiSocketFactory expFac = new StaticRmiSocketFactory(clientIP,
                clientPort);
        ClientService cs = new ClientServiceImpl(0, expFac, expFac);
        String url = "rmi://" + ServerIP + ":" + serverRegPort + "/SomeService";
        ServerService ss = (ServerService) Naming.lookup(url);
        ss.serverMethod(cs);
        while (true) {
            try {
                Thread.sleep(1);
                ss.serverMethod(cs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
