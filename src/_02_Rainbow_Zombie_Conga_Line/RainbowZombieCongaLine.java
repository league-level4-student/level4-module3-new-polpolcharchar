package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> node = new Node<Zombie>(dancer);
    	
    	congaLine.getHead().setPrev(node);
    	node.setNext(congaLine.getHead());
    	congaLine.setHead(node);

    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	congaLine.add(dancer);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	
    	if(position == 0) {
        	Node<Zombie> node = new Node<Zombie>(dancer);
        	
        	congaLine.getHead().setPrev(node);
        	node.setNext(congaLine.getHead());
        	congaLine.setHead(node);
        	return;
    	}
    	
    	
    	
    	Node<Zombie> currentValue = congaLine.getHead();
    	for(int i = 0; i < position-1; i++) {
    		currentValue = currentValue.getNext();
    	}
    	
    	Node<Zombie> node = new Node<Zombie>(dancer);
    	
    	node.setPrev(currentValue);
    	node.setNext(currentValue.getNext());
    	currentValue.setNext(node);
    	node.getNext().setPrev(node);
    	
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	int index = 0;
    	Node<Zombie> currentValue = congaLine.getHead();
    	while(currentValue != null) {
    		if(currentValue.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
    			congaLine.remove(index);
    			index--;
    		}
    		index++;
    		if(currentValue.getNext() == null) {
    			return;
    		}
    		currentValue = currentValue.getNext();
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {

    	int index = 0;
    	Node<Zombie> currentValue = congaLine.getHead();
    	while(currentValue.getNext() != null) {
    		if(currentValue.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
    			congaLine.remove(index);
    			return;
    		}
    		index++;
    		currentValue = currentValue.getNext();
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	//works pretty sure
    	
    	
    	//add 1 to end
    	congaLine.add(dancer);
    	
    	//add 1 to beginning
    	Zombie dupe1 = new Zombie(dancer.getZombieHatColor());
    	Node<Zombie> node1 = new Node<Zombie>(dupe1);
    	
    	congaLine.getHead().setPrev(node1);
    	node1.setNext(congaLine.getHead());
    	congaLine.setHead(node1);
    	
    	//add 1 to middle
    	int count = 0;
    	Node<Zombie> currentValue = congaLine.getHead();
    	while(currentValue.getNext() != null) {
    		count++;
    		currentValue = currentValue.getNext();
    	}
    	currentValue = congaLine.getHead();
    	for(int i = 0; i < count/2; i++) {
    		currentValue = currentValue.getNext();
    	}
    	
    	Zombie dupe2 = new Zombie(dancer.getZombieHatColor());
    	Node<Zombie> node2 = new Node<Zombie>(dupe2);
    	
    	node2.setPrev(currentValue);
    	node2.setNext(currentValue.getNext());
    	currentValue.setNext(node2);
    	node2.getNext().setPrev(node2);
    	
    	
    	
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	congaLine.add(dancer);
    	ZombieHatColor colors[] = ZombieHatColor.values();
    	for(ZombieHatColor c : colors) {
    		congaLine.add(new Zombie(c));
    	}
    	
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
