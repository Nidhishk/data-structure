import java.util.HashMap;

/*
Find Itinerary from Tickets
"Chennai" -> "Bengaluru"
"Mumbai" -> "Delhi"
"Goa" -> "Chennai"
"Delhi" -> "Goa"

Output:: "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Benagluru"
 */
public class FindItinerary {
    public static void main(String[] args) {
        HashMap<String, String> itinerary = new HashMap<>();
        itinerary.put("Chennai", "Bengaluru");
        itinerary.put("Mumbai", "Delhi");
        itinerary.put("Goa", "Chennai");
        itinerary.put("Delhi", "Goa");

        String start = getStartingPoint(itinerary);
        while (itinerary.containsKey(start)) {
            System.out.print(start + " -> ");
            start = itinerary.get(start);
        }
        System.out.print(start);
    }

    public static String getStartingPoint(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : map.keySet()) {
            revMap.put(map.get(key), key);
        }

        for (String key : map.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }
}
