package Service;

import Entity.Word;

import java.util.Map;
import java.util.TreeMap;

public class WordService implements IWordService{

    Map<Word, String> wordMap ;

    public WordService() {
        this.wordMap = new TreeMap<Word, String>();
        initializeData();
    }

    @Override
    public String getWordTranslation(String word) {
        return wordMap.get(new Word(word));
    }

    @Override
    public void addWord(String word, String translation) {
        wordMap.put(new Word(word), translation);
    }

    @Override
    public void deleteWord(String word) {
        wordMap.remove(new Word(word));
    }

    @Override
    public void updateWordTranslation(String word, String newTranslation) {
        deleteWord(word);
        wordMap.put(new Word(word), newTranslation);
    }

    @Override
    public void listAllWords() {
        for(Map.Entry<Word, String> entry : wordMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public void initializeData() {
        wordMap.put(new Word("apple" ), "苹果");
        wordMap.put(new Word("banana"), "香蕉");
        wordMap.put(new Word("orange"), "橙子");
    }
}
