package Controller;

public class UpdateGraph implements Graph {
    public int height1;
    public int height2;
    public int height3;

    public UpdateGraph(int height1, int height2, int height3){
        this.height1 = height1;
        this.height2 = height2;
        this.height3 = height3;
    }

    public int getHeight1() {
        return height1;
    }

    public int getHeight2() {
        return height2;
    }

    public int getHeight3() {
        return height3;
    }
}
