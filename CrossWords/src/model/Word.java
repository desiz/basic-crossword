package model;

public class Word {
	@Override
	public String toString() {
		return "Word [word=" + word + ", definition=" + definition + ", used="
				+ used + "]";
	}

	private String word;
	private String definition;
	private boolean used = false;
	
	public Word(String word, String definition) {
		super();
		this.word = word;
		this.definition = definition;
	}
	
	public boolean hasLetter(char letter){
		boolean result = false;
		if (word != null) {
			result = word.indexOf(letter) >= 0;
		}
		return result;
	}

	public int getPositionOf(char letter){
		int result = -1;
		if (word != null) {
			result = word.indexOf(letter);
		}
		return result;
	}
	
	public int getLength(){
		int result = 0;
		if (word != null) {
			result = word.length();
		}
		return result;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
}
