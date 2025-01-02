/*
**Course:	 COMP3380
**Instructor:    Patrick Dubois
**Project Part:		 2
**Name:		 Ginelle Temull, Braydon Schick
**
**Description: 	  hello
*/

// checking this pushs to origin from clone branch
// check 2

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class legoQueries {
	static Connection connection;

	public static void main(String[] args) throws Exception {

		// startup sequence
		MyDatabase db = new MyDatabase();

		//db.populateDatabase();

		runConsole(db);

		System.out.println("Exiting...");
	}

    
    

	public static void runConsole(MyDatabase db) {

		Scanner console = new Scanner(System.in);
		System.out.print("Welcome! Type h for help. ");
		System.out.print("lego > ");
		String line = console.nextLine();
		String[] parts;
		String arg = "";

		while (line != null && !line.equals("q")) {
			parts = line.split(",");
			if (line.indexOf(",") > 0)
				arg = line.substring(line.indexOf(",")+1).trim();

			if (parts[0].equals("h"))
				printHelp();
			else if (parts[0].equals("cp")) {
				try {

					if (parts.length >= 2)
						db.commonParts(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
				
			}

			else if (parts[0].equals("pt")) {
				try {

					if (parts.length >= 2)
						db.popThemes(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
				
			}

			else if (parts[0].equals("inspired")) {
				try {

					if (parts.length >= 2)
						db.partInspiredBy(arg);
					else
						System.out.println("Require an argument for this command");


				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
			}


			else if (parts[0].equals("mostColors")) {
				try {

				// 	if (parts.length >= 2)
						db.mostColors();
				// 	else
				// 		System.out.println("Require an argument for this command");

				
				} catch (Exception e) {
					System.out.println("id must be an integer");
				}
			}



			else if (parts[0].equals("ctpieces")) {
				try {

					if (parts.length >= 3)
						db.setsByPieceColorAndTheme(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
			}

		
			else if (parts[0].equals("excl")) {
				try {

					if (parts.length >= 3)
						db.setsExcludingPieces(arg); 
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}

				

			} 
			else if (parts[0].equals("mc")) {

				try {

					if (parts.length >= 3)
						db.mostRedPartsSet(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}

				
			}

			else if (parts[0].equals("noset")) {

				try {

					if (parts.length >= 2)
						db.partsNoSet(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}

				
			}

			else if (parts[0].equals("sc")) {
				try {

					if (parts.length >= 2)
						db.numPartsBySetByCategory(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}

				
			}

			else if (parts[0].equals("inv")) {
				try {

					if (parts.length >= 2)
						db.multiInv(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
				
			}
			else if (parts[0].equals("year")) {
				try {

					if (parts.length >= 3)
						db.setsByYearMinPieces(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}


				
			}
			else if (parts[0].equals("cc")) {
				try {

					if (parts.length >= 2)
						db.partsByCategory(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}

				
			}
			else if (parts[0].equals("mini")) {
				try {

					if (parts.length >= 2)
						db.setWithMini(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
					

			}
		
			else if (parts[0].equals("at")) {
				
				try {

					if (parts.length >= 2)
						db.avgPiecesTheme(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
				
			}
			

			else if (parts[0].equals("setwithout")) {
				
				try {

					if (parts.length >= 3)
						db.setWithout(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
				
			}

			else if (parts[0].equals("sm")) {
				
				try {

				// 	if (parts.length >= 2)
						db.sameMaterials();
				// 	else
				// 		System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("id must be an integer");
				
				}
			}
			else if (parts[0].equals("partsYear")) {
				if (parts.length >= 2){
						System.out.println(arg);
						db.numPartsPerYear(arg);
				}else{
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}

			}
			else if (parts[0].equals("wm")) {
				
				try {

					if (parts.length >= 3)
						db.withoutMaterial(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
				
			}
			else if (parts[0].equals("numColors")) {
				
				try {

					if (parts.length >= 2)
						db.numColors(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				
				}
		
			}


			else if (parts[0].equals("partsYear")) {

				
				try {

					if (parts.length >= 2)
						db.numPartsPerYear(arg);
					else
						System.out.println("Require an argument for this command");

				} catch (Exception e) {
					System.out.println("That input doesn't look right. Enter h to get help and see the command legend.");
				}
				
			}

			else if (parts[0].equals("populate")){
				db.populateDatabase();

			}

			else
				System.out.println("Read the help legend with h, or find help in the README.");

			System.out.print("lego > ");
			line = console.nextLine();
		}

		console.close();
	}

	private static void printHelp() {
		System.out.println("LEGO database");
		System.out.println("Enter a command below and be sure to use a comma to separate your <input>.");
		System.out.println("Commands:");
		System.out.println("h - Get help");

		System.out.println("cp,<number or all> - most common parts in <number> sets");
		System.out.println("year,<year>,<number> - Sets by <year> with less than <number> pieces");
		System.out.println("pt,<number or all> - Top <number> popular themes and set count");

		System.out.println("inspired,<number>,<part> - Top <number> sets with parts inspired by <part>");
		System.out.println("ctpieces,<number>,<color> - Top <number> sets with the most <color> parts and their theme");
		System.out.println("excl,<number>,<theme>,<mini figure> - Top <number> sets without a <mini figure> in a <theme>");
		System.out.println("sc,<set> - Number of part in each category of parts in <set>");
		System.out.println("inv,<number> - Top <number> set with the most inventories");
		
    System.out.println("cc,<number>,<category> - <number> part names in a <category>");
		System.out.println("mini,<number>,<mini> - Top <number> sets that include this <mini>");
		System.out.println("mc,<number>,<color> - Top <number> sets and image urls with at least a quarter of parts that are <color>");
		System.out.println("noset,<number> - <number> parts that are not included in a set");
		System.out.println("at,<number> - Top<number> themes that have the greatest average in pieces across all sets");

    
		System.out.println("setwithout,<number>,<part> - Top <number> of sets without <part>");
		System.out.println("sm - Sets with parts of all the same material");
		System.out.println("numColors,<set> - Number of colours in a <set>");
		System.out.println("mostColors - Set with the most variety in colors");
		System.out.println("wm,<number>,<material> - <number> of sets without parts of a certain <material>");
		System.out.println("partsYear,<year> - Average numParts in sets created in <year>");	
		System.out.println("populate - Add all tables and their data to database");

		System.out.println("q - Exit the program");

		System.out.println("---- end help ----- ");
	}



}

class MyDatabase {
	    private Connection connection;

        public MyDatabase() {
            Properties prop = new Properties();
			String fileName = "auth.cfg";
			try {
				FileInputStream configFile = new FileInputStream(fileName);
				prop.load(configFile);
				configFile.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Could not find config file.");
				System.exit(1);
			} catch (IOException ex) {
				System.out.println("Error reading config file.");
				System.exit(1);
			}
			String username = (prop.getProperty("username"));
			String password = (prop.getProperty("password"));

			if (username == null || password == null){
				System.out.println("Username or password not provided.");
				System.exit(1);
			}
				String url =
					"jdbc:sqlserver://uranium.cs.umanitoba.ca:1433;"
					+ "database=cs3380;"
					+ "user=" + username + ";"
					+ "password="+ password +";"
					+ "encrypt=false;"
					+ "trustServerCertificate=false;"
					+ "loginTimeout=30;";
			try{
				this.connection = DriverManager.getConnection(url);
				Statement statement = connection.createStatement();

				// connection = DriverManager.getConnection(url);
			} catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

		//cp <number>
		//The top 10 most common parts found in all sets ordered by the number of pieces in the collective sets. 
		public void commonParts(String num){
			try{
				if(num != null){
					int n = Integer.parseInt(num); 
					String sql = "SELECT TOP (?)   sets.name as SetName,   part.part_num,  MAX(part.name) as partName,  COUNT(part.part_num)*inventory_parts.quantity*inventory_sets.quantity AS partCount " +
							"FROM" + //
							"    inventory_parts " + //
							"JOIN" + //
							"    part  ON inventory_parts.part_num = part.part_num " + //
							"JOIN " + //
							"    inventory_sets ON inventory_parts.inventory_id = inventory_sets.inventory_id" + //
							" JOIN" + //
							" sets ON inventory_sets.set_num=sets.set_num" + //
							" GROUP BY" + //
							"    sets.name, part.part_num, part.name, inventory_parts.quantity, inventory_sets.quantity" + //
							" ORDER BY" + //
							"    partCount DESC" + //
							";";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setInt(1,n);
					ResultSet resultSet = statement.executeQuery(); 
					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}


					System.out.println("\nThe most common parts in all the sets:");




					while(resultSet.next()) {
							System.out.println("Set Name: " + resultSet.getString("SetName") + " | Part Number:  " + resultSet.getString("part_num") + " | Part Name:  " + resultSet.getString("partName") + " | Part Count: " + resultSet.getString("partCount"));
					}
			}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}

		//pt <number> 
		// The top 10 most popular themes and the number of sets of those themes. 
		public void popThemes(String num){
				try{

					if(num != null ){
						int n = Integer.parseInt(num); 
						String sql = "SELECT TOP (?) t.name AS themeName, COUNT(s.set_num) AS setCount FROM    theme t JOIN    sets s ON t.theme_id = s.theme_id GROUP BY    t.name ORDER BY    setCount DESC;";
						PreparedStatement statement = this.connection.prepareStatement(sql);
						statement.setInt(1,n);
						ResultSet resultSet = statement.executeQuery(); 

						if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\n" + //
							"The most popular themes by the number of sets of that theme:");

						while(resultSet.next()) {
								System.out.println("Theme Name: "+resultSet.getString("themeName") + " |  Number of Sets: " + resultSet.getString("setCount") );
						}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}


		//inspired <number> <part>
		// Part Relationship rel_types are: (P)rint, Pai(R), Su(B)-Part, (M)old, Pa(T)tern, (A)lternate
		//Top 10 sets that have a part inspired by part ? Road Sign Triangle [Plain]
		public void partInspiredBy(String part){
			try{
				if(part != null){
					String[] parts = part.split(",");
					part = part.substring(part.indexOf(",")+1).trim();
					String sql = "SELECT TOP (?)	sets.name AS setName, part.name as partName, COUNT(part_relationships.parent_part_num) AS partCount	"+
					"FROM	sets JOIN	inventory_sets ON sets.set_num = inventory_sets.set_num 	"+
					"JOIN inventory ON inventory_sets.inventory_id = inventory.inventory_id	"+
					"JOIN inventory_parts ON inventory.inventory_id = inventory_parts.inventory_id	"+
					"JOIN part ON inventory_parts.part_num = part.part_num	"+
					"JOIN	part_relationships ON part.part_num = part_relationships.parent_part_num	"+
					"WHERE	part.name LIKE ?		"+
					"GROUP BY	sets.name, part.name "+
					"ORDER BY	partCount DESC;";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setInt(1,Integer.parseInt(parts[0]));
					statement.setString(2,"%" +part+"%");
					ResultSet resultSet = statement.executeQuery(); 
					
					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}
					System.out.println("\n" + //
							"The top sets that have a part inspired by the parent part " + part + " :");

					while(resultSet.next()) {
							System.out.println("Set Name: "+resultSet.getString("setName") + " | Part Name: " + resultSet.getString("partName") + " | Number of Parts Inspired: " + resultSet.getString("partCount"));
					}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}


	

		//ctpieces <number> <color>
		//The number of sets that have a copper coloured piece and the most prevalent theme within those sets
		public void setsByPieceColorAndTheme(String color){
			try{
				if(color != null){
					String[] parts = color.split(",");
					color = color.substring(color.indexOf(",")+1).trim();
					String sql = "SELECT TOP (?) sets.name AS setName, COUNT(part.part_num) AS numColorParts,theme.name AS themeName " + //
						"FROM theme " + //
						"JOIN sets ON sets.theme_id = theme.theme_id " + //
						"JOIN inventory_sets ON sets.set_num = inventory_sets.set_num " + //
						"JOIN inventory ON inventory.inventory_id = inventory_sets.inventory_id " + //
						"JOIN inventory_parts ON inventory_parts.inventory_id = inventory.inventory_id " + //
						"JOIN part ON inventory_parts.part_num = part.part_num " + //
						"JOIN color ON color.color_id = inventory_parts.color_id " + //
						"WHERE color.name LIKE ? " + //
						"GROUP BY sets.name, theme.name " + //
						"ORDER BY numColorParts DESC;";
				PreparedStatement statement = this.connection.prepareStatement(sql);
				statement.setInt(1,Integer.parseInt(parts[0]));
				statement.setString(2,"%" +color+"%");
				ResultSet resultSet = statement.executeQuery(); 
				
				if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\n" + //
							"Sets with the most " + color + " colored parts and the theme the set has:");

				while(resultSet.next()) {

						System.out.println("Set Name: "+resultSet.getString("setName") + " | Theme: " + resultSet.getString("themeName") + " | Number of Parts that are " + color + ": " + resultSet.getString("numColorParts"));

				}
			}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}


		//excl <number> <theme> <mini> 
		//All star wars themed sets that don’t have a chewbacca minifig ordered by number of parts
		public void setsExcludingPieces(String theme){
			try{
				if (theme != null){
					String[] parts = theme.split(",");
					theme = parts[1]; 
					String mini = parts[2]; 

				String sql = "SELECT TOP (?) sets.name as setName, theme.name as theme, COUNT(part.part_num) AS numParts " + //
						"FROM theme " + //
						"JOIN sets ON sets.theme_id = theme.theme_id " + //
						"JOIN inventory_sets ON sets.set_num = inventory_sets.set_num " + //
						"JOIN inventory ON inventory.inventory_id = inventory_sets.inventory_id " + //
						"JOIN inventory_parts ON inventory_parts.inventory_id = inventory.inventory_id " + //
						"JOIN part ON inventory_parts.part_num = part.part_num " + //
						"JOIN color ON color.color_id = inventory_parts.color_id " + //
						"LEFT JOIN inventory_minifig ON inventory_minifig.inventory_id = inventory.inventory_id " + //
						"LEFT JOIN minifigs ON minifigs.fig_num = inventory_minifig.fig_num " + //
						"WHERE theme.name LIKE ? " + //
						"  AND (minifigs.name IS NULL OR minifigs.name not LIKE ?) " + //
						"GROUP BY sets.name, theme.name " + //
						"ORDER BY numParts DESC;";
				PreparedStatement statement = this.connection.prepareStatement(sql);
				statement.setInt(1,Integer.parseInt(parts[0])); 
				statement.setString(2,"%" +theme+"%" );
				statement.setString(3,"%" +mini+"%" );
				ResultSet resultSet = statement.executeQuery(); 
				
				if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

				System.out.println("\n"+theme+ " themed sets that don't have the mini figure " +mini+" ordered by number of parts:");

				while(resultSet.next()) {
						System.out.println("Set Name: "+resultSet.getString("setName") + " | Theme: " + resultSet.getString("theme") + " | Number of Parts: " + resultSet.getString("numParts"));
				}
			}
			
		}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}

		//mc <number> <color>
		//Open the image of the set with the most parts where at least a quarter of the parts are color
		public void mostRedPartsSet(String color){
			try{
				if (color != null){
					String[] parts = color.split(",");
					color = color.substring(color.indexOf(",")+1).trim();
				String sql = "SELECT TOP (?) sets.name AS setName, sets.img_url AS imageUrl " + //
						"FROM sets " + //
						"JOIN inventory_sets ON sets.set_num = inventory_sets.set_num " + //
						"JOIN inventory ON inventory.inventory_id = inventory_sets.inventory_id " + //
						"JOIN inventory_parts ON inventory_parts.inventory_id = inventory.inventory_id " + //
						"JOIN color ON color.color_id = inventory_parts.color_id " + //
						"WHERE color.name LIKE ? " + //
						"GROUP BY sets.name, sets.img_url " + //
						"HAVING COUNT(DISTINCT CASE WHEN color.name LIKE ? THEN inventory_parts.part_num END) >= 0.25 * COUNT(DISTINCT inventory_parts.part_num) " + //
						"ORDER BY COUNT(DISTINCT inventory_parts.part_num) DESC ;";
				PreparedStatement statement = this.connection.prepareStatement(sql);
				statement.setInt(1,Integer.parseInt(parts[0]));
				statement.setString(2,"%" +color+"%" );
				statement.setString(3,"%" +color+"%" );
				ResultSet resultSet = statement.executeQuery(); 
				
				if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\n" + //
							"The image url of the set with the most parts where at least a quarter of the parts are "+color+":");

				while(resultSet.next()) {
						System.out.println("Set Name: "+resultSet.getString("setName") + " | URL of Image of Set: " + resultSet.getString("imageUrl") );
				}
			}
			
		}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}

		//noset <number> 
		//All parts that are not included in a set.
		public void partsNoSet(String num){
			try{
				int n = Integer.parseInt(num); 
				String sql = "SELECT TOP (?) part.name as partName, part.part_material as Material, part_category.name as category " + //
						"FROM part " + //
						"JOin part_category on part.part_cat_id= part_category.category_id " + //
						"LEFT JOIN inventory_parts ON part.part_num = inventory_parts.part_num " + //
						"WHERE inventory_parts.part_num IS NULL;";
				PreparedStatement statement = this.connection.prepareStatement(sql);
				statement.setInt(1,n);
				ResultSet resultSet = statement.executeQuery(); 

				if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}
				
					System.out.println("\nParts that are not included in a set:");

				while(resultSet.next()) {
						System.out.println("Part Name: "+resultSet.getString("partName") + " | Material: " + resultSet.getString("Material") + " | Part Category: " + resultSet.getString("category"));
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}

		//sc <setname> 
		// All the parts in the set “Ice Cream Shop” with the number of parts that are of the included categories. 
		//works
		public void numPartsBySetByCategory(String set){
			try{
				if (set != null){	
					String sql = """
					SELECT part_category.name as categoryName, count(part.part_num) as numParts
					FROM sets
					INNER JOIN inventory ON sets.set_num=inventory.set_num
					INNER JOIN inventory_parts ON inventory.inventory_id=inventory_parts.inventory_id
					INNER JOIN part ON inventory_parts.part_num=part.part_num
					INNER JOIN part_category ON part.part_cat_id=part_category.category_id
					WHERE sets.name LIKE ?
					GROUP BY part_category.category_id, part_category.name
					""";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, "%" +set+"%" );
					ResultSet resultSet = statement.executeQuery(); 

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}
					System.out.println("\nAll the parts in the set " + set+ " and the number of parts in a part category:");
					while(resultSet.next()) {
							System.out.println("Part Category: "+resultSet.getString("categoryName") + " | Number of Parts: " + resultSet.getInt("numParts"));
					}
				}
			}catch (SQLException e){
					e.printStackTrace(System.out);
			}
		}

		//inv <number>
		//Top 10 set with the most inventories
		//works
		public void multiInv(String num){
			try{
				if (num != null) {
					int n = Integer.parseInt(num); 
					String sql = 
					"""
					SELECT TOP (?) sets.name as setName, COUNT(inventory_id) as numInv
					FROM inventory_sets
					INNER JOIN sets ON inventory_sets.set_num=sets.set_num
					GROUP BY sets.set_num, sets.name
					HAVING COUNT(inventory_id) > 1
					ORDER BY numInv DESC;
						""";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, n);
					ResultSet resultSet = statement.executeQuery();
					//int i=0;
					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\nTop sets with the most inventories:");

					while (resultSet.next()) {
						System.out.println("Set Name: "+resultSet.getString("setName")+" | Number of Inventories: "+resultSet.getInt("numInv"));
						//i++;
					}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}

		//year <year> <number pieces> 
		// Set names of sets released in 1993 with less than 100 pieces.
		public void setsByYearMinPieces(String year) {
			try {
				if (year != null) {
					String[] parts; 
					parts = year.split(",");
					String sql = "SELECT name, num_parts FROM sets WHERE sets.year = ? AND sets.num_parts < ? GROUP BY name, num_parts";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setString(1, parts[0]);
					statement.setString(2, parts[1]); 
					ResultSet resultSet = statement.executeQuery();

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}
					System.out.println("\nSets that were created in " + parts[0]+ " with less than "+ parts[1] + " pieces:");

					while (resultSet.next()) {
						System.out.println("Set Name: "+resultSet.getString("name") + " | Number of Parts: " + resultSet.getString("num_parts"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}


		//cc  <number> <category> 
		// The part names of elements in the category “Tools” 
		public void partsByCategory(String cat){
			try{
				if (cat != null){
					String[] parts; 
					parts = cat.split(",");
					String sql = """
						SELECT TOP (?) part.name  as partName FROM part
						INNER JOIN element ON part.part_num=element.part_num
						INNER JOIN color ON element.color_id=color.color_id
						INNER JOIN part_category ON part.part_cat_id=part_category.category_id
						WHERE part_category.name LIKE ?
						""";
				PreparedStatement statement = this.connection.prepareStatement(sql);
				statement.setInt(1, Integer.parseInt(parts[0]));
				statement.setString(2, "%" + parts[1] + "%");
		 
				ResultSet resultSet = statement.executeQuery(); 

				if(resultSet == null){
						System.out.println("The part names of in the category " + cat +":");
						return; 
					}

					System.out.println("\nParts in the category " + cat+ ":");


				while(resultSet.next()) {
						System.out.println("Part Name: "+resultSet.getString("partName"));
				}
				}
				

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}


		//at <number> 
		//The themes that have the greatest average in pieces across all sets
		public void avgPiecesTheme(String num){
			try{
				if (num != null){
						String[] parts; 
						parts = num.split(",");
					String sql = """

							SELECT TOP (?) theme.name AS ThemeName, ROUND(AVG(num_parts), 2) AS AvgPieces
							FROM sets
							JOIN theme ON sets.theme_id = theme.theme_id
						
							GROUP BY theme.theme_id, theme.name
							ORDER BY AvgPieces DESC;""";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setInt(1,Integer.parseInt(parts[0]) );

					ResultSet resultSet = statement.executeQuery(); 

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\nThe themes that have the greatest average in pieces across all sets:");


					while(resultSet.next()) {
						System.out.println("Theme: "+resultSet.getString("themeName") + " | Average Number of Pieces: " + resultSet.getString("AvgPieces"));
					}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}

	//setwithout <number> <part> 
		//Sets without x part

		public void setWithout(String part){
			try{
				if (part != null){
						String[] parts; 
						parts = part.split(",");
						part = part.substring(part.indexOf(",")+1).trim();
					String sql = """
							SELECT TOP (?) sets.set_num, sets.name as setName
							FROM sets
							LEFT JOIN inventory_sets ON sets.set_num = inventory_sets.set_num
							LEFT JOIN inventory_parts ON inventory_sets.inventory_id = inventory_parts.inventory_id
							LEFT JOIN part ON part.part_num= inventory_parts.part_num AND part.name LIKE ?
							WHERE inventory_parts.part_num IS NULL;""";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setInt(1, Integer.parseInt(parts[0]));
					statement.setString(2, "%" +part+"%" );
					ResultSet resultSet = statement.executeQuery(); 

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}
					System.out.println("\nSets without the part " + part+ ":");

					while(resultSet.next()) {
							System.out.println("Set Name: "+resultSet.getString("setName"));
					}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}


		//sm 
		//Sets with parts of all the same material

		public void sameMaterials(){
			try{
				// if (mat != null){
						// String[] parts; 
						// parts = mini.split("\\s+");
					String sql = """
						SELECT 
							sets.name AS SetName, part.part_material as Material
						FROM sets
						JOIN
							inventory_sets ON sets.set_num = inventory_sets.set_num
						JOIN
							inventory ON inventory_sets.inventory_id = inventory.inventory_id
						JOIN
							inventory_parts ON inventory.inventory_id = inventory_parts.inventory_id
						JOIN
							part ON inventory_parts.part_num = part.part_num
						GROUP BY
							sets.name, part.part_material
						HAVING
							COUNT(DISTINCT part.part_material) = 1;
							""";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					// statement.setString(1, mat);
					ResultSet resultSet = statement.executeQuery(); 

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\nSets with parts of all the same material:");
					while(resultSet.next()) {
							System.out.println("Set Name: "+resultSet.getString("SetName") + " | Material: " + resultSet.getString("Material") );
					}
				// }

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}


		//wm <number> <material> 
		//Sets without parts of a certain material

		public void withoutMaterial(String material){
			try{
				if (material != null){
					String[] parts; 
					parts = material.split(",");
					material = material.substring(material.indexOf(",")+1).trim();
					String sql = """
							SELECT TOP (?)
								sets.name AS SetName, sets.set_num as setNum
							FROM
								sets
							JOIN
								inventory_sets ON sets.set_num = inventory_sets.set_num
							JOIN
								inventory ON inventory_sets.inventory_id = inventory.inventory_id
							JOIN
								inventory_parts ON inventory.inventory_id = inventory_parts.inventory_id
							JOIN
								part ON inventory_parts.part_num = part.part_num
							WHERE
								sets.set_num NOT IN (
									SELECT
										sets.set_num
									FROM
										sets
									JOIN
										inventory_sets ON sets.set_num = inventory_sets.set_num
									JOIN
										inventory ON inventory_sets.inventory_id = inventory.inventory_id
									JOIN
										inventory_parts ON inventory.inventory_id = inventory_parts.inventory_id
									JOIN
										part ON inventory_parts.part_num = part.part_num
									WHERE
										part.part_material LIKE ?
								);
							""";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setInt(1, Integer.parseInt(parts[0]));
					statement.setString(2, "%" +material+"%" );
					ResultSet resultSet = statement.executeQuery(); 

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\nSets without parts of the material " + material+":");

					while(resultSet.next()) {
							System.out.println("Set Name: "+resultSet.getString("SetName")+" | Set Number: "+resultSet.getString("setNum"));
					}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}

		//numColors <set name> 
		//Number of colours in a set

		public void numColors(String set){
			try{
				if (set != null){
						// String[] parts; 
						// parts = mini.split("\\s+");
					String sql = 
							"""
							SELECT sets.set_num as setNum, sets.name as setName, COUNT(DISTINCT inventory_parts.color_id) as numColors
							FROM sets
							JOIN inventory ON sets.set_num = inventory.set_num
							JOIN inventory_parts ON inventory.inventory_id = inventory_parts.inventory_id
							WHERE sets.name LIKE ?
							GROUP BY sets.set_num, sets.name
							ORDER BY numColors DESC;
							""";

					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setString(1,"%"+set+"%");
						ResultSet resultSet = statement.executeQuery(); 
					
					if(resultSet == null){
					System.out.println("There are no results for this query.");
					return; 
					}


					System.out.println("\nThe number of colors of parts in the set "+set+ ":");


					while(resultSet.next()) {
							System.out.println("Set Number: "+resultSet.getString("setNum") + " | Set Name: " + resultSet.getString("setName") + " | Number of Colors: " + resultSet.getString("numColors"));
					}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}
		
		//partsYear <year>
		//Average numParts in sets created in <year>
		public void numPartsPerYear(String year){
			try {
				if (year != null) {
					String sql = 
							"""
							SELECT year, AVG(num_parts) as avParts
							FROM sets
							WHERE year=?
							GROUP BY year;
							""";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setString(1, year);
					ResultSet resultSet = statement.executeQuery();

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\nThe average number of parts in sets created in "+year+":");

					while (resultSet.next()) {
						System.out.println("Average number of Parts: "+resultSet.getInt("avParts"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		//mini <number> <name>
		//Set names for all the sets including the mini figure “Yoda, White Robe, Lime Head”
		public void setWithMini(String mini){
			try{
				if (mini != null){
					String[] parts;
					parts = mini.split(",");
					String sql = """
							SELECT TOP (?) sets.name as setName  FROM minifigs
							INNER JOIN inventory_minifig ON minifigs.fig_num=inventory_minifig.fig_num
							INNER JOIN inventory ON inventory_minifig.inventory_id=inventory.inventory_id
							INNER JOIN sets ON inventory.set_num=sets.set_num
							WHERE minifigs.name LIKE ?;
							""";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					statement.setInt(1, Integer.parseInt(parts[0]));
					statement.setString(2,"%" + parts[1]+"%" );
					ResultSet resultSet = statement.executeQuery(); 

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\nSets including the mini figure "+ mini + ":");

					while(resultSet.next()) {
							System.out.println("Set Name: "+resultSet.getString("setName"));
					}
				}

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}


		//mostColors
		//Set with the most variety in colours

		public void mostColors(){
			try{
				// if (set != null){
						// String[] parts; 
						// parts = mini.split("\\s+");
					String sql = """
							SELECT TOP 1
								sets.set_num AS SetNumber,
								sets.name AS SetName,
								COUNT(DISTINCT inventory_parts.color_id) AS VarietyInColors
							FROM
								sets
							JOIN
								inventory ON sets.set_num = inventory.set_num
							JOIN
								inventory_parts ON inventory.inventory_id = inventory_parts.inventory_id

							GROUP BY
								sets.set_num, sets.name
							ORDER BY
								VarietyInColors DESC;
							""";
					PreparedStatement statement = this.connection.prepareStatement(sql);
					// statement.setString(1, set);
					ResultSet resultSet = statement.executeQuery(); 

					if(resultSet == null){
						System.out.println("There are no results for this query.");
						return; 
					}

					System.out.println("\nSets with the most variety in colors:");

					while(resultSet.next()) {
							System.out.println("Set Name: "+resultSet.getString("SetName") + " | Number of Colors: " + resultSet.getString("VarietyInColors"));
					}
				// }

			}catch (SQLException e){
				e.printStackTrace(System.out);
			}
		}
		

		//add all the data to the database by reading the sql files
		public void populateDatabase(){
			dropTables();
			System.out.println("Loading database...");
			addTable("color.sql",263);
			addTable("theme.sql",468);
			addTable("part_category.sql",66);
			addTable("part.sql",52642);
			addTable("sets.sql",21886);
			addTable("inventory.sql",37272);
			addTable("minifigs.sql",13765);
			addTable("inventory_minifig.sql",20859);
			addTable("inventory_sets.sql",4358);
			addTable("part_relationships.sql",29998);
			addTable("element.sql",84140);
			addTable("inventory_parts.sql",249991);
			addTable("inventory_parts2.sql",249999);
			addTable("inventory_parts3.sql",250000);
			addTable("inventory_parts4.sql",250000);
			addTable("inventory_parts5.sql",181075);
		}

		private void addTable(String fileName, int numRows){
			System.out.println(fileName);
			String[] tableA = fileName.split("\\.");
			System.out.println(tableA[0]);

			System.out.println("Loading database...");
			
			try(Scanner scanner = new Scanner(new File(fileName))){
				String createTable=null;
				int insertCounter=0;
				String insertString="";
				int i=0;
				while(scanner.hasNextLine()){
					System.out.print(i+"/"+numRows+"\r");
					String line = scanner.nextLine().trim();
					String[] lineSplit = line.split(" ");

					if(lineSplit[0].equals("INSERT")){
						if(insertCounter==1000){
							try{
								PreparedStatement statement = connection.prepareStatement(insertString);
								statement.executeUpdate();
							} catch(SQLException e){
								// e.printStackTrace(System.out);
								System.out.println("A record couldn’t be added to the database because it was missing information."); 
							}
							insertString="";
							insertCounter=0;
						}else{
							insertString+=line+"\n";
							insertCounter++;
						}
					}else if(createTable==null && lineSplit[0].equals("CREATE")){
						createTable=line;
					}else if(createTable!=null && (line.charAt(line.length()-1)==';')){
						createTable+=line;
						try{
							PreparedStatement statement = connection.prepareStatement(createTable);
							statement.executeUpdate();
						} catch(SQLException e){
							// e.printStackTrace(System.out);
							System.out.println("A record couldn’t be added to the database because it was missing information."); 
						}
						createTable=null;
					}else if(createTable!=null && line.length()>0){
						createTable+=line;
					}
					i++;
				}
				if(insertCounter>0){
					try{
						PreparedStatement statement = connection.prepareStatement(insertString);
						statement.executeUpdate();
					} catch(SQLException e){
						// e.printStackTrace(System.out);
						System.out.println("A record couldn’t be added to the database because it was missing information."); 

					}
				}
			}catch (FileNotFoundException e) {
				System.out.println("Missing file");
			}
		}
		public void dropTables(){
			dropTable("inventory_parts");
			dropTable("inventory_sets");
			dropTable("element");
			dropTable("part_relationships");
			dropTable("inventory_minifig");
			dropTable("minifigs");
			dropTable("inventory");
			dropTable("sets");
			dropTable("part");
			dropTable("part_category");
			dropTable("theme");
			dropTable("color");
		}
		public void dropTable(String table){
			try{
				PreparedStatement tableStatement = connection.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_type = 'BASE TABLE'");
					ResultSet resultSet = tableStatement.executeQuery();
					while (resultSet.next()) {
						String tableName = resultSet.getString("table_name");
						if(tableName.equals(table)){
							try{
								System.out.println("Dropping table "+table);
								PreparedStatement dropStatement = connection.prepareStatement("drop table "+table);
								dropStatement.executeUpdate();
							}catch(SQLException e){
							// System.out.println(e);
							System.out.println("A table could not be dropped."); 
							}
						}
					}
			}catch(SQLException e){
				System.out.println("Unable to drop table "+table);
			}
		}

}