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

        if (activeItem != null && activeItem.isLoaded()){
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

    public void viewStats(){
        System.out.println("Final Damage: " + finalDamage);
        System.out.println("Final Fire Rate: " + finalFireRate);
    }

    public void addItem(Item nuovo){
        if (nuovo instanceof Active)
            this.activeItem = (Active) nuovo;
        else if (nuovo instanceof Passive)
            this.passiveItems.add((Passive) nuovo);
        else if (nuovo instanceof Trinket)
            this.trinket = (Trinket) nuovo;
        
    }

    public void dropTrinket(){
        this.trinket = null;
    }

    public boolean checkCollectibles(){
        for (Collectible c : collectibles){
            if (c instanceof Trinket)
                collectibles.remove(c);
        }
        return true;
    }

    public double getFinalDamage() {
        return finalDamage;
    }

    public double getFinalFireRate() {
        return finalFireRate;
    }

}
