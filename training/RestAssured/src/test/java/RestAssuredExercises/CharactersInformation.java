package RestAssuredExercises;

import static io.restassured.RestAssured.*;
import RestAssuredModel.CharactersInfo;
import org.testng.annotations.Test;

public class CharactersInformation{
    @Test
    public void WalterInformation(){
        String name;
        name = "Walter White";
        CharactersInfo[] charactersInfo = given().when().get("https://www.breakingbadapi.com/api/characters").as(CharactersInfo[].class);
        for (CharactersInfo c: charactersInfo){
            if (c.getName().equals(name)) {
                System.out.println( name + " Birthday is: " + c.getBirthday());
            }
        }

    }

    @Test
    public void CharacterNameAndPortrayed(){

        CharactersInfo[] charactersInfo = given().when().get("https://www.breakingbadapi.com/api/characters").as(CharactersInfo[].class);
        for (CharactersInfo c: charactersInfo){
            System.out.println("Character Name: " + "\""+c.getName() + "\"" + "\nPortrayed: " + "\"" + c.getPortrayed() + "\"" + "\n-----------------------------\n");
        }

    }
}
