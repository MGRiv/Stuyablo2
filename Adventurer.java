import java.util.Random;

public abstract class Adventurer{
    private String name;
    private int HP,Exp,Dex,Str,Int;

    Random rand = new Random();

    public Adventurer(){
	this("Letser");
    }
    public Adventurer(String g){
	setName(g);
	setHP(30);
	setExp(0);
	setDex(10);
	setStr(10);
	setInt(10);
    }
    public String getStats(){
	return this.getName() + " " + this.getHP()+"HP "+this.getStr()+"Str " + this.getDex()+"Dex " + this.getInt()+"Int ";
    }
    public void setDex(int q){
	this.Dex = q;
    }
    public void setName(String g){
	this.name = g;
    }
    public void setHP(int q){
	this.HP = q;
    }
    public void setExp(int q){
	this.Exp = q;
    }
    public String getName(){
	return name;
    }
    public int getHP(){
	return HP;
    }
    public int getExp(){
	return Exp;
    }
    public void setStr(int q){
	this.Str = q;
    }
    public int getStr(){
	return Str;
    }
    public int getInt(){
	return Int;
    }
    public int getDex(){
	return Dex;
    }
    public void setInt(int q){
	this.Int = q;
    }
    public boolean Hit(Adventurer other){
	return(((Math.abs((this.getDex()*2) - other.getDex()) / this.getDex()) * 100) > rand.nextInt(11));
    }
    public int DmgV(){
	return rand.nextInt(9);
    }
    public int Dmg(int base){
	return base + DmgV();
    }
    abstract void attack(Adventurer other);
    abstract void specialattack(Adventurer other);
}
