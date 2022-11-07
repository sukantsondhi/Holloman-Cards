import java.util.HashSet;
import java.util.Set;

public class CardTest {

    public static void main(String[] args) {

        Card c0 = new Card(1, "card1", Rank.COMMON);
        Card c1 = new Card(2, "card2", Rank.COMMON);
        Card c2 = new Card(1, "card1", Rank.COMMON);
        StringBuilder sb0 = new StringBuilder("card1");
        String s0 = sb0.toString();
        Card c3 = new Card(1, s0, Rank.COMMON);
        System.out.println(c0.compareTo(c2));

        System.out.println(sb0);
        System.out.println(c0.compareTo(c1));
        System.out.println(c1.toString());




    }
}