package unit07.gvt;

public class Attack {
    private final String name;
    private final int[] numOfHits;
    private final DamageType dt;

    public Attack(String n,int[] nOH, DamageType damagetype){
        name = n;
        numOfHits=nOH;
        dt=damagetype;
    }

    public String getName(){
        return name;
    }

    public int[] getNumOfHits(){
        return numOfHits;
    }

    public DamageType getDamageType(){
        return dt;
    }

    @Override
    public String toString(){
        return name+" hits "+numOfHits.length+" times for "+dt+" type!";

    }


    
}
