import java.util.ArrayList;

public class Player {

    private int hp;
    private final int MAX_HP;
    private double baseDamage, finalDamage, baseFireRate, finalFireRate;
    private Active activeItem;
    private ArrayList<Passive> passiveItems;
    private Trinket trinket;
    private ArrayList<Collectible> collectibles;

    public Player(double baseDamage, double baseFireRate, int hp) {
        this.baseDamage = baseDamage;
        this.baseFireRate = baseFireRate;
        this.hp = MAX_HP = hp;

        this.collectibles = new ArrayList<>();
        this.passiveItems = new ArrayList<>();
    }

    public void updateStats(){
        finalDamage = baseDamage;
        finalFireRate = baseFireRate;

        if (activeItem != null){
            finalDamage *= activeItem.getDamageMod();
            finalFireRate *= activeItem.getFireMod();
        }
        if (trinket != null){
            finalDamage *= trinket.getDamageMod();
            finalFireRate *= trinket.getFireMod();
        }
        for(Passive p : passiveItems){
                finalDamage *= p.getDamageMod();
                finalFireRate *= p.getFireMod();
        }

    }

    public double getFinalDamage() {
        return finalDamage;
    }

    public double getFinalFireRate() {
        return finalFireRate;
    }

}
