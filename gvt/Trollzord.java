package unit07.gvt;

public class Trollzord extends Troll {
    
    public Trollzord(){
        super("Trollzord",64);
    }

    @Override
    public Attack attack(){
        double modifier = 1.0;
        if(attack.getDamageType()==DamageType.Holy){
            modifier=1.25;
        }
    }
}
