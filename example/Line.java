package example;

public class Line {

    public Line(int length) {
        this.positions = new Position[length];
    }

    private Position[] positions;
    private int currentSize=0;

    public void put(Linable linable,int i){
        if(currentSize> positions.length){
            return;
        }
        while (positions[i]!=null){
            i=(i+1)%positions.length;
        }
        this.positions[i] = new Position(null);
        this.positions[i].setLinable(linable);
        ++currentSize;
    }

    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }

    class Position {

        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    @Override
    public String toString() {
        String lineString = "\t";
        int i=0;
        for (Position p : positions) {
            lineString += p.linable.toString();
            ++i;
            if(i==16){
                lineString+="\n";
                i=0;
            }
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }

}
