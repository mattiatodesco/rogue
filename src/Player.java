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
        System.out.printf("HP: %d | Final Fire Rate: %.2f | Final Damage: %.2f%n", hp, finalFireRate, finalDamage);
    }

    public void addItem(Item nuovo){
        if (nuovo instanceof Active)
            this.activeItem = (Active) nuovo;
        else if (nuovo instanceof Passive)
            this.passiveItems.add((Passive) nuovo);
        else if (nuovo instanceof Trinket)
            this.trinket = (Trinket) nuovo;
        
    }

    public Trinket dropTrinket(){
        Trinket temp = this.trinket;
        this.trinket = null;
        return temp;
    }

    public boolean checkCollectibles(){
        boolean trovati = false;
        for (int i = collectibles.size() - 1; i >= 0; i--) {
            if (collectibles.get(i) instanceof Trinket) {
                collectibles.remove(i);
                trovati = true;
            }
        }
        return trovati;
    }

    public double getFinalDamage() {
        return finalDamage;
    }

    public double getFinalFireRate() {
        return finalFireRate;
    }

}
