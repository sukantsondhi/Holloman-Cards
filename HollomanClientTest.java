import java.net.Socket;
import java.util.List;

public class HollomanClientTest {
    
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("netsrv.cim.rhul.ac.uk", 1812);

        HollomonClient hc0 = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
        List n = hc0.login("realize", "painopportunityland");
        hc0.close();
        
    }
}
