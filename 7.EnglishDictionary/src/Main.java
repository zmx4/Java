import Service.IWordService;
import Service.WordService;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public  static void main(String[] args) {
        IWordService wordService = new WordService();

        // 列出所有单词
        wordService.listAllWords();

        wordService.addWord("grape", "葡萄");
        System.out.println("\n添加单词 grape 后：");
        wordService.listAllWords();

        wordService.updateWordTranslation("banana", "香蕉（更新后）");
        System.out.println("\n更新单词 banana 的翻译后：");
        wordService.listAllWords();

        wordService.deleteWord("orange");
        System.out.println("\n删除单词 orange 后：");
        wordService.listAllWords();
    }


}