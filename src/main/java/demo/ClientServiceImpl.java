package demo;

/**
 * Created by liyazhou on 2017/4/12.
 */

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class ClientServiceImpl extends UnicastRemoteObject implements
        ClientService {
    private static final long serialVersionUID = 1L;

    protected ClientServiceImpl(int arg0, RMIClientSocketFactory arg1,
                                RMIServerSocketFactory arg2) throws RemoteException {
        super(arg0, arg1, arg2);
    }

    public String clientMethod(String a) throws RemoteException {
        System.out.println("client method arg value:" + a);
        return "client method return value";
    }
}