package maman13;

import org.w3c.dom.css.RGBColor;

/**
 * RGBImage Class represents an object which build an image using a grid of colors.
 * @author Ori Ben-Ezra
 * @version 27-02-2021
 */
public class RGBImage {
    private RGBColor[][] _imgGrid;

    /**
     * Constructor which create a new object of a black image
     * @param rows size of the rows
     * @param cols size of the columns
     */
    public RGBImage(int rows, int cols) {
        _imgGrid = new RGBColor[rows][cols];

        // initialize color table
        for (int i = 0; i < _imgGrid.length; i++) {
            for (int j = 0; j < _imgGrid[i].length; j++) {
                _imgGrid[i][j] = new RGBColor();
            }
        }
    }

    /**
     * Constructor which build an RGBImage object using a table of colors
     * @param pixels the table of colors which will build the desired image.
     */
    public RGBImage(RGBColor[][] pixels) {
        int rows = pixels.length;
        int cols = pixels[0].length;

        _imgGrid = new RGBColor[rows][cols];

        // initialize color table
        for (int i = 0; i < _imgGrid.length; i++) {
            for (int j = 0; j < _imgGrid[i].length; j++) {
                _imgGrid[i][j] = new RGBColor(pixels[i][j]); // clone color object
            }
        }
    }

    /**
     * Constructor which clone an RGBImage object.
     * @param other The image to clone
     */
    public RGBImage(RGBImage other) {
        this(other._imgGrid); // 'this' refers to the other constuctor.
    }

    /**
     * Method that returns the height of this image
     * @return Number of pixels of this image [image height]
     */
    public int getHeight() {
        return _imgGrid.length;
    }

    /**
     * Method that returns the width of this image
     * @return Number of pixels of this image [image width]
     */
    public int getWidth() {
        return _imgGrid[0].length;
    }

    /**
     * Method which returns a specific pixel in this image
     * @param row the row index in this image
     * @param col the column index in this image
     * @return RGBColor object of the image. If coordinates out of bounds so the returnd RGBColor is black by default.
     */
    public RGBColor getPixel (int row, int col) {
        // checks if the coordinates are in bounds.
        if (row >= 0 && row < _imgGrid.length) {
            if (col >= 0 && col < _imgGrid[0].length) {
                return _imgGrid[row][col];
            }
        }
        return RGBColor();
    }
    /**
     * Method which set a given color to a specific give coordinate.
     * @param row the row index in this image
     * @param col the column index in this image
     * @param pixel the new pixel to change to.
     */
    public void setPixel (int row, int col, RGBColor pixel) {
        // checks if the coordinates are in bounds.
        if (row >= 0 && row < _imgGrid.length) {
            if (col >= 0 && col < _imgGrid[0].length) {
                _imgGrid[row][col] = new RGBColor(pixel);
            }
        }
    }

    /**
     * Method which compares between two RGBImage.
     * @param other the image to compare to
     * @return True if the images are equal in their pixels values and amount
     */
    public boolean equals (RGBImage other) {
        //check if images have the same width and height
        if (_imgGrid.length == other._imgGrid.length) { // check height
            if (_imgGrid[0].length == other._imgGrid[0].length) { // check width
            
                for (int i = 0; i < _imgGrid.length; i++) {
                    for (int j = 0; j < _imgGrid[i].length; j++) {
                        //checks every color in the image grid if they are equal
                        if (!_imgGrid[i][j].equals(other._imgGrid[i][j]))
                            return false; // False for the first unequal color
                    }
                }

                return true; // the images have compared and found to be equal
            }
        }
        return false; // the images aren't equal cause they don't have same sizes
    }

    /**
     * Method which flip Horizontaly this image
     */
    public void flipHorizontal() {
        for (int i = 0; i < _imgGrid.length; i++) {

            // Run on half of the columns
            for (int j = 0; j < _imgGrid[i].length / 2; j++) {

                // color exchange
                RGBColor tempColor = _imgGrid[i][j];
                _imgGrid[i][j] = _imgGrid[i][_imgGrid[i].length - j - 1];
                _imgGrid[i][_imgGrid[i].length - j - 1] = tempColor;

            }
        }
    }
    /**
     * Method which flip Verticaly this image
     */
    public void flipVertical() {
        for (int i = 0; i < _imgGrid.length / 2; i++) {

            // Run on half of the columns
            for (int j = 0; j < _imgGrid[i].length; j++) {

                // color exchange
                RGBColor tempColor = _imgGrid[i][j];
                _imgGrid[i][j] = _imgGrid[_imgGrid.length - i - 1][j];
                _imgGrid[_imgGrid.length - i - 1][j] = tempColor;

            }
        }
    }
    
    /**
     * Method which changes every color to it's complementary color
     */
    public void invertColors() {
        for (int i = 0; i < _imgGrid.length; i++) {
            for (int j = 0; j < _imgGrid[i].length; j++) {
                _imgGrid[i][j].setRed(255 - _imgGrid[i][j].getRed());
                _imgGrid[i][j].setGreen(255 - _imgGrid[i][j].getGreen());
                _imgGrid[i][j].setBlue(255 - _imgGrid[i][j].getBlue());
            }
        }
    }

    /**
     * Method which rotate this image clockwise
     */
    public void rotateClockwise() {
        //original rows and columns
        int originRows = _imgGrid.length;
        int originCols = _imgGrid[0].length;

        // the new rotated image grid
        RGBColor[][] newImgGrid = new RGBColor[originCols][originRows];

        // rotate 2D array clockwise
        for (int i = 0; i < originRows; i++) {
            for (int j = 0; j < originCols; j++) {
                newImgGrid[j][originRows - i - 1] = _imgGrid[i][j];
            }
        }

        _imgGrid = newImgGrid;
    }

    /**
     * Method which rotate this image counter clockwise
     */
    public void rotateCounterClockwise() {
        // original rows and columns
        int originRows = _imgGrid.length;
        int originCols = _imgGrid[0].length;

        // the new rotated image grid
        RGBColor[][] newImgGrid = new RGBColor[originCols][originRows];

        // rotate 2D array counter clockwise
        for (int i = 0; i < originRows; i++) {
            for (int j = 0; j < originCols; j++) {
                newImgGrid[originCols - j - 1][i] = _imgGrid[i][j];
            }
        }

        _imgGrid = newImgGrid;
    }
}
