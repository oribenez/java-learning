package maman12;
/**
 *  This class represents a Point object in the Cartesian coordinate system
 * @author Ori Ben-Ezra
 * @version 22-02-2021
 */
public class Point {
    // Declaration
    private static final int AXIS_DEFAULT_VAL = 0;
    private double _x; // X axis
    private double _y; // Y axis

    /**
     * Constructor which initialize Point obj variables using two new known values
     * @param x Represents the X value on the Cartesian system
     * @param y Represents the Y value on the Cartesian system
     */
    public Point(double x, double y) {
        _x = x;
        _y = y;
    }

    /**
     * Constructor which initialize Point object variables using other point obj values
     * @param other Represents Point object
     */
    public Point(Point other) {
        _x = other._x;
        _y = other._y;
    }

    /**
     * @return X value of this Point object
     */
    public double getX(){
        return _x;
    }

    /**
     * @return Y value of this Point object
     */
    public double getY(){
        return _y;
    }

    /**
     * Sets X coordinate of this Point object
     * @param num the desired num to change to.
     */
    public void setX(double num) {
        _x = num;
    }

    /**
     * Sets Y coordinate of this Point object
     * @param num the desired num to change to.
     */
    public void setY(double num) {
        _y = num;
    }

    /**
     * @param other Point object to compare to
     * @return true if this Point object equals to the object argument, otherwise false.
     */
    public boolean equals(Point other) {
        if (other._x == _x && other._y == _y)
            return true;
        return false;
    }

    /**
     * @param other Point object to compare to
     * @return true if this Point object is above the object argument, otherwise false.
     */
    public boolean isAbove(Point other) {
        if (_y > other._y) 
            return true;
        return false;
    }

    /**
     * @param other Point object to compare to
     * @return true if this Point object is under the object argument, otherwise false.
     */
    public boolean isUnder(Point other) {
        return !isAbove(other);
    }

    /**
     * @param other Point object to compare to
     * @return true if this Point object is on the left of the object argument, otherwise false.
     */
    public boolean isLeft(Point other) {
        if (_x > other._x) 
            return true;
        return false;
    }

    /**
     * @param other Point object to compare to
     * @return true if this Point object is on the right of the object argument, otherwise false.
     */
    public boolean isRight(Point other) {
        return !isLeft(other);
    }

    /**
     * Method which calculates the distance between two arguments
     * @param p Point object to measure distance to it
     * @return distance between this Point object and the argument Point
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p._y - _y,2) + Math.pow(p._x - _x,2));
    }

    /**
     * This method check in which quarter of the Cartesian coordinate system this point exists
     * @return the quarter in which the point exists on it.
     */
    public int quadrant() {
        if (_x > AXIS_DEFAULT_VAL && _y > AXIS_DEFAULT_VAL) { // quarter I
            return 1;
        } else if (_x < AXIS_DEFAULT_VAL && _y > AXIS_DEFAULT_VAL){ // quarter II
            return 2;
        } else if (_x < AXIS_DEFAULT_VAL && _y < AXIS_DEFAULT_VAL){ // quarter III
            return 3;
        } else if (_x > AXIS_DEFAULT_VAL && _y < AXIS_DEFAULT_VAL){ // quarter IV
            return 4;
        } 
        return 0;
    }

    /**
     * A method which overrides the base class toString method
     * @return Coordinates of this Point object
     */
    public String toString() {
        return "(" + _x + "," + _y + ")";
    }
}
