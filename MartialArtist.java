public class MartialArtist extends Adventurer{
    private int qi;

    public MartialArtist(String g){
	super(g);
	setQi(200);
    }
    public String getStats(){
	return super.getStats()+ this.getQi()+"Qi";
    }
    public void setQi(int q){
	qi = q;
    }
    public int getQi(){
	return qi;
    }
    void attack(Adventurer other){
	if(Hit(other)){
	    int i = Dmg(7);
	    System.out.println(this.getName()+" punches "+other.getName() + " dealing " + i + " damage");
	    other.setHP(other.getHP() - i);
	}else{
	    System.out.println(this.getName()+" missed");
	}}
    void specialattack(Adventurer other){
	if(this.getStamina() >= 20){
	    this.setStamina(this.getStamina() - 20);
	    if(Hit(other)){
		int i = Dmg(9);
		System.out.println(this.getName()+" hadoukens "+other.getName() + " dealing " + i + " damage");
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
