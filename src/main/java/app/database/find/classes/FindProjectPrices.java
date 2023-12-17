package app.database.find.classes;

public class FindProjectPrices {
    private int project_id;
    private long price;

    public FindProjectPrices(int project_id, long price) {
        this.project_id = project_id;
        this.price = price;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "project_id='" +  project_id + '\'' +
                ", price=" + price +
                '}';
    }
}