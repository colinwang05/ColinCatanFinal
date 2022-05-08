public class Pair {
private int first;
private int second;
    public Pair(int first, int second){
    this.first=first;
    this.second=second;
}
public int first(){
        return first;

}
public int second(){
        return second;
}
public String toString(){
        return first+" "+second;
}
public boolean equals(Pair p){
        return p.first==first&&p.second==second;
}


}
