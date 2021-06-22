public class Tail {
    private int x;
    private int y;
    private boolean edge;
    private int edgeDirection;

    public Tail(int x, int y) {
        this.x = x;
        this.y = y;
        this.edge = false;
    }

    public int getEdgeDirection() {
        return edgeDirection;
    }

    public void setEdgeDirection(int edgeDirection) {
        this.edgeDirection = edgeDirection;
    }

    public boolean isEdge() {
        return edge;
    }

    public void setEdge(boolean edge) {
        this.edge = edge;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}