

public class Counter{    
    private double PRICE, DOWN, PROPERTY, INTEREST, YEARS;

    public Counter(double PRICE, double DOWN, double INTEREST, double YEARS){
        this.PRICE = PRICE;
        this.DOWN = DOWN;
        this.INTEREST = (INTEREST/100);
        this.YEARS = YEARS;
        this.PROPERTY = PRICE - (PRICE *( DOWN /100));
    }

    public double count(){
        return PROPERTY * ( (INTEREST * Math.pow((1+INTEREST), YEARS)) / ( Math.pow((1+INTEREST), YEARS) -1 ) );
    }

    public double getPRICE(){
        return PRICE;
    }
    public double getDOWN(){
        return DOWN;
    }
    public double getPROPERTY(){
        return PROPERTY;
    }
    public double getINTEREST(){
        return INTEREST;
    }
    public double getYEARS(){
        return YEARS;
    }
    

}
