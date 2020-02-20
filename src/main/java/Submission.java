import java.util.ArrayList;
import java.util.List;

public class Submission {

    private Integer numsOfLibs;
    private List<LibSubmission> libSubmissions = new ArrayList<>();


    public Integer getNumsOfLibs() {
        return numsOfLibs;
    }

    public void setNumsOfLibs(Integer numsOfLibs) {
        this.numsOfLibs = numsOfLibs;
    }

    public List<LibSubmission> getLibSubmissions() {
        return libSubmissions;
    }

    public void addLibSub(LibSubmission libSubmission) {
        libSubmissions.add(libSubmission);
    }
}
