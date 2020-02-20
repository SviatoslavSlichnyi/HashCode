import java.util.List;

public class Submission {
    private Integer numsOfLibs;

    public Integer getNumsOfLibs() {
        return numsOfLibs;
    }

    public void setNumsOfLibs(Integer numsOfLibs) {
        this.numsOfLibs = numsOfLibs;
    }

    public List<LibSubmission> getLibs() {
        return libs;
    }

    public void setLibs(List<LibSubmission> libs) {
        this.libs = libs;
    }

    private List<LibSubmission> libs;
}
