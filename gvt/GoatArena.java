package unit07.gvt;

public class GoatArena {

    public static void battle(Goat goat1, Goat goat2){

        while(goat1.isUnconscious()!=true&&goat2.isUnconscious()!=true){
            System.out.println(goat1.attack().toString());
            goat2.takeDamage(goat1.attack());
            System.out.println(goat2.attack().toString());
            goat1.takeDamage(goat2.attack());
            System.out.println("\n"+goat1.toString());
            System.out.println(goat2.toString());
            System.out.println();
        }

        if(goat1.isUnconscious()==true){
            System.out.println("Goat 2 has won!");
        }else{
            System.out.println("Goat 1 has won!");
        }
    }

    public static void main(String[] args) {
        Goat goat1 = new Mage("Joe");
        Goat goat2 = new Fighter("Poe");
        Goat goat3 = new Astrolgist("Boe");

        battle(goat1, goat2);
        battle(goat3, goat2);
        battle(goat1, goat3);
    }
    
}
