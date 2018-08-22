import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.jblas.*;
/*
* [[[1,1],
* [1,1]],
*
* [[1,1]
* ,[1,1]]]
*
*
*
* */


public class Main {

    public static double sum(double[] column) {
        double total = 0;
        for(double n : column) {
            total+=n;
        }
        return total;
    }

    public static double[][] normalize(double[][] input) {
        double[][] matrix = input.clone();

        for(int j = 0; j < matrix.length; j++) {
            double[] column = matrix[j];
            double columnSum = sum(column);
            for(int k = 0; k < column.length; k++) {
                column[k] = column[k]/columnSum;
            }
        }
        return matrix;
    }

    public static double[] normalize(double[] input) {
        double[] matrix = input.clone();
        double columnSum = sum(matrix);
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = matrix[i]/columnSum;
        }
        return matrix;
    }

    public static double[] ringDist(double[][][] P_A, double[] P_alpha) {
        int card = P_alpha.length;
        double[] Q = new double[4096];
        for(int a1 = 0; a1 < 2; a1++) {
            for(int a2 = 0; a2 < 2; a2++) {
                for(int a3 = 0; a3 < 2; a3++) {
                    for(int b1 = 0; b1 < 2; b1++) {
                        for(int b2 = 0; b2 < 2; b2++) {
                            for(int b3 = 0; b3 < 2; b3++) {
                                for(int c1 = 0; c1 < 2; c1++) {
                                    for(int c2 = 0; c2 < 2; c2++) {
                                        for(int c3 = 0; c3 < 2; c3++) {
                                            for(int c4 = 0; c4 < 2; c4++) {
                                                for(int c5 = 0; c5 < 2; c5++) {
                                                    for(int c6 = 0; c6 < 2; c6++) {
                                                        for(int alpha1 = 0; alpha1 < card; alpha1++) {
                                                            for(int alpha2 = 0; alpha2 < card; alpha2++) {
                                                                for(int alpha3 = 0; alpha3 < card; alpha3++) {
                                                                    for(int beta1 = 0; beta1 < card; beta1++) {
                                                                        for(int beta2 = 0; beta2 < card; beta2++) {
                                                                            for(int beta3 = 0; beta3 < card; beta3++) {
                                                                                for(int gamma1 = 0; gamma1 < card; gamma1++) {
                                                                                    for(int gamma2 = 0; gamma2 < card; gamma2++) {
                                                                                        for(int gamma3 = 0; gamma3 < card; gamma3++) {
                                                                                            Q[2048*a1+1024*a2+512*a3+256*b1+128*b2+64*b3+32
                                                                                                    *c1+16*c2+8*c3+4*c4+2*c5+c6] +=
                                                                                                    P_A[gamma1][beta1][a1]*P_A[alpha1][gamma1][b1]*
                                                                                                    P_A[beta2][alpha1][c1]*P_A[gamma2][beta2][a2]*
                                                                                                    P_A[alpha2][gamma2][b2]*P_A[beta3][alpha2][c2]*
                                                                                                    P_A[gamma3][beta3][a3]*P_A[alpha3][gamma3][b3]*
                                                                                                    P_A[beta1][alpha3][c3]*P_A[beta1][alpha1][c4]*
                                                                                                    P_A[beta2][alpha2][c5]*P_A[beta3][alpha3][c6]*
                                                                                                    P_alpha[alpha1]*P_alpha[alpha2]*P_alpha[alpha3]*
                                                                                                    P_alpha[beta1]*P_alpha[beta2]*P_alpha[beta3]*
                                                                                                    P_alpha[gamma1]*P_alpha[gamma2]*P_alpha[gamma3];
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Q;
    }

    public static double[] ringDistNonSymmetric(double[][][] P_A, double[][][] P_B, double[][][] P_C,
                                                double[] P_alpha, double[] P_beta, double[] P_gamma) {
        int card = P_alpha.length;
        double[] Q = new double[4096];
        for(int a1 = 0; a1 < 2; a1++) {
            for(int a2 = 0; a2 < 2; a2++) {
                for(int a3 = 0; a3 < 2; a3++) {
                    for(int b1 = 0; b1 < 2; b1++) {
                        for(int b2 = 0; b2 < 2; b2++) {
                            for(int b3 = 0; b3 < 2; b3++) {
                                for(int c1 = 0; c1 < 2; c1++) {
                                    for(int c2 = 0; c2 < 2; c2++) {
                                        for(int c3 = 0; c3 < 2; c3++) {
                                            for(int c4 = 0; c4 < 2; c4++) {
                                                for(int c5 = 0; c5 < 2; c5++) {
                                                    for(int c6 = 0; c6 < 2; c6++) {
                                                        for(int alpha1 = 0; alpha1 < card; alpha1++) {
                                                            for(int alpha2 = 0; alpha2 < card; alpha2++) {
                                                                for(int alpha3 = 0; alpha3 < card; alpha3++) {
                                                                    for(int beta1 = 0; beta1 < card; beta1++) {
                                                                        for(int beta2 = 0; beta2 < card; beta2++) {
                                                                            for(int beta3 = 0; beta3 < card; beta3++) {
                                                                                for(int gamma1 = 0; gamma1 < card; gamma1++) {
                                                                                    for(int gamma2 = 0; gamma2 < card; gamma2++) {
                                                                                        for(int gamma3 = 0; gamma3 < card; gamma3++) {
                                                                                            Q[2048*a1+1024*a2+512*a3+256*b1+128*b2+64*b3+32
                                                                                                    *c1+16*c2+8*c3+4*c4+2*c5+c6] +=
                                                                                                    P_A[gamma1][beta1][a1]*P_B[alpha1][gamma1][b1]*
                                                                                                            P_C[beta2][alpha1][c1]*P_A[gamma2][beta2][a2]*
                                                                                                            P_B[alpha2][gamma2][b2]*P_C[beta3][alpha2][c2]*
                                                                                                            P_A[gamma3][beta3][a3]*P_B[alpha3][gamma3][b3]*
                                                                                                            P_C[beta1][alpha3][c3]*P_C[beta1][alpha1][c4]*
                                                                                                            P_C[beta2][alpha2][c5]*P_C[beta3][alpha3][c6]*
                                                                                                            P_alpha[alpha1]*P_alpha[alpha2]*P_alpha[alpha3]*
                                                                                                            P_beta[beta1]*P_beta[beta2]*P_beta[beta3]*
                                                                                                            P_gamma[gamma1]*P_gamma[gamma2]*P_gamma[gamma3];
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Q;
    }


    public static String rowPrint(double[] row) {
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < row.length; i++) {
            if(i==row.length-1) {
                s.append(row[i]);
            } else {
                s.append(row[i]).append(", ");
            }
        }
        return s.toString();
    }
    public static double[][] ringSampleSpace(int card) throws IOException {
        double[][] S = new double[4096][4096];
        for(int i = 0; i < S.length; i++) {
            if(i % 500 == 0 && i!=0) {
                String filename = "output_"+i+".dat";
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                for(int j = 0; j < i; j++) {
                    double[] row = S[j];
                    writer.write(rowPrint(row));
                    writer.write("\n");
                }
                writer.close();
            } else {
                double[][][] P_A = new double[2][card][card];
                P_A[0] = normalize(PrincetonMatrix.random(card,card));
                P_A[1] = normalize(PrincetonMatrix.random(card,card));
                double[] P_alpha = normalize(PrincetonMatrix.random(card,2)[0]);
                S[i] = ringDist(P_A,P_alpha);
                System.out.println((i+1)+" samples computed");
            }
        }
        return S;

    }
    public static double[][] ringSampleSpaceNonSymmetric(int card) throws IOException {
        double[][] S = new double[4096][4096];
        for(int i = 0; i < S.length; i++) {
            if(i % 500 == 0 && i!=0) {
                String filename = "output_"+i+".dat";
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                for(int j = 0; j < i; j++) {
                    double[] row = S[j];
                    writer.write(rowPrint(row));
                    writer.write("\n");
                }
                writer.close();
            } else {
                double[][][] P_A = new double[2][card][card];
                P_A[0] = normalize(PrincetonMatrix.random(card,card));
                P_A[1] = normalize(PrincetonMatrix.random(card,card));
                double[][][] P_B = new double[2][card][card];
                P_B[0] = normalize(PrincetonMatrix.random(card,card));
                P_B[1] = normalize(PrincetonMatrix.random(card,card));
                double[][][] P_C = new double[2][card][card];
                P_C[0] = normalize(PrincetonMatrix.random(card,card));
                P_C[1] = normalize(PrincetonMatrix.random(card,card));
                double[] P_alpha = normalize(PrincetonMatrix.random(card,2)[0]);
                double[] P_beta = normalize(PrincetonMatrix.random(card,2)[0]);
                double[] P_gamma = normalize(PrincetonMatrix.random(card,2)[0]);
                S[i] = ringDistNonSymmetric(P_A,P_B,P_C,P_alpha,P_beta,P_gamma);
                System.out.println((i+1)+" samples computed");
            }
        }
        return S;

    }


    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Cardinality: ");
        int card = reader.nextInt();
        reader.close();
        double[][] S = ringSampleSpaceNonSymmetric(card);
        System.out.println("hi");
        System.out.printf("\nS is %d x %d\n", S[0].length+1,S.length+1);

        /*
        int card = 2;
        double[][][] P_A = new double[2][card][card];
        P_A[0] = normalize(PrincetonMatrix.random(card,card));
        P_A[1] = normalize(PrincetonMatrix.random(card,card));
        double[] P_alpha = normalize(PrincetonMatrix.random(card,2)[0]);
        doubleMatrix a1 = new doubleMatrix(P_A[0]);
        doubleMatrix a2 = new doubleMatrix(P_A[1]);
        double[][] P_alpha_matrix = new double[][]{P_alpha};
        doubleMatrix alpha = new DoubleMatrix(P_alpha_matrix);
        a1.print();
        a2.print();
        alpha.print();
        */
    }
}
