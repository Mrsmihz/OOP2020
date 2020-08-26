public class Fraction {
    public int topN;
    public int btmN;

    public String toFraction(){
        String fraction = new String(topN + "/" + btmN);
        return fraction;
    }
    public String toFloat(){
        double a = topN, b = btmN;
        String float_string = new String(a/b + "");
        return float_string;
    }
    public void addFraction(Fraction f){
        btmN += f.btmN;
    }
    public boolean myEquals(Fraction x){
        return ((double)topN / (double)btmN) == ((double)x.topN / (double)x.btmN);
    }
    public void LowestTermFrac(){
        int gcd = gcd(topN, btmN);
        topN /= gcd;
        btmN /= gcd;
    }
    public int gcd(int top, int btm){
        if (btm == 0){
            return top;
        }
        return gcd(btm, top%btm);
    }
}
