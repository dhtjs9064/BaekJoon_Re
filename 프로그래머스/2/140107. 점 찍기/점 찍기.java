public class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // 각 x에 대해 k값 만큼 늘어날때 y값은 얼만큼 늘어날 수 있는지 셈 = 점 개수
        for(int x = 0; x <= d; x += k)
        {
            long dd = (long) d * d;
            long ii = (long) x * x;
            // y의 범위
            int top = (int) Math.sqrt(dd - ii);
            // y에서 d 전까지 찍을 수 있는 개수
            answer += (top / k) + 1;
        }
        return answer;
    }
}
