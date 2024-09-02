/* Given an integer array of size n, find all elements that appear more than n/3 | times.
nums[] = (1, 3, 2, 5, 1, 3, 1, 5, 1), ฑ= 9 // 1
nums[] = (1, 2);
*/

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        //int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        int nums[] = {1, 2};
        findMajorElements(nums);
    }

    private static void findMajorElements(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            if (hashMap.get(key) == null) {    // Key doesn't exist
                hashMap.put(key, 1);
            } else {    // Key exist
                int frequency = hashMap.get(key);
                hashMap.put(key, frequency + 1);
            }
        }

        System.out.println("Majority Elements :: ");
        for (int i : hashMap.keySet()) {
            int frequency = hashMap.get(i);
            if (frequency > (n / 3)) {
                System.out.println(i);
            }
        }
    }
}


