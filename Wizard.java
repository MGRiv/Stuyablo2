public class Wizard extends Adventurer{
    private int mana;
    private int bonusDex;
    
    public Wizard(String g){
	super(g);
	setMana(200);
	setDex(getDex() - 1);
    }
    public String getStats(){
	return super.getStats()+ this.getMana()+"Mana";
    }
    public void setMana(int q){
	mana = q;
    }
    public int getMana(){
	return mana;
    }
    public int getDex(){
	return super.getDex();
    }
    void attack(Adventurer other){
	if(Hit(other)){
	    int i = Dmg(0);
	    System.out.println(this.getName()+" pokes "+other.getName()  + " dealing " + i + " damage");
	    other.setHP(other.getHP() - i);
	}else{
	    System.out.println(this.getName()+" missed");
	}}
    void specialattack(Adventurer other){
	if(this.getMana() >= 20){
	    this.setMana(this.getMana() - 20);
	    if(Hit(other)){
		int i = Dmg(10);
		System.out.println(this.getName()+" mindblasts "+other.getName() + " dealing " + i + " damage");
		other.setHP(other.getHP() - i);
	    }else{
		System.out.println(this.getName()+" missed");
	    }
	}else{
	    System.out.println("Did not have enough resources to perform a special attack." + this.getName() + "performed a basic attack");
	    this.attack(other);
	}
    }
}
