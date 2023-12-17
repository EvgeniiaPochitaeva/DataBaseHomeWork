package app.database.find.classes;

public class FindLongestProject {
    private int project_id;
    private int monthCount;

    public FindLongestProject(int project_id, int monthCount) {
        this.project_id = project_id;
        this.monthCount = monthCount;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "project_id ='" + project_id + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}
