package Models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PetModel {

    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("categoryId")
    private int categoryId;
    @JsonProperty("categoryName")
    private String categoryName;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("status")
    private String status;

    public void setStatus(String status){
        this.status = status;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }

    public void setPhotoUrls(List<String> photoUrls){
        this.photoUrls = photoUrls;
    }

    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(Integer id){
        this.id = id;
    }
}
