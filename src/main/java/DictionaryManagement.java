import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class DictionaryManagement {
    Dictionary dict = new Dictionary();
    private static final String fileName = "dictionaries.txt";

    public static String getFileName() {
        return fileName;
    }

    public void insertFromCommandline() {
        System.out.println("Insert: ");
        Scanner sc = new Scanner(System.in);
        Word w = new Word();
        w.setWord_target(sc.nextLine());
        w.setWord_explain(sc.nextLine());
        dict.setList(w);
    }

    public void insertFromFile() {
        File info = new File(fileName);
        try {
            if (info.createNewFile()) {
                System.out.println("File created: " + info.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred when create file");
            e.printStackTrace();
        }

        try {
            Scanner myReader = new Scanner(info);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split("- ");
                System.out.println(data[0]);
                dict.setList(new Word(data[0], data[1]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when trying to reading file");
            e.printStackTrace();
        }

    }

    public void dictionaryExportToFile() {
        File info = new File(fileName);
        try {
            if (info.createNewFile()) {
                System.out.println("File created: " + info.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred when create file");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for (int i = 0; i < dict.getList().size(); i++) {
                myWriter.write(dict.getList().get(i).getWord_target() + "- " + dict.getList().get(i).getWord_explain() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully saved dictionary to file!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void suggestSearch(String s) {
        return;

    }

    public int BinarySearch(String wordF) {
        int lo = 0;
        int hi = dict.getList().size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compareI = dict.getList().get(mid).getWord_target().compareTo(wordF);
            if (compareI > 0) hi = mid - 1;
            else if (compareI < 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public String dictionaryLookup(String s) {
//        for(int i = 0; i < dict.num_element; i++){
//            Word w = new Word();
//            w = dict.getList().get(i);
//            if(w.getWord_target().equals(s)){
//                return w.getWord_explain();
//            }
//        }
        int rs = BinarySearch(s);
        if (rs != -1) {
            return dict.getList().get(rs).getWord_explain();
        }
        return "Not find";
    }

    public void editWord(String s) {
        Scanner sc = new Scanner(System.in);

//        System.out.println("You want to edit: ");
//        System.out.println("1. Word Target");
//        System.out.println("2. Word Explain");
//        int choice = sc.nextInt();
//            System.out.println("What word you want to edit its explain?");
//            s = sc.next();
        int rs = BinarySearch(s);
        if (rs != -1) {
            dict.getList().get(rs).setWord_explain(sc.next());
        } else {
            System.out.println("Cant find word that you want to edit?");
        }
//        }else if(choice == 2){
//            String s;
//            System.out.println("What word you want to edit its target?");
//            s = sc.next();
//            int rs = BinarySearch(s);
//            if(rs != -1){
//                dict.getList().get(rs).setWord_target(sc.next());
//            }else{
//                System.out.println("Cant find word that you want to edit?");
//            }
//        }
    }

    public void removeWord(String s) {
        int rs = BinarySearch(s);
        if (rs != -1) {
            dict.getList().remove(rs);
            System.out.println("Removed!");
        } else {
            System.out.println("Word not exist");
        }
    }

}