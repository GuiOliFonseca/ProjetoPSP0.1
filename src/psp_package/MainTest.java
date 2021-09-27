package psp_package;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testClassificacaoSemEmpates() {
		
		int[] a = {8,7,4,6,5};
		int[] b = {0,1,2,3,4};
		int[] c = {370,325,380,422,387};
		int[] d = {476,312,354,360,382};
		
		int[] classificacao = Main.ordenaClassificacao(5, a, b, c, d);
		
		int [] expected = {2,4,3,1,0};
		assertEquals(Arrays.toString(expected), Arrays.toString(classificacao));
	}
	
	@Test
	void testClassificacaoEmpatePontos() {
		
		int[] a = {7,7,4,6,6};
		int[] b = {0,1,2,3,4};
		int[] c = {372,325,380,422,387};
		int[] d = {476,312,354,360,384};
		
		int[] classificacao = Main.ordenaClassificacao(5, a, b, c, d);
		
		int [] expected = {2,4,3,1,0};
		assertEquals(Arrays.toString(expected), Arrays.toString(classificacao));
	}
	
	@Test
	void testClassificacaoEmpateTudo() {
		
		int[] a = {7,7,4,6,6};
		int[] b = {0,1,2,3,4};
		int[] c = {373,373,446,466,441};
		int[] d = {476,476,357,408,382};
		
		int[] classificacao = Main.ordenaClassificacao(5, a, b, c, d);
		
		int [] expected = {2,4,3,1,0};
		assertEquals(Arrays.toString(expected), Arrays.toString(classificacao));
	}
}

//SEM EMPATES
//5
//1 102 2 62
//1 128 3 127
//1 144 4 80
//1 102 5 101
//2 62 3 61
//2 100 4 80
//2 88 5 82
//3 79 4 90
//3 87 5 100
//4 110 5 99

//EMPATE EM PONTOS
//5
//1 102 2 62
//1 128 3 127
//1 144 4 80
//1 102 5 103
//2 62 3 61
//2 100 4 80
//2 88 5 82
//3 79 4 90
//3 87 5 100
//4 110 5 99


//EMPATE EM TUDO
//5
//1 102 2 62
//1 128 3 127
//1 144 4 81
//1 102 5 103
//2 128 3 64
//2 144 4 127
//2 142 5 80
//3 79 4 90
//3 87 5 100
//4 110 5 99