package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SudokuInput
{

    private static int[][] sudokuPuzzle;
    private int sudokuDimension = 9;

    public int getSudokuDimension() {
        return sudokuDimension;
    }

    public int[][] getSudokuPuzzle() {
        return sudokuPuzzle;
    }


    public void setSudokuPuzzle() throws Exception {
        //Scanner sc = new Scanner( System.in );
        sudokuPuzzle = new int[sudokuDimension][sudokuDimension];
        //sc.nextLine();
        FileReader fileReader = new FileReader( "C:\\Users\\manrajs\\OneDrive - AMDOCS\\Backup Folders\\Documents\\SudokuPuzzle.txt" );
        BufferedReader bufferedReader = new BufferedReader( fileReader );
        String input = "";
        int sudokuPuzzleXaxis = 0, sudokuPuzzleYaxis = 0;
        while((input = bufferedReader.readLine()) != null)
        {
            String[] splitInput = input.split( "" );
            for(int t=0; t<splitInput.length; t++)
            {
                int getIndividualValue = convertValue(splitInput[t]);
                System.out.println("\t\tFileInput = "+splitInput[t]);
                if (getIndividualValue>=0)
                {
                    sudokuPuzzle[sudokuPuzzleYaxis][sudokuPuzzleXaxis] = getIndividualValue;
                    if(++sudokuPuzzleXaxis>=sudokuDimension)
                    {
                        sudokuPuzzleYaxis++;
                        sudokuPuzzleXaxis = 0;
                    }
                }

            }
        }
        System.out.println("Converted Puzzle:\n\n");
        printArr(sudokuPuzzle);
    }

    private int convertValue(String value)
    {
        int intValue = -1;
        try {
            intValue = Integer.parseInt( value );
        }
        catch (Exception e) {
            if(value.equals("_") || value.equals("-"))
            {
                intValue = 0;
            }
        }
        return intValue;
    }

    public void printArr(int[][] sudokuPuzzle)
    {
        for(int t=0; t<sudokuDimension; t++)
        {
            for(int tt=0; tt<sudokuDimension; tt++)
            {
                System.out.print(sudokuPuzzle[t][tt]+"  ");
            }
            System.out.println();
        }
    }
}
