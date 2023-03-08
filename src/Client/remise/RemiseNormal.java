package Client.remise;

public class RemiseNormal implements Remise{
    public double remise(double total){
        return total*0.5;
    }
}
