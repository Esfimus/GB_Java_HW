package lesson09;

public abstract class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}

class MyArraySizeException extends MyException {

    private final int xTotal;
    private final int yTotal;

    public int getxTotal() {
        return xTotal;
    }

    public int getyTotal() {
        return yTotal;
    }

    public MyArraySizeException(String message, int yTotal, int xTotal) {
        super(message);
        this.yTotal = yTotal;
        this.xTotal = xTotal;
    }
}

class MyArrayDataException extends MyException {

    private final int y;
    private final int x;
    private final String cell;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String getCell() {
        return cell;
    }

    public MyArrayDataException(String message, String cell, int y, int x) {
        super(message);
        this.y = y;
        this.x = x;
        this.cell = cell;
    }
}