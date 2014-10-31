public class Rogue extends Adventurer{
    private int stamina,bonusDex;
    
    public Rogue(String g){
	super(g);
	setDex(getDex() + 2);
	setStamina(200);
    }
    public String getStats(){
	return super.getStats()+ this.getStamina()+"Stamina";
    }
    public void setStamina(int q){
	stamina = q;
    }
    public int getDex(){
	return super.getDex();
    }
    public int getStamina(){
	return stamina;
    }
    void attack(Adventurer other){
	if(Hit(other)){
	    int i = Dmg(6);
	    System.out.println(this.getName()+" stabs "+other.getName() + " dealing " + i + " damage");
	    other.setHP(other.getHP() - i);
	}else{
	    System.out.println(this.getName()+" missed");
	}}
    void specialattack(Adventurer other){
	if(this.getStamina() >= 20){
	    this.setStamina(this.getStamina() - 20);
	    if(Hit(other)){
		int i = Dmg(9);
		System.out.println(this.getName()+" Vulcan neckbenches "+other.getName() + " dealing " + i + " damage");
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
