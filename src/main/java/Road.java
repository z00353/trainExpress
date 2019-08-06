public class Road {
    private Station start;
    private Station end;
    private int roadLength;

    public Road(Station start, Station end, int roadLength) {
        this.start = start;
        this.end = end;
        this.roadLength = roadLength;
    }

    public Station getStart() {
        return start;
    }
    public void setStart(Station start) {
        this.start = start;
    }
    public Station getEnd() {
        return  end;
    }
    public void setEnd(Station end) {
        this.end = end;
    }
    public int getRoadLength() {
        return roadLength;
    }

    public void setRoadLength(int roadLength) {
        this.roadLength = roadLength;
    }

    // New action
    // Accessing data from class Station
    public String getRoadName() {
        return start.getName() + end.getName();
    }
}
