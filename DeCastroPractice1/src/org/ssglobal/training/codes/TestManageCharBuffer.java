package org.ssglobal.training.codes;

import java.nio.CharBuffer;

public class TestManageCharBuffer {

	public static void main(String[] args) {
		ManageCharBuffer mcb = new ManageCharBuffer();
		CharBuffer buffer = mcb.bufferizedString("test lang");
		System.out.println(mcb.extractString(buffer));
		
		buffer = mcb.bufferizedString("test lang ulit");
		System.out.println(mcb.extractString(buffer));
	}

}
