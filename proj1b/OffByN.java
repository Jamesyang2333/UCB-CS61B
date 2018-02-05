public class OffByN implements CharacterComparator {
    private int n;
    public OffByN(int a){
        n = a;
    }
    public boolean equalChars(char x, char y){
        if(Math.abs(x - y) == n)
            return true;
        else return false;
    }
}
