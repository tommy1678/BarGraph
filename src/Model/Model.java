package Model;

public class Model {
    private int height1;
    private int height2;
    private int height3;

    public Model(){
        height1 = 0;
        height2 = 0;
        height3 = 0;

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

    public void setHeight1(int height1) {
        if(height1 > 0) {
            this.height1 = height1;
        }
    }

    public void setHeight2(int height2) {
        if (height2 > 0) {
            this.height2 = height2;
        }
    }

    public void setHeight3(int height3) {
        if (height3 > 0){
        this.height3 = height3;
    }
}
}
