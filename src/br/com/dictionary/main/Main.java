package br.com.dictionary.main;

import br.com.dictionary.service.ReadTextService;

public class Main {
    public static void main(String[] args) {

        try {
            ReadTextService textService = new ReadTextService("text");
            String[] uniqueWords = textService.getTextRepeatedWords(textService.getTextSort());

            for (int i = 0; i < uniqueWords.length; i++) {
                System.out.println(uniqueWords[i]);
                if (i == uniqueWords.length - 1) {
                    int totalWords = uniqueWords.length;
                    System.out.println("total de palavras diferentes no dicionario = " + totalWords);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
