public class Card implements Comparable<Card> {
    
    long ID;
    String name;
    Rank rank;
    long price;

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public long getPrice() {
        return price;
    }

    public Card(long ID, String name, Rank rank) {
        
        this.ID = ID;
        this.name = name;
        this.rank = rank;
        price = 0;
    }

    @Override
    public String toString() {
        return "Card [Rank: " + getRank() + ", Name: " + getName() + ", ID: " + getID() + ", Price: " + getPrice() +  "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ID ^ (ID >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Card)) {
            return false;
        }

        Card other = (Card) obj;

        return (this.ID == other.ID && this.rank == other.rank && this.name.equals(other.name)); 
    } 

    
    @Override
    public int compareTo(Card obj) { 
        
        // 0 = Draw
        // 1 = Win
        // -1 = Defeat

        int cardRank = this.rank.compareTo(obj.rank);

        if  (cardRank == 0) {
            int cardName = this.name.compareTo(obj.name);

            if (cardName == 0) {
                long cardID = this.ID;
                long card2ID = obj.ID;

                if (cardID > card2ID) {
                    return 1;
                }
                else if(cardID < card2ID) {
                    return -1;
                }
                else { 
                    return 0;
                }
            }

            return cardName;
        }

        return cardRank;
        

    }   
}



