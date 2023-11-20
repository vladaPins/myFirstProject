package edu.homelab.task3.generators.text;

public interface TextGenerator {
  String generateText(int size, String[] words, int probability);
}
