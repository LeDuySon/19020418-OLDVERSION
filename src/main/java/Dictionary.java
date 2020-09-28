import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<Word> list = new ArrayList<Word>();

    Dictionary(){

    }

    public void setList(Word w) {
        this.list.add(w);
    }

    public List<Word> getList() {
        return list;
    }
}