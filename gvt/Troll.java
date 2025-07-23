package unit07.gvt;

public abstract class Troll {
    protected String name;
    protected int maxHP;
    protected int currentHP;

    public Troll(String name, int maxHP){
        this.name=name;
        this.maxHP=maxHP;
        currentHP=maxHP;
    }

    public boolean isVanquished(){
        return currentHP <= 0;
    }

    public void regenerate(){
        if(!isVanquished()){
            this.currentHP+=(int)(this.maxHP*regenAmount)
        }
    }

    public abstract Attack attack();
    
}
