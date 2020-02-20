import java.util.List;

public class Submission {

    private Integer numsOfLibs;
    private List<LibSubmission> libSubmissions;


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
