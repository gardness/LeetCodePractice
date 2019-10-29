public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int firMin = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firMin) {
                firMin = num;
            } else if (num < secMin) {
                secMin = num;
            } else if (num > secMin){
                return true;
            }
        }

        return false;
    }
}
