public class DictionaryCommandline{
    public void showAllWords(Dictionary dict){
        System.out.println("No\t| English\t\t\t| Vietnamese");
        for(int i = 0; i < dict.getList().size(); i++){
            System.out.print((i+1) + "\t| " + dict.getList().get(i).getWord_target());
            for(int j = 0; j < 30-dict.getList().get(i).getWord_target().length(); j++){
                System.out.print(" ");
            }
            System.out.println("| "+dict.getList().get(i).getWord_explain());
        }

    }
}