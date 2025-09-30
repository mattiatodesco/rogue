public class Active extends Item{
    private int chargeLevel;
    private final int MAX_CHARGE;

    public Active(String nome, double damageMod, double fireMod, int chargeLevel){
        super(nome, damageMod, fireMod);
        this.chargeLevel = this.MAX_CHARGE = chargeLevel;
    }

    public boolean isLoaded(){
        return this.chargeLevel == MAX_CHARGE;
    }

    public void reload(){
        chargeLevel = MAX_CHARGE;
    }
}