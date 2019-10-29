public class ClimbingStairs {
    public int climbStairs(int n){
        if(n <= 2){
            return n;
        }else{
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public int climbStairs2(int n){
        if(n <= 1){
            return 1;
        }

        int oneStep = 1, twoStep = 1, res = 0;

        for(int i = 2; )

    }
}
