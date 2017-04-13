package demo;

/**
 * Created by liyazhou on 2017/4/12.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerService extends Remote {
    public void serverMethod(ClientService cs) throws RemoteException;
}
