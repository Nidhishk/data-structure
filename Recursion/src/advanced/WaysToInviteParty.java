package advanced;

/**
 * Find the number of ways in which you can invite n people to your party, single or in pairs
 */
public class WaysToInviteParty {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(callGuests(n));
    }

    public static int callGuests(int n) {
        if (n <= 1) {
            return 1;
        }

        // Call Single
        int waysSingle = callGuests(n - 1);

        // Call Pair
        int waysPair = (n - 1) * callGuests(n - 2);

        return waysSingle + waysPair;
    }
}
