public abstract class Item {
    protected String nome;
    protected double damageMod, fireMod;

    public Item(String nome, double damageMod, double fireMod){
        this.nome = nome;
        this.damageMod = damageMod;
        this.fireMod = fireMod;
    }
}
