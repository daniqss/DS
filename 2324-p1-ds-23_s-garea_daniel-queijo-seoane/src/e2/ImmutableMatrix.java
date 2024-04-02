package e2;

public final class ImmutableMatrix {
    private final int[][] dataMatrix;


    public ImmutableMatrix(int[][] arr) { //Contructor que crea una InmmutableMatrix a través dec una matriz
        int rows;
        int columns;

        if (arr == null || (arr.length == 0) || (arr[0].length == 0))
            throw new IllegalArgumentException();

        rows = arr.length;
        columns = arr[0].length;
        dataMatrix = new int[rows][columns];


        for (int i = 0; i < rows; i++) {
            if (columns != arr[i].length) //Si el array es irregular, lanzar excepción
                throw new IllegalArgumentException();

            System.arraycopy(arr[i], 0, dataMatrix[i], 0, columns);
        }
    }

    public ImmutableMatrix(int rows, int columns) { //Constructor que crea una InmmutableMatrix con rows filas y columns columnas
        int contador = 1;
        if (rows <= 0 || columns <= 0)
            throw new IllegalArgumentException();
        else {
            dataMatrix = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    dataMatrix[i][j] = contador;
                    contador++;
                }
            }
        }
    }

    public int rowCount() {return dataMatrix.length;}

    public int columnCount() {
        if (rowCount() == 0) return 0;
        else return dataMatrix[0].length;
    }

    public int[][] toArray2D () {
        int rows = rowCount();
        int columns = columnCount();
        int[][] array = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(dataMatrix[i], 0, array[i], 0, columns);
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        int rows = rowCount();
        int columns = columnCount();

        for (int i = 0; i < rows; i++) {
            aux.append("[");
            for (int j = 0; j < columns; j++) {
                aux.append(dataMatrix[i][j]);
                if (j != columns - 1) aux.append(", ");
            }
            aux.append("]\n");
        }
        return aux.toString();
    }

    public int at(int x, int y){
        if( x < 0 || y < 0 )
            throw new IllegalArgumentException();
        else if (x > rowCount() || y > columnCount()) {
            throw new IllegalArgumentException();
        }
        else{
            return dataMatrix[x][y];
        }
    }

    public ImmutableMatrix reverse() {
        int rows = rowCount();
        int columns = columnCount();
        int[][] reversedMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                reversedMatrix[i][j] = at(i, columns - 1 -j);
            }
        }
        return new ImmutableMatrix(reversedMatrix);
    }

    public ImmutableMatrix transpose() {
        int rows = rowCount();
        int columns = columnCount();
        int[][] transposedMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = at(i, j);
            }
        }
        return new ImmutableMatrix(transposedMatrix);
    }

    public ImmutableMatrix reshape(int newColumns) {
        int rows = rowCount();
        int columns = columnCount();
        int newRows = rows * columns / newColumns;
        int aux, i, j;
        int[][] reshapedMatrix = new int[newRows][newColumns];

        if (rows * columns % newColumns != 0)
            throw new IllegalArgumentException();

        for (i = 0, aux = 0; i < newRows; i++) {
            for (j = 0; j < newColumns; j++) {
                reshapedMatrix[i][j] = at(aux / columns, aux % columns);
                aux++;
            }
        }
        return new ImmutableMatrix(reshapedMatrix);
    }
}
