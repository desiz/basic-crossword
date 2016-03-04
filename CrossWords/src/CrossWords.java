import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import model.CrossWord;
import model.LineWord;
import model.Word;


public class CrossWords {
	private static List<Word> vocabulary;

	public static void main(String[] args) {
		vocabulary = loadFile("/Users/beast/Desktop/Cross Words/CrossWords/words.txt");
		clearVocabulary();
		CrossWord newCrossWord = createCrossWord("зар");
		newCrossWord.draw();

		clearVocabulary();
		CrossWord newCrossWord2 = createCrossWord(" зар");
		newCrossWord2.draw();

	}
	
	private static void clearVocabulary(){
		// Clear "used" flag.
		for (Iterator<Word> iterator = vocabulary.iterator(); iterator.hasNext();) {
			Word word = (Word) iterator.next();
			word.setUsed(false);
		}
		// Shuffle a collection
		Collections.shuffle(vocabulary);
	}
	
	private static CrossWord createCrossWord(String rootWord){
		CrossWord result = new CrossWord(rootWord);
		for (int i = 0; i < rootWord.length(); i++) {
			char currentChar = rootWord.charAt(i);
			LineWord currentLineWord = null;
			for (Iterator<Word> iterator = vocabulary.iterator(); iterator.hasNext();) {
				Word currentWord = (Word) iterator.next();
				if (!currentWord.getWord().equals(rootWord)) {
					if (!currentWord.isUsed()) {
						if (currentWord.hasLetter(currentChar)) {
							currentWord.setUsed(true);
							int position = currentWord.getPositionOf(currentChar);
							currentLineWord = new LineWord(currentWord, position);
							break;
						}
					}
				}
			}
			if (currentLineWord != null) {
				result.getWords().add(currentLineWord);
			}else{
				System.out.println("Няма дума с буква '" + currentChar + "' в речника.");
				break;
			}
		}
		return result;
	}
	
	private static List<Word> loadFile(String fileName) {
		List<Word> result = new ArrayList<Word>();
		File file = new File (fileName);
		if (file.exists()){
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				while (line != null){
					if (line.indexOf('-') > 0) {
						String word = line.substring(0, line.indexOf('-')-1);
						String definition = line.substring(line.indexOf('-')+2);
						Word currentWord = new Word(word, definition);
						result.add(currentWord);
					}
					line = reader.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(reader != null){
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}else{
			System.out.println("Няма такъв файл:" + fileName);
		}
		return result;
	}

}
