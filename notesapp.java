import java.io.*;
import java.util.Scanner;

public class NotesApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }

    // ✏️ Write notes to file
    public static void addNote(Scanner sc) {
        try {
            FileWriter fw = new FileWriter("notes.txt", true); // append mode
            System.out.print("Enter your note: ");
            String note = sc.nextLine();

            fw.write(note + "\n");
            fw.close();

            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // 📖 Read notes from file
    public static void viewNotes() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
            String line;

            System.out.println("\n--- Your Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No notes found or error reading file.");
        }
    }
}