package com.company;

public class SolveIt
{
    private static int[][] sudokuPuzzle;
    private int sudokuDimension;
    //public static SolveIt solveIt = new SolveIt();
    public SolveIt()
    {
        SudokuInput sudokuInput = new SudokuInput();
        this.sudokuDimension = sudokuInput.getSudokuDimension();
        //this.sudokuPuzzle = new int[sudokuDimension][sudokuDimension];
        this.sudokuPuzzle = sudokuInput.getSudokuPuzzle();
        System.out.println( "SolveIt Class : \n" );
        sudokuInput.printArr( this.sudokuPuzzle );
        if(recursiveSolve( 0,0 ))
        {
            System.out.println( "\n\nSolved Sudoku : \n" );
            sudokuInput.printArr( this.sudokuPuzzle );
        }

    }
 //   public SolveIt getInstance() {
   //     return this.solveIt;
    // }

    private boolean recursiveSolve(int x_axis, int y_axis)
    {
         if(y_axis>=sudokuDimension) return true;

        int new_x_axis = x_axis, new_y_axis = y_axis;
        if((new_x_axis = setBoundries( x_axis )) == 0)
        {
            new_y_axis++;
        }
        boolean isZero = false;
        if(this.sudokuPuzzle[y_axis][x_axis] == 0)
        {
            isZero = true;
            for(int iterator =1; iterator <= sudokuDimension; iterator++)
            {
                if(checkValidity(x_axis, y_axis, iterator))
                {
                    sudokuPuzzle[y_axis][x_axis] = iterator;
                    if(recursiveSolve( new_x_axis, new_y_axis ))
                    {
                        return true;
                    }
                }
            }
            sudokuPuzzle[y_axis][x_axis] = 0;
        }
        else
        {
            if(recursiveSolve( new_x_axis, new_y_axis ))
            {
                return true;
            }
        }

        return false;
    }

    private int setBoundries(int input)
    {
        if(++input>=this.sudokuDimension)
        {
            input = 0;
        }
        return input;
    }

    private boolean checkValidity(int x_axis, int y_axis, int iterator)
    {
        for(int i = 0; i<sudokuDimension; i++)
        {
            if(sudokuPuzzle[y_axis][i] == iterator || sudokuPuzzle[i][x_axis] == iterator)
            {
                return false;
            }
        }
        //
        //          EXTRA Check is required
        //
        //
        return true;
    }
}
