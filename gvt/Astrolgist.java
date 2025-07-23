package unit07.gvt;

public class Astrolgist extends Goat {

    public Astrolgist(String name){
        super(name,50);
    }

    public Attack attack(){
        String attackName = "Nebula";
        int[] nOH = {300};
        DamageType dt = DamageType.Holy;
        Attack attack = new Attack(attackName,nOH,dt);
        return attack;
    }

    public void takeDamage(Attack attack){
        double adjustment=1.0;
        DamageType type = attack.getDamageType();
        if(type==DamageType.Posion){
            adjustment=1.25;
        }
        for(int hit: attack.getNumOfHits()){
            currentHP-=(hit*adjustment);
        }
        currentHP=currentHP>0?currentHP:0;
    }
}
