import java.util.*;

public class LilyHomework {
    public static int lilysHomework(List<Integer> arr) {
        List<Integer> copy = new ArrayList<>(arr);
        List<Integer> copy1 = new ArrayList<>(arr);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Collections.sort(copy);
        int count1 = 0, count2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), i);
        }
        for (int i = 0; i < copy.size(); i++) {
            if (arr.get(i) != copy.get(i)) {
                Integer tmp = arr.get(i);
                arr.set(i, arr.get(map.get(copy.get(i))));
                arr.set(map.get(copy.get(i)), tmp);
                map.put(tmp, map.get(copy.get(i)));
                count1++;
            }
        }
        Collections.sort(copy, Collections.reverseOrder());
        for (int i = 0; i < arr.size(); i++) {
            map2.put(copy1.get(i), i);
        }
        for (int i = 0; i < copy.size(); i++) {
            if (copy1.get(i) != copy.get(i)) {
                Integer tmp = copy1.get(i);
                copy1.set(i, copy1.get(map.get(copy.get(i))));
                copy1.set(map2.get(copy.get(i)), tmp);
                map2.put(tmp, map2.get(copy.get(i)));
                count2++;
            }
        }
        return Math.min(count1, count2);
    }
}
