package network.socket.rmi;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockService implements ClockInterface {
    @Override
    public LocalDateTime getTime(String zoneId) throws RemoteException{
        return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
    }
}
