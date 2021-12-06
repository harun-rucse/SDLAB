import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments

		if (!args[0].equals("a") && !args[0].equals("r") && !args[0].contains("+") && !args[0].contains("?")
				&& !args[0].contains("c")) {
			System.exit(0);
		}

		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String textFile = reader.readLine();
				String students[] = textFile.split(",");
				for (String student : students) {
					System.out.println(student);
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String textFile = reader.readLine();
				String students[] = textFile.split(",");
				Random x = new Random();
				int y = x.nextInt(students.length);
				System.out.println(students[y]);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter writeFile = new BufferedWriter(
						new FileWriter("students.txt", true));
				String inputText = args[0].substring(1);
				Date date = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String formatDate = dateFormat.format(date);
				writeFile.write(", " + inputText + "\nList last updated on " + formatDate);
				writeFile.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String textFile = reader.readLine();
				String students[] = textFile.split(",");
				boolean done = false;
				String searchText = args[0].substring(1);
				for (int idx = 0; idx < students.length && !done; idx++) {
					if (students[idx].trim().equals(searchText)) {
						System.out.println("We found it!");
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String textFile = reader.readLine();
				char students[] = textFile.toCharArray();
				int count = 1;
				for (char singleChar : students) {
					if (singleChar == ' ') {
						count++;
					}
				}
				System.out.println(count + " word(s) found ");
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
	}
}