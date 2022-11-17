public class Vars {
    private float press;
    private int temp;
    private int rot;

    public Vars(float p,int t,int r){
        this.press=p;
        this.temp=t;
        this.rot=r;
    }

    public float GetPress(){
        return press;
    }
    public int GetTemp(){
        return temp;
    }
    public int GetRot(){
        return rot;
    }
}
