import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	static String readInput() {
		String textFile = null;
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			textFile = reader.readLine();
		} catch (Exception e) {
		}
		return textFile;
	}

	static void writeInput(String inputText, String formatDate) {
		try {
			BufferedWriter reader = new BufferedWriter(
					new FileWriter("students.txt", true));

			reader.write(", " + inputText + "\nList last updated on " + formatDate);
			reader.close();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		Constants constant = new Constants();

		// Check arguments

		if (!args[0].equals("a") && !args[0].equals("r") && !args[0].contains("+") && !args[0].contains("?")
				&& !args[0].contains("c")) {
			System.exit(0);
		}

		if (args[0].equals("a")) {
			System.out.println(constant.loading);

			String students[] = readInput().split(",");
			for (String student : students) {
				System.out.println(student);
			}

			System.out.println(constant.loaded);
		} else if (args[0].equals("r")) {
			System.out.println(constant.loading);

			String students[] = readInput().split(",");

			int randNum = new Random().nextInt(students.length);
			System.out.println(students[randNum]);

			System.out.println(constant.loaded);
		} else if (args[0].contains("+")) {
			System.out.println(constant.loading);

			String inputText = args[0].substring(1);

			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
			String formatDate = dateFormat.format(new Date());
			writeInput(inputText, formatDate);

			System.out.println(constant.loaded);
		} else if (args[0].contains("?")) {
			System.out.println(constant.loading);

			String students[] = readInput().split(",");
			String searchText = args[0].substring(1);
			for (int idx = 0; idx < students.length; idx++) {
				if (students[idx].trim().equals(searchText)) {
					System.out.println("We found it!");
					break;
				}
			}

			System.out.println(constant.loaded);
		} else if (args[0].contains("c")) {
			System.out.println(constant.loading);
			String students[] = readInput().split(",");
			System.out.println(students.length + " word(s) found ");

			System.out.println(constant.loaded);
		}
	}
}