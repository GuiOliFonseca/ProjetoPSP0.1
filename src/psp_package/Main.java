package psp_package;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int n = 0, x = 0, y = 0, z = 0, w = 0;
		n = teclado.nextInt();
		
		int[] pontosTime = new int[n];
		int[] pontuacaoTimes = new int[n];
		int[] pontuacaoSofrida = new int[n];
		
		int[] classificacao = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			pontosTime[i] = 0;
			pontuacaoTimes[i] = 0;
			pontuacaoSofrida[i] = 0;
			classificacao[i] = i;
		}

		int cont = (n*(n-1))/2;
		for (int i = 0; i < cont; i++) {
			
			x = teclado.nextInt();
			y = teclado.nextInt();
			z = teclado.nextInt();
			w = teclado.nextInt();
			
			pontuacaoTimes[x-1] += y;
			pontuacaoTimes[z-1] += w;
			
			pontuacaoSofrida[x-1] += w;
			pontuacaoSofrida[z-1] += y;
			
			if(y > w) {
				
				pontosTime[x-1] += 2;
				pontosTime[z-1] += 1;
			}else {
				
				pontosTime[z-1] += 2;
				pontosTime[x-1] += 1;
			}
		}
		
		System.out.print("pontuacaoSofrida:" + Arrays.toString(pontuacaoSofrida) + "\nPontuacaoTimes: " + Arrays.toString(pontuacaoTimes) + "\npontosTime: " + Arrays.toString(pontosTime));
		classificacao = ordenaClassificacao(n, pontosTime, classificacao, pontuacaoSofrida, pontuacaoTimes);
		
		for (int i = classificacao.length-1; i >=0; i--) 
			System.out.print(classificacao[i]+1 + " ");
		
		teclado.close();
	}

	public static int[] ordenaClassificacao(int n, int[] pontosTime, int[] classificacao, int[] pontuacaoSofrida, int[] pontuacaoTimes) {
		
		quickSort(pontosTime, classificacao, 0, n-1);
		
		for (int i = n-1; i >= 0; i--) {
			
			boolean troca = false;
			if(i - 1 >= 0) {
				
				if(pontosTime[i] == pontosTime[i-1]) {
					
					int avarageA = (pontuacaoSofrida[classificacao[i]] != 0) ? pontuacaoTimes[classificacao[i]]/pontuacaoSofrida[classificacao[i]] : pontuacaoTimes[classificacao[i]];
					int avarageB = (pontuacaoSofrida[classificacao[i-1]] != 0) ? pontuacaoTimes[classificacao[i-1]]/pontuacaoSofrida[classificacao[i-1]] : pontuacaoTimes[classificacao[i-1]];
					
					if(avarageB > avarageA) 
						troca = true;
					else if(pontuacaoTimes[classificacao[i-1]] > pontuacaoTimes[classificacao[i]])
						troca = true;
					else if(classificacao[i-1] < classificacao[i])
						troca = true;
					
					if(troca) {
						
						int swap = classificacao[i];
						classificacao[i] = classificacao[i-1];
						classificacao[i-1] = swap;
					}
				}	
			}
		}
		
		for (int i = classificacao.length-1; i >=0; i--) 
			System.out.println(classificacao[i] + " ");
		
		return classificacao;
	}

	public static void quickSort(int[] pontuacaoTimes, int[] classificacao, int begin, int end) {
		
		if(begin < end) {
			
			int index = partition(pontuacaoTimes, classificacao, begin, end);
			
			quickSort(pontuacaoTimes, classificacao, begin, index-1);
			quickSort(pontuacaoTimes, classificacao, index+1, end);
		}
	}

	public static int partition(int[] pontuacaoTimes, int[] classificacao, int begin, int end) {
		
		int pivot = pontuacaoTimes[end];
		int i = begin-1;
		
		for (int j = begin; j < end; j++) {
			
			if(pontuacaoTimes[j] <= pivot) {
				
				i++;
				int swap = pontuacaoTimes[i];
				pontuacaoTimes[i] = pontuacaoTimes[j];
				pontuacaoTimes[j] = swap;
				
				swap = classificacao[i];
				classificacao[i] = classificacao[j];
				classificacao[j] = swap;
			}
		}
		int swap = pontuacaoTimes[i+1];
		pontuacaoTimes[i+1] = pontuacaoTimes[end];
		pontuacaoTimes[end] = swap;
		
		swap = classificacao[i+1];
		classificacao[i+1] = classificacao[end];
		classificacao[end] = swap;
		return i+1;
	}
}
