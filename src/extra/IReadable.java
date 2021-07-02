package extra;

interface IReadable {
    public void read();
}

interface Serializable{

}

interface Visualizable extends  IReadable, Serializable{
    void setViewed();
    Boolean isViewed();
    String timeViewed();
}
