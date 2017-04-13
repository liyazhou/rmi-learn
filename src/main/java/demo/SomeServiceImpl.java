package demo;

/**
 * Created by liyazhou on 2017/4/12.
 */

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class SomeServiceImpl extends UnicastRemoteObject implements ServerService {

    private static final long serialVersionUID = 1L;

    protected SomeServiceImpl(int port, RMIClientSocketFactory csf,
                              RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    public void serverMethod(ClientService cs) throws RemoteException {
        String ip = cs.clientMethod("server method send value");
        System.out.println("server method print ++ client method return is :" + ip);

    }

}

