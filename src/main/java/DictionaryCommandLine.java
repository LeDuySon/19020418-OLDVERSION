import java.util.Scanner;
//import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import utils.*;

public class DictionaryCommandLine extends Utils{
    DictionaryManagement manage = new DictionaryManagement();
    DictionaryCommandline cmd = new DictionaryCommandline();

    public void dictionaryBasic() {
        manage.insertFromCommandline();
//        manage.insertFromFile();
        cmd.showAllWords(manage.dict);
    }

    public void show(){
        cmd.showAllWords(manage.dict);
    }

    public void dictionaryAdvanced(String s) {
        String rs;
        manage.insertFromFile();
        cmd.showAllWords(manage.dict);
        rs = manage.dictionaryLookup(s);
        if (rs.equals("Not find")) {
            System.out.println("Do you want to add new word that you cant search?");
            dictionaryBasic();
        } else {
            System.out.println(rs);
        }

    }

    public void dictionarySearcher(String s){
        List <Pairs<String, Integer>> score = new ArrayList<Pairs<String, Integer>>();
        for (int i = 0; i < manage.dict.getList().size(); i++){
            Pairs<String, Integer> p = new Pairs<String, Integer>();
            String s1 = manage.dict.getList().get(i).getWord_target();
            int rs = calculate(s1, s);
            int lg = LongestCommonSubString(s1, s);
            int mergeRs = (2*lg + rs)/3;
            p.setFirst(s1);
            p.setSecond(mergeRs);
            score.add(p);
        }
        Collections.sort(score, (a, b) -> Integer.compare(a.getSecond(), b.getSecond()));
        for(int i = 0; i < 3 ; i++){
            System.out.println(score.get(i).getFirst());
        }
    }

    public void callEdit(String s) {
        manage.editWord(s);
    }

    public void callRemove(String s){
        manage.removeWord(s);
    }

    public void saveDict(){
        manage.dictionaryExportToFile();
    }

    public static void main(String[] args) {
        DictionaryCommandLine get_cmd = new DictionaryCommandLine();
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            choice = sc.nextInt();
            if (choice == 1) {
                get_cmd.dictionaryBasic();
            } else if (choice == 2) {
                System.out.println("Which word you want to translate: ");
                get_cmd.dictionaryAdvanced(sc.next());
            } else if (choice == 3) {
                String s = sc.next();
                get_cmd.callEdit(s);
                get_cmd.show();
            } else if(choice == 4){
                String s = sc.next();
                get_cmd.callRemove(s);
                get_cmd.show();
            }else if(choice == 5){
                System.out.println("Search: ");
                get_cmd.dictionarySearcher(sc.next());
            }else if(choice == 6){
                get_cmd.saveDict();
            } else{
                break;
            }
        }

    }
}