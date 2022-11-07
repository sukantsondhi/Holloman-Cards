import java.io.*;
import java.net.*;
import java.util.*;


class CardCompare implements Comparator<Card> {
    
    public int compare(Card a, Card b) {
        return a.compareTo(b);
    }
}


public class HollomonClient {

    String server;
    int port;
    InputStream is;
    OutputStream os;
    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;
    
    
    

    public HollomonClient(String server, int port) {
        this.server = server;
        this.port = port;
    }

    public void close() {

        try{
            is.close();
            os.close();
            reader.close();
            writer.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("The following errors were caught: ");
            System.out.println(e);
        }

    }

    public List<Card> login(String username, String password) {
    
        List<Card> list = new ArrayList<Card>();

        try {
            socket = new Socket("netsrv.cim.rhul.ac.uk", 1812);
            is = socket.getInputStream();
            os = socket.getOutputStream();

            reader = new BufferedReader(new InputStreamReader(is));
            writer = new BufferedWriter(new OutputStreamWriter(os));

            
            writer.write(username.toLowerCase() + "\n" + password + "\n");
            writer.flush();


            if (reader.readLine().equals("User " + username + " logged in successfully.")) {

                CardInputStream cisList = new CardInputStream(is);
                Card string = cisList.readCard();

                while (string != null) {
                    list.add(string);
                    string = cisList.readCard();

                }

               
                Collections.sort(list, new CardCompare());  
                

                return list;

            } 
            else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("The following Exceptions were caught: ");
            System.out.println(e);
            close();
            return null;
        }
        
    }
}
