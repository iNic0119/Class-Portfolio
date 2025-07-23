package unit07.gvt;

public class Fighter extends Goat {


    public Fighter(String name){
        super(name,150);

    }

    @Override
    public Attack attack(){
        String attackName = "Cleave";
        int[] nOH = {25};
        DamageType dt = DamageType.Physical;
        Attack attack = new Attack(attackName,nOH,dt);
        return attack;
    }

    @Override
    public void takeDamage(Attack attack){
        double adjustment=1.0;
        DamageType type = attack.getDamageType();
        if(type==DamageType.Magical){
            adjustment=1.25;
        }else if(type==DamageType.Physical){
            adjustment=0.75;
        }
        for(int hit: attack.getNumOfHits()){
            currentHP-=(hit*adjustment);
        }
        currentHP=currentHP>0?currentHP:0;
    }


    public static void main(String[] args){
        Fighter fighter1 = new Fighter("Jon");
        Fighter fighter2 = new Fighter("Gary");

        fighter1.takeDamage(fighter2.attack());
        fighter2.takeDamage(fighter2.attack());

        System.out.println(fighter1.toString());
        System.out.println(fighter2.toString());
    }
}
