package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
//        private String mainName;
//        private List<String> alsoKnownAs = null;
//        private String placeOfOrigin;
//        private String description;
//        private String image;
//        private List<String> ingredients = null;

        if (json.isEmpty() || json == null ) {
            return null;
        }
        try {
            JSONObject JOSNSandwich = new JSONObject(json);
            Sandwich sandwich = new Sandwich();
            JSONObject name = JOSNSandwich.getJSONObject("name");
            sandwich.setMainName(name.getString("mainName"));
            sandwich.setAlsoKnownAs(convertJsonArray((JSONArray) name.get("alsoKnownAs")));
            System.out.print("Also know as"  + name.get("alsoKnownAs"));
            sandwich.setPlaceOfOrigin(JOSNSandwich.getString("placeOfOrigin"));
            sandwich.setDescription(JOSNSandwich.getString("description"));
            sandwich.setImage(JOSNSandwich.getString("image"));
            sandwich.setIngredients(convertJsonArray((JSONArray) JOSNSandwich.get("ingredients")));
            return sandwich;

        }catch(JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static List<String> convertJsonArray(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }

}
