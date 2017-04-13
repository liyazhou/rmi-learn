package demo;

/**
 * Created by liyazhou on 2017/4/12.
 */

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        String serverIp = "192.168.112.245";
        if (args.length > 0) {
            serverIp = args[0];
        }
        String regIP = serverIp;
        int regPort = 40001;

        StaticRmiSocketFactory regFac = new StaticRmiSocketFactory(regIP, regPort);
        Registry reg = LocateRegistry.createRegistry(regPort, regFac, regFac);


        String exportIp = serverIp;
        int exportPort = 40002;
        StaticRmiSocketFactory exportFac = new StaticRmiSocketFactory(exportIp, exportPort);
        ServerService ss = new SomeServiceImpl(exportPort, exportFac, exportFac);


        reg.bind("SomeService", ss);
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}