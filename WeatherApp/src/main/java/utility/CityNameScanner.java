package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CityNameScanner {
	private Scanner scanner;	
	
	
	public String getCityNameFromScanner() throws Exception{
		
		try{			
			System.out.println("To insert city name from console insert 'C', To read city name from input.txt file insert 'R': ");
			scanner = new Scanner(System.in);
			String decision = scanner.nextLine();
			
			if(decision.equalsIgnoreCase("C")){				
				System.out.println("Enter city name: ");
				String cityname = scanner.nextLine();
				return cityname;
				
			}else if(decision.equalsIgnoreCase("R")){				
				Scanner fileIn = new Scanner(new File("C:/Users/Tanel/Documents/GitHub/automaattestimine/input.txt"));
				String cityname = fileIn.nextLine();
				return cityname;			
			}
			
		}catch(Exception e){
			throw new Exception("Reading inserted value or reading file failed");
		}
		return null;
	}
}