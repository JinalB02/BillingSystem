package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Item;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ItemsRepository {
    public ArrayList<Item> getProducts() {
        ArrayList list = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(
                    new FileReader("src\\main\\resources\\items.json")
            );
            if (null != jsonArray) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    list.add(mapper.readValue(jsonArray.get(i).toString(), Item.class));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
