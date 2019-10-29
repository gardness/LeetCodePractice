public class WaterandJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }

        if (x == z || y == z) {
            return true;
        }

        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }
}
