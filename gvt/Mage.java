package unit07.gvt;

public class Mage extends Goat {

    public Mage(String name){
        super(name,100);
    }

    @Override
    public Attack attack(){
        String attackName = "Magic Missiles";
        int[] nOH = {9,9,9,9};
        DamageType dt = DamageType.Magical;
        Attack attack = new Attack(attackName,nOH,dt);
        return attack;
    }

    @Override
    public void takeDamage(Attack attack){
        double adjustment=1.0;
        DamageType type = attack.getDamageType();
        if(type==DamageType.Magical){
            adjustment=0.75;
        }else if(type==DamageType.Physical){
            adjustment=1.25;
        }
        for(int hit: attack.getNumOfHits()){
            currentHP-=(hit*adjustment);
        }
        currentHP=currentHP>0?currentHP:0;
    }
                    
                 
    

    public static void main(String[] args){
        Mage mage1 = new Mage("Tony");
        Mage mage2 = new Mage("Jeremy");

        mage1.takeDamage(mage2.attack());
        mage2.takeDamage(mage1.attack());

        System.out.println(mage1.toString());
        System.out.println(mage2.toString());
    }
}


    

