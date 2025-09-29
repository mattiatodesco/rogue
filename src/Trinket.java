public class Trinket extends Item implements Collectible{

    public Trinket(String nome, double damageMod, double fireMod) {
        super(nome, damageMod, fireMod);
    }
    
    @Override
    public boolean canDropped() {
        return true;
    }
}