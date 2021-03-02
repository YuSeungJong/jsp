package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUnitTest {

	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";

		/***When***/
		String filename = FileUtil.getFileName(contentDisposition);

		/***Then***/
		assertEquals("brown.png", filename);
	}
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String filename = "brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFileExtensionTest2() {
		/***Given***/
		String filename = "line.brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFileExtensionTest3() {
		/***Given***/
		String filename = "brown";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		/***Then***/
		assertEquals("", extension);
	}
}









