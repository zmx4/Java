package Service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordGame implements IWordGame {
    private final IWordService wordService;
    private final Scanner scanner;

    public WordGame(IWordService wordService) {
        this.wordService = wordService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        List<String> allWords = wordService.getAllWords();
        System.out.print("请输入要测验的单词数量: ");
        int count = 0;
        String input = scanner.nextLine();
        count = Integer.parseInt(input);

        if (count <= 0) {
            System.out.println("数量必须大于0。");
            return;
        }

        // 随机打乱
        Collections.shuffle(allWords);
        List<String> quizWords = allWords.subList(0, count);
        int correctCount = 0;
        System.out.println("开始测验！共 " + count + " 个单词。");
        for (String word : quizWords) {
            String correctAnswer = wordService.getWordTranslation(word);
            System.out.println("单词: " + word);
            System.out.print("请输入中文含义: ");
            String userAnswer = scanner.nextLine().trim();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("回答正确！");
                correctCount++;
            } else {
                System.out.println("回答错误。正确答案是: " + correctAnswer);
            }
            System.out.println("--------------------");
        }
        double accuracy = (double) correctCount / count * 100;
        System.out.printf("测验结束！你的正确率是: %.2f%%\n", accuracy);
        System.out.println("答对: " + correctCount + ", 答错: " + (count - correctCount));
    }
}
