package model;

public class LineWord {
	@Override
	public String toString() {
		return "LineWord [word=" + word + ", position=" + position + "]";
	}
	private Word word;
	private int position;
	
	public LineWord(Word word, int position) {
		super();
		this.word = word;
		this.position = position;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void draw(int offsett){
		//+---+
		//| C |
		//+---+
		
		drawOffsett(offsett);
		for (int i = 0; i < word.getWord().length(); i++) {
			if (i <= word.getWord().length()) {
				System.out.print("+---");
			}
		}
		System.out.print("+");
		System.out.println();

		drawOffsett(offsett);
		for (int i = 0; i < word.getWord().length(); i++) {
			if (i <= word.getWord().length()) {
				char symbol = ' ';
				if (i == position) {
					symbol = word.getWord().charAt(i);
				}
				System.out.print("| " + symbol + " ");
			}
		}
		System.out.print("|");
		System.out.println();

		drawOffsett(offsett);
		for (int i = 0; i < word.getWord().length(); i++) {
			if (i <= word.getWord().length()) {
				System.out.print("+---");
			}
		}
		System.out.print("+");
	}
	
	private void drawOffsett(int offsett){
		for (int i = 0; i < offsett; i++) {
			System.out.print("    ");
		}
		System.out.print(" ");

	}
}
