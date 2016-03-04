package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrossWord {
	private String root;
	private List<LineWord> words;
	public CrossWord(String root) {
		super();
		this.root = root;
		words = new ArrayList<LineWord>();
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public List<LineWord> getWords() {
		return words;
	}
	@Override
	public String toString() {
		return "CrossWord [root=" + root + ", words=" + words + "]";
	}
	
	public void draw(){
		int maxPosition = 0;
		for (Iterator<LineWord> iterator = words.iterator(); iterator.hasNext();) {
			LineWord currentLineWord = (LineWord) iterator.next();
			if (currentLineWord.getPosition() > maxPosition) {
				maxPosition = currentLineWord.getPosition();
			}
		}
		
		for (Iterator<LineWord> iterator = words.iterator(); iterator.hasNext();) {
			LineWord currentLineWord = (LineWord) iterator.next();
			currentLineWord.draw(maxPosition - currentLineWord.getPosition());
			System.out.println();
		}

		int i = 1;
		for (Iterator<LineWord> iterator = words.iterator(); iterator.hasNext();) {
			LineWord currentLineWord = (LineWord) iterator.next();
			String definition = currentLineWord.getWord().getDefinition();
			System.out.println("" + i++ + "." + definition);
		}

		System.out.println("----отговори----");
		int j = 1;
		for (Iterator<LineWord> iterator = words.iterator(); iterator.hasNext();) {
			LineWord currentLineWord = (LineWord) iterator.next();
			String definition = currentLineWord.getWord().getWord();
			System.out.println("" + j++ + "." + definition);
		}

	}
}
