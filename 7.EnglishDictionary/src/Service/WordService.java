package Service;

import Entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class WordService implements IWordService{

    Map<Word, String> wordMap ;
    Map<Word, String> exampleMap;

    public WordService() {
        this.wordMap = new TreeMap<Word, String>();
        this.exampleMap = new ConcurrentHashMap<Word, String>();
        initializeData();
    }

    @Override
    public String getWordTranslation(String word) {
        return wordMap.get(new Word(word));
    }

    @Override
    public void addWord(String word, String translation ,String example) {
        wordMap.put(new Word(word), translation);
        exampleMap.put(new Word(word), example);
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
            System.out.println(entry.getKey() + ": " + entry.getValue() + " | Example: " + exampleMap.get(entry.getKey()));
        }
    }

    @Override
    public List<String> getAllWords() {
        List<String> words = new ArrayList<>();
        for (Word w : wordMap.keySet()) {
            words.add(w.word());
        }
        return words;
    }

    @Override
    public void initializeData() {
        wordMap.put(new Word("apple" ), "苹果");
        wordMap.put(new Word("banana"), "香蕉");
        wordMap.put(new Word("orange"), "橙子");
        exampleMap.put(new Word("apple"), "I like to eat an apple every day.");
        exampleMap.put(new Word("banana"), "Bananas are high in potassium.");
        exampleMap.put(new Word("orange"), "She drank a glass of fresh orange juice.");
    }
}
