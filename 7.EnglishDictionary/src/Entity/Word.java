package Entity;

public record Word(String word) implements Comparable<Word> {

    @Override
    public String toString() {
        return word;
    }

    @Override
    public int compareTo(Word other) {
        // 比较单词的字母顺序
        return this.word.compareTo(other.word);
    }
}
