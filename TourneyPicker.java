import java.util.*;
import java.io.*;
import java.lang.Math;

public class TourneyPicker {
	public static void main(String[] args) {
		boolean cont = true;
		System.out.println("Welcome to Tourney Picker\n");
		Scanner sc = new Scanner(System.in);
		ArrayList<String> stages = new ArrayList<String>(0);
		ArrayList<String> used = new ArrayList<String>(0);
		ArrayList<String> current = new ArrayList<String>(0);
		
		while(cont) {
			File file = new File("stages.txt");
			String line;
			int size = 0;
			int length = 0;
			
			try { //Puts file of stages into arraylist stages
				size = Integer.parseInt(args[0]);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					stages.add(line);
					length++;
				}
				br.close();
			}
			catch(FileNotFoundException e) {
					
			}
			catch(IOException e) {
					
			}
			catch(IllegalArgumentException e) { //args[0] is amount of stages to print, must be integer
				System.out.println("Argument must be an integer");
			}
			
			System.out.println("Here are your " + args[0] + " stages\n");

			for(int i = 0; i < size; i++) {
				int num = (int)(Math.random() * length);
				String st = stages.get(num);
				if(!used.contains(st) && !current.contains(st)) { //if stage was not already picked and not in current set
					System.out.println(i+1 + ". " + st);
					current.add(st);
				}
				else {
					i--;
				}
			}
			
			current.clear(); //clear current set
			
			System.out.print("\nWhich stage was picked: ");
			String pick = sc.nextLine();
			used.add(pick); //adds to the list of already picked stages
			
			System.out.print("\nPick again: ");
			String again = sc.nextLine();
			if(again.equals("yes")) {
				System.out.println();
				
			}
			else {
				cont = false;
			}
		}
	}
}