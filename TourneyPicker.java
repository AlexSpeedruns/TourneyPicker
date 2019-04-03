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
		int count = 1;
		boolean reshuffle = false;
		boolean draw = false;
		
		File file = new File("stages.txt");
		String line;
		int length = 0;
			
		try { //Puts file of stages into arraylist stages
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
			
		while(cont) {
			
			while(true) {	
				if(!reshuffle) {
					System.out.println("Game " + count + "\n");
				}
				else {
					System.out.println("Game " + count + " Reshuffle\n");
				}

				for(int i = 0; i < 5; i++) {
					int num = (int)(Math.random() * length);
					String st = stages.get(num);
					if(!used.contains(st) && !current.contains(st)) { //if stage was not already picked and not in current set
						System.out.println(i+1 + ". " + st);
						current.add(st);
						if(count == 1 || draw) {
							used.add(st);
						}
					}
					else {
						i--;
					}
				}
				
				if(!reshuffle) {
					System.out.print("\nReshuffle? ");
					String shuffle = sc.nextLine();
					System.out.println();
					if(shuffle.equals("yes")) {
						reshuffle = true;
						if(count > 1) {
							for(int i = 0; i < current.size(); i++) {
								used.add(current.get(i));
							}
						}
					}
					else {
						break;
					}
				}
				else {
					System.out.println();
					reshuffle = false;
					break;
				}
			}
			
			current.clear(); //clear current set
			
			if(count > 1 && !draw && count < 8) {
				System.out.print("\nWhich stage was banned: ");
				String pick = sc.nextLine();
				used.add(pick); //adds to the list of banned stages
				System.out.print("\nWhich stage was picked: ");
				pick = sc.nextLine();
				used.add(pick);
			}
			
			if(count > 2 && count < 7) {	
				System.out.print("\nGame " + (count+1) + "? ");
				String again = sc.nextLine();
				if(again.equals("yes")) {
					System.out.println();
					count++;
					reshuffle = false;
				}
				else {
					cont = false;
				}
			}
			else {
				System.out.println();
				count++;
			}
			
			if(count < 8) {
				System.out.print("Draw? ");
				String d = sc.nextLine();
				if(d.equals("yes")) {
					draw = true;
				}
				else {
					draw = false;
				}
				System.out.println();
			}
			else {
				cont = false;
			}
		}
	}
}