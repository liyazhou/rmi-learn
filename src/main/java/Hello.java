/**
 * Created by liyazhou on 2017/4/11.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote { // 远程对象的接口必须拓展 java.rmi.Remote 接口
    String sayHello() throws RemoteException; // 接口中所有方法必须抛出 RemoteException 异常， 因为远程调用缺乏可靠性，总是存在失败的可能。
}