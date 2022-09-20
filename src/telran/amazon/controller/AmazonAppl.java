package telran.amazon.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AmazonAppl {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(FindClusters(arr));
    }
    public static int FindClusters(int[][] arr){
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1) {
                    bfs(arr, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }
    private static void bfs(int[][] arr, int i, int j){
        if(arr[i][j] == 1)
            arr[i][j] = 0;
        if(i + 1 < arr.length && arr[i+1][j] == 1)
            bfs(arr,i+1,j);
        if(i - 1 >= 0 && arr[i-1][j] == 1)
            bfs(arr,i-1,j);
        if(j + 1 < arr[i].length && arr[i][j+1] == 1){
            bfs(arr,i,j+1);
        }
        if(j-1 >= 0 && arr[i][j-1] == 1){
            bfs(arr,i,j-1);
        }
    }
}
/*
5
4
1 1 0 0
0 0 1 0
0 0 0 0
1 0 1 1
1 1 1 1
* */
