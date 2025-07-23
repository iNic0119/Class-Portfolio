package unit07.gvt;

public abstract class Goat {
    protected String name;
    protected final int maxHP;
    protected int currentHP;

    public Goat(String name,int maxHP){
        this.name=name;
        this.maxHP=maxHP;
        currentHP=100;
    }

    @Override
    public String toString(){
        return "A mage named "+name+" with "+currentHP+"/"+maxHP+" hit points!";
    }

    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);

    public void heal(int amount){
        currentHP+=amount;
        currentHP=currentHP<maxHP?currentHP:maxHP;
    }

    public boolean isUnconscious(){
        if(currentHP>0){
            return false;
        }else{
            return true;
        }
    }
}
