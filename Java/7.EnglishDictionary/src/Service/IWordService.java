package Service;

public interface IWordService {
    // 根据单词获取翻译
    public String getWordTranslation(String word);

    // 添加新单词及其翻译
    public void addWord(String word, String translation ,String example);

    // 删除单词
    public void deleteWord(String word);

    // 更新单词的翻译
    public void updateWordTranslation(String word, String newTranslation);

    // 列出所有单词及其翻译
    public void listAllWords();

    // 获取所有单词列表
    public java.util.List<String> getAllWords();

    // 初始化数据
    public void initializeData();
}
