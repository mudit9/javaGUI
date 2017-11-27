import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;

public class DB {

    private static String jsonFileLocation = "src/animalData.json";

    public DB(){
    }

    public static ArrayList<Animal> getCurrentAnimals() {
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        ArrayList<Animal> animals = new ArrayList<Animal>();
        try (FileReader reader = new FileReader(jsonFileLocation)) {
            Object obj = parser.parse(reader);
            JSONArray currentAnimals = (JSONArray) obj;
            animals = extractAnimals(currentAnimals);
        }
        catch (IOException e) {
            System.out.println("# IOException DB.java " + e);
        }
        catch(org.json.simple.parser.ParseException e){
            System.out.println("# ParserException DB.java " + e);
        }
        return animals;
    }

    public static ArrayList<Animal> extractAnimals(JSONArray animalData){
        ArrayList<Animal> animals = new ArrayList<Animal>();
        for(int i = 0;i <= animalData.size() - 1;i++){
            JSONObject animal = (JSONObject) animalData.get(i);
            String ID = (String) animal.get("animalID");
            String currentStatus = (String) animal.get("status");
            String food = String.valueOf(animal.get("Food quantity"));
            int x = Integer.parseInt(food);
            String type = (String) animal.get("Type");
            Animal newAnimal = new Animal(ID,currentStatus,x,type);
        }
        return animals;
    }

    public static void setCurrentAnimals(ArrayList<Animal> newAnimals) {
        ArrayList<JSONObject> animalDataInJSON = convertToJSON(newAnimals);
        JSONParser parser = new JSONParser();
        try(FileWriter writer = new FileWriter(jsonFileLocation)){
            JSONArray newJSONAnimals = new JSONArray();
            for(JSONObject animal : animalDataInJSON){
                newJSONAnimals.add(animal);
            }
            writer.write(newJSONAnimals.toJSONString());
            writer.flush();
        }
        catch(IOException e){
            System.out.println("# IOException DB.java " + e);
        }
    }

    public static ArrayList<JSONObject> convertToJSON(ArrayList<Animal> newAnimals) {
        ArrayList<JSONObject> animalDataInJSON = new ArrayList<JSONObject>();
        for (Animal animal : newAnimals) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("animalID", animal.getanimalID());
            jsonObject.put("status", "" + animal.getStatus());
            jsonObject.put("Food quantity",+ animal.foodquantity);
            jsonObject.put("Type",animal.getType());
            animalDataInJSON.add(jsonObject);
        }
        return animalDataInJSON;
    }

}