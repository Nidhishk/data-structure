package advanced;

/**
 * Place Tiles of size 1xm in a floor of size nxm
 *
 * ** This can also be done through Dynamic Programming to reduce the Time Complexity.
 */
public class PlaceTilesOnFloor {
    public static void main(String[] args) {
        int n = 4, m = 3;
        System.out.println(placeTiles(n, m));
    }

    // Find number of ways that tiles can arranged
    public static int placeTiles(int n, int m) {
        if (n == m) {
            return 2;
        }

        if (n < m) {
            return 1;
        }

        // Place tiles vertically
        int verticalPlacements = placeTiles(n - m, m);

        // Place tiles on Horizontally
        int horizontalPlacements = placeTiles(n - 1, m);

        return verticalPlacements + horizontalPlacements;
    }
}
