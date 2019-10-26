package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double start, end;
    private boolean pristart, priend;


    public Interval (double x, double y, boolean prix, boolean priy){
        if (x>y) {
            throw new IllegalArgumentException();
        }
        else{
            start=x;
            end=y;
            pristart=prix;
            priend=priy;
        }

    }

    public Interval(){
        start=0;
        end=0;
        boolean pristart=false;
        boolean priend=false;
    }


    public boolean isNull(){
        if (start==0 && end==0 && !pristart && !priend){return true;}
        else {return false;}
    }

    public boolean isIn(double x){
        if (x>start && x<end){
            return true;
        }
        else if (x==start && pristart){
            return true;
        }
        else if (x==end && priend){
            return true;
        }
        else{
            return false;
        }
    }

    public Interval intersect(Interval x) {
        double startn=0, endn=0;
        boolean pristartn=false, priendn=false;

        if (x.start>=start){
            startn=x.start;
            pristartn=x.pristart;
        }
        else if (x.start<=start){
            startn=start;
            pristartn=pristart;
        }
        if (x.end>=end){
            endn=end;
            priendn=priend;
        }
        else if(x.end<=end){
            endn=x.end;
            priendn=x.priend;
        }

        return new Interval (startn, endn, pristartn, priendn);
    }

    public static Interval intersect(Interval x, Interval y) {
        double startn=0, endn=0;
        boolean pristartn=false, priendn=false;

        if (x.start>=y.start){
            startn=x.start;
            pristartn=x.pristart;
        }
        else if (x.start<=y.start){
            startn=y.start;
            pristartn=y.pristart;
        }
        if (x.end>=y.end){
            endn=y.end;
            priendn=y.priend;
        }
        else if(x.end<=y.end){
            endn=x.end;
            priendn=x.priend;
        }

        return new Interval (startn, endn, pristartn, priendn);
    }

    @Override
    public String toString(){
        String zagrada1=new String();
        String zagrada2=new String();
        if (pristart){
            zagrada1="[";
        }
        else if (!pristart){
            zagrada1="(";
        }
        if (priend){
            zagrada2="]";
        }
        else if (!priend){
            zagrada2=")";
        }

        if (start==0 && end==0 && !pristart && !priend){
            return "()";
        }
        return zagrada1+start+","+end+zagrada2;
    }

    @Override
    public boolean equals(Object o){
        if (o==this){
            return true;
        }
        if (!(o instanceof Interval)){
            return false;
        }
        Interval test=(Interval) o;

        if (start==test.start && end==test.end && pristart==test.pristart && priend==test.priend){
            return true;
        }

        else{
            return false;
        }
    }

}
