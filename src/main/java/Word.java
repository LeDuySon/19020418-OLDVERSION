public class Word {
    private String word_target;
    private String word_explain;

    public Word(){
    }

    public Word(String target, String explain) {
        this.word_target = target;
        this.word_explain = explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String s) {
        this.word_target = s;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

}