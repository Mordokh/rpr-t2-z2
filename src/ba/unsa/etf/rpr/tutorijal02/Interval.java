package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double start, end;
    private boolean pristart, priend;

    public Interval (int x, int y, boolean prix, boolean priy){
        try{
            if (x>y) {
                throw new IllegalArgumentException("Pocetna tack ne moze biti veca od krajnje");
            }
            else{
                start=x;
                end=y;
                pristart=prix;
                priend=priy;
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public Interval(){
        start=0;
        end=0;
        boolean pristart=false;
        boolean priend=false;
    }


    public boolean isNull()

}
