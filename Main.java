import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> popularity = Arrays.asList(4,3,1,2);
        int result = minSwap(popularity);
        System.out.println(result);
    }


        public static int minSwap(List<Integer> popularity) {

            int n = popularity.size();

            Integer[] arr = popularity.toArray(new Integer[n]);
            Integer[] sorted_arr = arr.clone();
            Arrays.sort(sorted_arr, Collections.reverseOrder());

            Map<Integer, Integer> hm = new HashMap<>();
            for(int i=0; i<n; i++){
                hm.put(arr[i], i);
            }
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);

            int swaps = 0;

            for(int i=0; i<n; i++){
                if(visited[i] || arr[i] == (sorted_arr[i])){
                    continue;
                }

                int cycle_length = 0;
                int x = i;

                while(!visited[x]){
                    visited[x] = true;
                    x = hm.get(sorted_arr[x]);
                    cycle_length++;
                }

                if(cycle_length > 0){
                    swaps += (cycle_length - 1);
                }

            }
            return swaps;

        }
    }