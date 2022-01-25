package _01_Spies_On_A_Train;

import java.util.ArrayList;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {

    	
    	ArrayList<String> passengers = new ArrayList<String>();
    	ArrayList<Integer> counts = new ArrayList<>();
    	
    	Node<TrainCar> start = train.getHead();
    	while(start.getNext() != null) {
    		//System.out.println(start.getValue());
    		String dialog = start.getValue().questionPassenger();
    		//System.out.println(dialog);
    		for(String s : clues) {
    			if(dialog.contains(s)) {
    				//System.out.println("Contains dialog");
    				String suspect = dialog.substring(dialog.indexOf("saw ") + 4, dialog.indexOf(" ", dialog.indexOf("saw ") + 6));
    				//System.out.println("Suspect: " + suspect);
    				if(!passengers.contains(suspect)) {
    					//System.out.println("Passengers doesnt contain, add");
    					passengers.add(dialog.substring(dialog.indexOf("saw ") + 4, dialog.indexOf(" ", dialog.indexOf("saw ") + 6)));
    					counts.add(1);
    				}else {
    					//System.out.println("passengers does contain, increase");
    					counts.set(passengers.indexOf(suspect), counts.get(passengers.indexOf(suspect)) + 1);
    				}
    				//return dialog.substring(dialog.indexOf("saw ") + 4, dialog.indexOf(" ", dialog.indexOf("saw ") + 6));
    			}
    		}
    		
    		start = start.getNext();
    	}
    	int greatest = -1;
    	int greatestIndex = -1;
    	for(int i = 0; i < counts.size(); i++) {
    		if(counts.get(i) > greatest) {
    			greatest = counts.get(i);
    			greatestIndex = i;
    		}
    	}
    	return passengers.get(greatestIndex);
        //return "";

    }

}
