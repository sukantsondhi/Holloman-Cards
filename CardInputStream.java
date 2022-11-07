import java.io.*;
// import java.util.*;



public class CardInputStream extends InputStream{

    InputStream input;
    BufferedReader reader;
    Card card2;


    public CardInputStream(InputStream input){

        reader = new BufferedReader(new InputStreamReader(input));

    }

    @Override
    public int read() {
        return 0;
    }

    public void close() {
        try {
            input.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("Errors Caught");
            System.out.println(e);
        }
    }

    
    public Card readCard() {

        // int count = 0;

        try {
            String s = reader.readLine();

            if (s.equals("OK")) {
                return null;
            }
            else if (s.equals("CARD")) {
                
                Long cardID = Long.valueOf(reader.readLine());
                String cardName = reader.readLine();
                Rank cardRank = Rank.valueOf(reader.readLine());
                // Long cardPrice = Long.valueOf(reader.readLine());

                // System.out.println("CARD");
                // System.out.println("ID > " + cardID);
                // System.out.println("Name > " + cardName);
                // System.out.println("Rank > " + cardRank);
                // System.out.println("Price > " + cardPrice);


                card2 = new Card(cardID, cardName, cardRank);
                return card2;
            }
        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e);
        }
        return null;
            
    }

    public String readResponse() throws IOException {
        return reader.readLine();
    }

}
        

    

    



    



