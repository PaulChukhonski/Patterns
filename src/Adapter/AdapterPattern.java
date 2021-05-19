package Adapter;

import java.util.*;

public class AdapterPattern {
    static class SystemClass {
        String text;

        public SystemClass(String text) { this.text = text.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", ""); }

        public String getProcessedText(TextProcessor processor) {
            return processor.processText(text);
        }
    }

    interface TextProcessor {
        String processText(String text);
    }

    static class WordCounter {
        int countWords(String text) {
            return text.split(" ").length;
        }

        int getCount(String text, String word) {
            return getAllWords(text).get(word);
        }

        HashMap<String, Integer> getAllWords(String text) {
            String[] words = text.split(" ");
            HashMap<String, Integer> wordsCount = new HashMap<>();
            for (String word: words) {
                if (!wordsCount.containsKey(word)) {
                    wordsCount.put(word, 0);
                }

                wordsCount.put(word, wordsCount.get(word) + 1);
            }

            return wordsCount;
        }
    }

    static class WordCounterAdapter implements TextProcessor {
        private WordCounter wordCounter;

        public WordCounterAdapter(WordCounter wordCounter) {
            this.wordCounter = wordCounter;
        }

        @Override
        public String processText(String text) {
            HashMap<String, Integer> wordsCount = wordCounter.getAllWords(text);

            HashMap<String, Integer> result = new LinkedHashMap<>();
            wordsCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(e -> result.put(e.getKey(), e.getValue()));

            StringBuilder sb = new StringBuilder();

            for(String word: result.keySet()) {
                sb.append(word).append(" ");
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String str = "3gionbb3ovn hello world 2jgijg hello jg23v32 hello i2fjg hello world";

        SystemClass system = new SystemClass(str);
        WordCounter wordCounter = new WordCounter();
        TextProcessor processor = new WordCounterAdapter(wordCounter);
        String processedStr = system.getProcessedText(processor);

        System.out.println(processedStr);
    }
}
