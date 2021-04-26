package lcs_problem;


public class LCS_tests
{
	
static int tries_of_naive = 0;
static int tries_of_dynamic_programming = 0;


/* Abordagem Naive*/
/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
int lcs_naive( char[] X, char[] Y, int m, int n )
{
	if (m == 0 || n == 0){
		//tries_of_naive += 1;
	return 0;
	}
	if (X[m-1] == Y[n-1]) {	
		//tries_of_naive += 1;
	return 1 + lcs_naive(X, Y, m-1, n-1);
	}
	else {
		//tries_of_naive += 1;
	return max(lcs_naive(X, Y, m, n-1), lcs_naive(X, Y, m-1, n));
	}
	
}

/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
int lcs_dynamic_programming( char[] X, char[] Y, int m, int n )
{
	long tempoInicial = System.currentTimeMillis();
  int L[][] = new int[m+1][n+1];

  /* Following steps build L[m+1][n+1] in bottom up fashion. Note
       that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
  for (int i=0; i<=m; i++)
  {
    for (int j=0; j<=n; j++)
    {
    	//tries_of_dynamic_programming += 1;
      if (i == 0 || j == 0) {
    	  
          L[i][j] = 0;
      }
      else if (X[i-1] == Y[j-1]) {
    	  
          L[i][j] = L[i-1][j-1] + 1;
      }
      else {
    	  
          L[i][j] = max(L[i-1][j], L[i][j-1]);
    }
    }
    }
  long tempoFinal = System.currentTimeMillis();
  System.out.printf("Tempo de execucao do LCS com programacao dinamica: " + "%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

return L[m][n];
}

/* Utility function to get max of 2 integers */
int max(int a, int b)
{
	return (a > b)? a : b;
}

public static void main(String[] args)
{
	LCS_tests lcs = new LCS_tests();
	//String s1 = "ZYXWX";
	//String s2 = "WXYXZ";

	//String s1 = "FEDAWTHDVW";
	//String s2 = "WXYXZZKJVY";
	
	String s1 = "FEDAWTHDVWHGTYH";
	String s2 = "WXYXZZKJVYHGTEF";
	
	//String s1 = "ZYXWXWZYFGFDHSEFRECQ";
	//String s2 = "WXYXZZFHJGYKUGKGRHQC";

	//String s1 = "ZYXWXWZYFGFDHSEFRECQKH";
	//String s2 = "WXYXZZFHJGYKUGKGRHQCHGBTY";
	
	
	char[] A=s1.toCharArray();
	char[] B=s2.toCharArray();
	int n = A.length;
	int m = B.length;
	
	System.out.println("n is: " + n);
	System.out.println("m is: " + m);
	System.out.println("A is: " + s1);
	System.out.println("B is: " + s2);
	
	
	
	System.out.println("Length of LCS with dynamic programming is" + " " +
			lcs.lcs_dynamic_programming( A, B, n, m ) );
	
	long tempoInicial = System.currentTimeMillis();
	System.out.println("Length of LCS with naive approach is" + " " +
								lcs.lcs_naive( A, B, n, m ));
	long tempoFinal = System.currentTimeMillis();
    System.out.printf("Tempo de execucao do LCS com abordagem naive: " + "%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

}
}

// This Code is Contributed by Saket Kumar
