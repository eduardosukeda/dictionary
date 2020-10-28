package br.com.dictionary.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Arrays;

public class ReadTextService {

    private String[] text = new String[1000];

    public ReadTextService(String path) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("resources/" + path + ".txt"), "UTF-8"));

        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] lineArray = line.split(" ");
            for (int x = 0; x < lineArray.length; x++) {
                if (lineArray[x].toLowerCase().equals(".")) {
                    break;
                }
                text[i] = lineArray[x].toLowerCase();
                i++;
            }
        }
        br.close();
    }

    public String[] getTextRepeatedWords(String[] text) {
        String[] uniqueWords = new String[text.length];
        int qtd = 0;
        for (int i = 0; i < text.length; i++) {
            boolean exist = false;
            for (int j = 0; j < qtd; j++) {
                if (uniqueWords[j].compareTo(text[i]) == 0) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                uniqueWords[qtd++] = text[i];
            }
        }

        uniqueWords = Arrays.copyOf(uniqueWords, qtd);

        return uniqueWords;
    }

    public String[] getTextSort() {
        String[] text = new String[getTextLength(this.text)];
        Arrays.sort(this.text, 0, getTextLength(this.text), Collator.getInstance());
        for (int i = 0; i < getTextLength(this.text); i++) {
            text[i] = this.text[i];
        }
        return text;
    }

    public int getTextLength(String[] text) {
        int counter = 0;
        for (int i = 0; i < text.length; i++)
            if (text[i] != null) {
                counter++;
            } else {
                break;
            }
        return counter;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }
}