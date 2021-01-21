package network.socket.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface ClockInterface extends Remote {
    // 实现java RMI时， 每个服务端的RMI接口都必须从 Remote 派生, 并且必须抛出 RemoteException 异常.
    LocalDateTime getTime(String zoneId) throws RemoteException;
}
