/**
 * Created by rvanduijnhoven on 05/10/2015.
 */
public class Match {
    private Player p1;
    private Player p2;

    public Match(Player p1, Player p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString()
    {
        String s = "Player 1: " + p1.toString() + ", player 2: " + p2.toString();
        return s;
    }

    public Player getP1()
    {
        return p1;
    }

    public Player getP2()
    {
        return p2;
    }


}
