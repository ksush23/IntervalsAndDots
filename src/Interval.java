public class Interval{
    private int leftCoordinate;
    private int rightCoordinate;
    private static boolean sortByLeft;

    public Interval (int _leftCoordinate, int _rightCoordinate){
        leftCoordinate = _leftCoordinate;
        rightCoordinate = _rightCoordinate;
        sortByLeft = true;
    }

    public boolean isSortByLeft() {
        return sortByLeft;
    }

    public static void setSortByLeft(boolean _sortByLeft){
        sortByLeft = _sortByLeft;
    }

    public void setLeftCoordinate(int leftCoordinate) {
        this.leftCoordinate = leftCoordinate;
    }

    public int getLeftCoordinate() {
        return leftCoordinate;
    }

    public int getRightCoordinate() {
        return rightCoordinate;
    }

    public void setRightCoordinate(int rightCoordinate) {
        this.rightCoordinate = rightCoordinate;
    }

    public int getCoordinate(){
        if (sortByLeft){
            return leftCoordinate;
        }
        return rightCoordinate;
    }

    public int getOtherCoordinate(){
        if (!sortByLeft){
            return leftCoordinate;
        }
        return rightCoordinate;
    }

    public void swap (Interval b){
        int temp = this.leftCoordinate;
        this.leftCoordinate = b.leftCoordinate;
        b.leftCoordinate = temp;

        temp = this.rightCoordinate;
        this.rightCoordinate = b.rightCoordinate;
        b.rightCoordinate = temp;
    }
}
