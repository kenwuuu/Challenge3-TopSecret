/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author kenneth2
 */
public class CaesarCipher {
	public static void main(String[] strings) {
		int offset = 0;
		int rollover = 0;
		int rollunder = 0;
		boolean quit = false;

		StringBuffer stringBuffer = new StringBuffer();

//		asks for values, confirms values
		System.out.println("Please enter the shift value (between -25..-1 and 1..25)");
		offset = TextIO.getlnInt();

		if (offset == 999) {
			offset = 0;
			System.out.println("Using position shift");

			while (!quit) {
				System.out.println("Please enter the source text (empty line to quit)");
				String line = TextIO.getln();
//				checks for quit statement. Breaks loop and prints bye as last line
				if (line.contentEquals("")) {
					quit = true;
					break;
				}

				System.out.println("Source   :" + line);
				line = line.toUpperCase();

				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
//				appends original punctuation
					if ((c >= 32 && c <=64) || (c >= 91 && c <= 126)) {
						stringBuffer.append(c);
					} else {
//					calculates rollover for characters
						if ((c + offset - 64 > 26)) {
							rollover = (c + offset - 64) % 26;
					}
//					if offset doesn't cause rollover, offset like normal
						if (rollover == 0) {
							c += offset;
							stringBuffer.append((c));
//					if offset causes rollover, offset with rollover from respective letters
						} else if (rollover > 0) {
							c = (char) (64 + rollover);
							stringBuffer.append(c);
						}
//					resets rollover for next loop
						rollover = 0;
					}
					offset++;
					if (offset > 26) offset = 1;
				}
				System.out.println("Processed:" + stringBuffer);
				stringBuffer.delete(0, stringBuffer.length());
			}
		}

		if (offset == -999) {
			offset = 0;
			System.out.println("Using position shift");

			while (!quit) {
				System.out.println("Please enter the source text (empty line to quit)");
				String line = TextIO.getln();
//				checks for quit statement. Breaks loop and prints bye as last line
				if (line.contentEquals("")) {
					quit = true;
					break;
				}

				System.out.println("Source   :" + line);
				line = line.toUpperCase();

				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
//				appends original punctuation
					if ((c >= 32 && c <=64) || (c >= 91 && c <= 126)) {
						stringBuffer.append(c);
					} else {
//					calculates rollover for characters
						if ((c - offset - 64 < 1)) {
							rollover = (c - offset - 64) % -26;
						}
//					if offset doesn't cause rollover, offset like normal
						if (rollover == 0) {
							c -= offset;
							stringBuffer.append((c));
//					if offset causes rollover, offset with rollover from respective letters
						} else if (rollover < 0) {
							c = (char) (90 + rollover);
							stringBuffer.append(c);
						}
//					resets rollover for next loop
						rollover = 0;
					}
					offset++;
					if (offset > 26) offset = 1;
				}
				System.out.println("Processed:" + stringBuffer);
				stringBuffer.delete(0, stringBuffer.length());
			}
		}

		if (!quit) {
			while (!quit && (offset > 25 || offset < -25 || offset == 0)) {
				System.out.println(offset + " is not a valid shift value.");
				System.out.println("Please enter the shift value (between -25..-1 and 1..25)");
				offset = TextIO.getlnInt();
			}
			System.out.println("Using shift value of " + offset);
		}

//		asks for text, calculates rollover and then appends to StringBuffer
		while(!quit) {
			System.out.println("Please enter the source text (empty line to quit)");
			String line = TextIO.getln();
//			checks for quit statement. Breaks loop and prints bye as last line
			if (line.contentEquals("")) break;

			System.out.println("Source   :" + line);
			line = line.toUpperCase();

//			loops index in string, calculating which character to shift to
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
//				appends original punctuation
				if ((c >= 32 && c <=64) || (c >= 91 && c <= 126)) {
					stringBuffer.append(c);
				} else {
//					calculates rollover for characters
					if ((c + offset - 64 > 26)) {
						rollover = (c + offset - 64) % 26;
					}
					if ((c + offset - 64 < 1)) {
						rollunder = (c + offset - 65);
					}
//					if offset doesn't cause rollover, offset like normal
					if (rollover == 0 && rollunder == 0) {
						c += offset;
						stringBuffer.append((c));
//					if offset causes rollover, offset with rollover from respective letters
					} else if (rollover > 0) {
						c = (char) (64 + rollover);
						stringBuffer.append(c);
					} else if (rollunder < 0) {
						c = (char) (91 + rollunder);
						stringBuffer.append(c);
					}
//					resets rollover for next loop
					rollover = 0;
					rollunder = 0;
				}
			}
			System.out.println("Processed:" + stringBuffer);
			stringBuffer.delete(0, stringBuffer.length());
		}

		System.out.println("Bye.");
	}
}
