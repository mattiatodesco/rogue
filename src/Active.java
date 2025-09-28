public class Active extends Item{
    private int chargeLevel;
    private final int MAX_CHARGE;

    public Active(double damageMod, double fireMod, int chargeLevel){
        super(damageMod, fireMod);
        this.chargeLevel = this.MAX_CHARGE = chargeLevel;
    }

    public boolean isLoaded(){
        return this.chargeLevel > 0;
    }
}