import java.util.HashSet;

class Solution {
        public int solution(int[] nums) {
        HashSet<Integer> pokemon = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            pokemon.add(nums[i]);
        }

        answer = pokemon.size();
        if (answer > nums.length / 2) {
            int temp = answer - nums.length / 2;
            answer -= temp;
        }

        return answer;
    }
}