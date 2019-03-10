import java.util.*;
import java.io.*;
import java.lang.Math;

public class TourneyPicker {
	public static void main(String[] args) {
		boolean cont = true;
		System.out.println("Welcome to Tourney Picker\n");
		while(cont) {
			File file = new File("stages.txt");
			String line;
			ArrayList<String> stages = new ArrayList<String>(0);
			ArrayList<String> used = new ArrayList<String>(0);
			int size = 0;
			try {
				size = Integer.parseInt(args[0]);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				while((line = br.readLine()) != null) {
					stages.add(line);
				}
				br.close();
			}
			catch(FileNotFoundException e) {
					
			}
			catch(IOException e) {
					
			}
			catch(IllegalArgumentException e) {
				System.out.println("Argument must be an integer");
			}
			System.out.println("Here are your " + args[0] + " stages\n");
			for(int i = 0; i < size; i++) {
				int num = (int)(Math.random() * 150);
				String st = stages.get(num);
				if(!used.contains(st)) {
					System.out.println(st);
				}
				else {
					i--;
				}
			}
			System.out.print("\nWhich stage was picked: ");
			Scanner sc = new Scanner(System.in);
			String pick = sc.next();
			used.add(pick);
			System.out.print("\nPick again: ");
			String again = sc.next();
			if(again.equals("yes")) {
				System.out.println("\n");
				
			}
			else {
				cont = false;
			}
		}
	}
}