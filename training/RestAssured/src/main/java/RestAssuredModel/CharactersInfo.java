package RestAssuredModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CharactersInfo {


    private int char_id;
    private String name;
    private String birthday;
    private List<String> occupation;
    private String img;
    private String status;
    private String nickname;
    private List<Integer> appearance;
    private String portrayed;
    private String category;
    private List<String> better_call_saul_appearance;


    public CharactersInfo() {
    }

    public CharactersInfo(int char_id, String name, String birthday, List<String> occupation, String img, String status, String nickname, List<Integer> appearance, String portrayed, String category, List<String> better_call_saul_appearance) {
        this.char_id = char_id;
        this.name = name;
        this.birthday = birthday;
        this.occupation = occupation;
        this.img = img;
        this.status = status;
        this.nickname = nickname;
        this.appearance = appearance;
        this.portrayed = portrayed;
        this.category = category;
        this.better_call_saul_appearance = better_call_saul_appearance;
    }



    @JsonProperty("char_id")
    public int getChar_id() {
        return char_id;
    }

    public void setChar_id(int char_id) {
        this.char_id = char_id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("birthday")
    public String getBirthday() {
        return birthday;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JsonProperty("occupation")
    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("appearance")
    public List<Integer> getAppearance() {
        return appearance;
    }

    public void setAppearance(List<Integer> appearance) {
        this.appearance = appearance;
    }

    @JsonProperty("portrayed")
    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("better_call_saul_appearance")
    public List<String> getBetter_call_saul_appearance() {
        return better_call_saul_appearance;
    }

    public void setBetter_call_saul_appearance(List<String> better_call_saul_appearance) {
        this.better_call_saul_appearance = better_call_saul_appearance;
    }
}
