public class Warrior extends Adventurer{
    private int rage;
    
    public Warrior(String g){
	super(g);
	setRage(20);
	setHP(getHP() + 20);
	setDex(getDex() + 1);
    }
    public String getStats(){
	return super.getStats()+ this.getRage()+"Rage";
    }
    public void setRage(int q){
	rage = q;
    }
    public int getRage(){
	return rage;
    }
    public int getHP(){
	return super.getHP();
    }
    public int getDex(){
	return super.getDex();
    }
    void attack(Adventurer other){
	if(Hit(other)){
	    int i = Dmg(7);
	    System.out.println(this.getName()+" jabs "+other.getName() + " dealing " + i + " damage");
	    other.setHP(other.getHP() - i);
	    this.setRage(this.getRage() + 20);
	}else{
	    System.out.println(this.getName()+" missed");
	}}
    void specialattack(Adventurer other){
	if(this.getRage() >= 20){
	    this.setRage(this.getRage() - 20);
	    if(!(Hit(other))){
		int i = Dmg(12);
		System.out.println(this.getName()+" one finger death punches "+other.getName()  + " dealing " + i + " damage");
		other.setHP(other.getHP() - i);
	    }else{
		System.out.println(this.getName()+" missed");
	    }
	}else{
	    System.out.println("Did not have enough resources to perform a special attack. " + this.getName() + " performed a basic attack");
	    this.attack(other);
	}
    }
}
