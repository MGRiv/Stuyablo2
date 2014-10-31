public class Driver{
    public static void main(String[]args){
	Warrior p2 =new Warrior("Grobnar");
	p2.setRage(20);
	Wizard p3 = new Wizard("Merlin");
	Rogue p4 = new Rogue("Inigo Montoya");

	System.out.println(p2.getStats());
	System.out.println(p3.getStats());
	System.out.println(p4.getStats());
	System.out.println();

	p2.attack(p3);
	p2.specialattack(p3);
	System.out.println();

	p3.attack(p4);
	p3.specialattack(p4);
	System.out.println();

	p4.attack(p2);
	p4.specialattack(p2);
	System.out.println();

	System.out.println(p2.getStats());
	System.out.println(p3.getStats());
	System.out.println(p4.getStats());
	System.out.println();
    }
}
