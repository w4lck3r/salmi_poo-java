package com.company;

public class Interval {
    private int inf ;
    private int sup ;

public Interval(int low ,int high){
    this.inf = low ;
    this.sup = high ;
    }
public int getInf(){
    return this.inf;
}
public int getSup(){
    return this.sup;
}
public boolean isEmpty(){
    return this.inf > this.sup ;
}
public int lenght(){
    if(this.isEmpty()){
        return 0 ;
    }
    else {
        return this.sup - this.inf + 1;
    }
}
public boolean isThere(int a ){
    return (this.inf<=a) && (this.sup>=a) ;
}

public Interval intersect(Interval other){
    return new Interval(Math.min(this.inf, other.inf), Math.max(this.sup, other.sup));
}
public  Interval extend(int e){
    if(!this.isEmpty()){
        return  new Interval(this.inf , this.sup+1);
    }
    return this;
}
public Interval fusion(Interval other){
    if(this.isEmpty()){return other;}
    if(other.isEmpty()){return this;}
    return new Interval(Math.min(this.inf, other.inf),Math.max(this.sup , other.sup));
}
public String tostring(){
    return "["+this.inf+","+this.sup+"]";
}
public static void main(String[] args){
    Interval test = new Interval(1,7);
    Interval test1 = new Interval(4,10);
    test.getInf();
    test.getSup();
    test.isEmpty();
    test.lenght();
    test.isThere(5);
    test.extend(3);
    test.tostring();
    test.intersect(test1);
    test.tostring();
    test.fusion(test1);
    test.tostring();




}
}
