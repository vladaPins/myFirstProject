package edu.homelab.task3.generators.files;

public interface FilesGenerator {
  void getFiles(String path, int n, int size, String[] words, int probability);
}
