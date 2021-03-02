package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaginationTest {

	@Test
	public void test() {
		/***Given***/
		int userTotcnt = 32;
		int pageSize = 5;

		/***When***/
		int pagination = (int)Math.ceil((double)userTotcnt/pageSize);
		
		
		
		

		/***Then***/
		assertEquals(7, pagination);
	}

}
