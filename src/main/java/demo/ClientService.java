package demo;

/**
 * Created by liyazhou on 2017/4/12.
 */

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientService extends Remote, Serializable {
    public String clientMethod(String a) throws RemoteException;
}