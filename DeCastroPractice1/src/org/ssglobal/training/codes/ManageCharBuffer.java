package org.ssglobal.training.codes;

import java.nio.CharBuffer;

public class ManageCharBuffer {

	public CharBuffer bufferizedString(String input) {
		CharBuffer buffer = CharBuffer.allocate(input.length());
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			buffer.put(c);
		}
		return buffer;
	}
	
	public String extractString(CharBuffer buffer) {
		buffer.flip();
		StringBuilder temp = new StringBuilder();
		while(buffer.hasRemaining()) {
			temp.append(buffer.get());
		}
		String result = new String(temp.toString());
		return result;
	}
}
