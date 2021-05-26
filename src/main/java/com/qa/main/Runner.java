package com.qa.main;


import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	
	
	private static Scanner scan = new Scanner(System.in);


	public static void main(String[] args) throws SQLException {
		
		
		DBConnection dbCon = new DBConnection();
		
		String action;
		
		action = getAction();
		
		try  {
			do {
				switch(action) {
				case "create":
					System.out.println("Please enter a name: ");
					String name = scan.nextLine();
					dbCon.create(name);
					break;
				case "read":
					System.out.println("displaying data");
					dbCon.read();
					break;
				case "read one":
					System.out.println("please enter id");
					int id = scan.nextInt();
					scan.nextLine();
					dbCon.readOne(id);
					break;
				case "update":
					System.out.println("please enter an id to update");
					int uId = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter a new name: ");
					String Uname = scan.nextLine();
					dbCon.update(uId, Uname);
					break;
				case "delete":
					System.out.println("please enter an id");
					int id2 = scan.nextInt();
					scan.nextLine();
					dbCon.delete(id2);
					break;
					
					default:
						System.out.println("no  mathhc found");
						break;
				}
				action = getAction();
				
				
			} while(!action.equals("exit"));
			System.out.println("cya later!");	
		} finally {
			scan.close();
			dbCon.tearDown();
	}
}
		
		private static String getAction() {
			String menuMsg = "==================================================\n"+"IMS System:\n"+ "==================================================\n"                 
					+ "\t- Create\t create a new customer" + "\n"                
					+ "\t- Read\t\t Read all customers" + "\n"                 
					+ "\t- Read one\t Read one customers" + "\n"                 
					+ "\t- Update\t Update a customer" + "\n"                 
					+ "\t- Delete\t Delete a customer" + "\n"                 
					+ "\t=====\n"                 
					+ "\t- Exit\t\t Exit Application\n"                 
					+ "==================================================\n";         
			System.out.println(menuMsg+ "What do you want to do next?");         
			return scan.nextLine().toLowerCase();  
			
			};
	
		
}
//try {
//Connection con = DriverManager.getConnection("jbdc:mysql://localhost:3306/jbdc_example?db_name&serverTimezone=UTC"
//		, "root", "mJ051396");
//PreparedStatement ps = con.prepareStatement("INSERT INTO people (name) values(?)");
//ps.setString(1, "Ed");
//
//ps.execute();
//
//
//
//;			ResultSet rs = ps.executeQuery("SELECT * FROM people");
//while(rs.next()) {
//	System.out.println(String.format("ID: %d, Name: %s", rs.getInt("id"), rs.getString("name")));
//}
//con.close();
//
//} catch (SQLException e) {
//e.printStackTrace();
//}
//}
