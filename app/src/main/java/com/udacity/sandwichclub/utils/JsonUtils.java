package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String LOG_TAG = JsonUtils.class.getSimpleName();

    // Keys to refer to the JSON objects, set as constants to make parsing clearer
    private static final String SANDWICH_NAME_KEY = "name";
    private static final String SANDWICH_MAIN_NAME_KEY = "mainName";
    private static final String SANDWICH_AKA_KEY = "alsoKnownAs";
    private static final String SANDWICH_ORIGIN_KEY = "placeOfOrigin";
    private static final String SANDWICH_DESCRIPTION_KEY = "description";
    private static final String SANDWICH_IMAGE_KEY = "image";
    private static final String SANDWICH_INGREDIENTS_KEY = "ingredients";

    /**
     * Parsing the sandwich details represented as a JSON object.
     * All parsing done inside a try-catch block in case of any errors.
     *
     * @param json the json object stored in a String
     * @return the custom Sandwich object
     */
    public static Sandwich parseSandwichJson(String json) {

        try{
            JSONObject jsonSandwich = new JSONObject(json);

            JSONObject sandwichNames;
            JSONArray ingredientsArray;
            JSONArray akaArray;

            // List of variables to store the parsed data which will be passed as parameters to the
            // returned Sandwich object.
            String mainName = "";
            List<String> alsoKnownAs = new ArrayList<>();
            String placeOfOrigin = "";
            String description = "";
            String image = "";
            List<String> ingredients = new ArrayList<>();

            if(jsonSandwich.has(SANDWICH_NAME_KEY)){
                sandwichNames = jsonSandwich.getJSONObject(SANDWICH_NAME_KEY);

                if(sandwichNames.has(SANDWICH_MAIN_NAME_KEY)){
                    mainName = sandwichNames.getString(SANDWICH_MAIN_NAME_KEY);
                }

                if(sandwichNames.has(SANDWICH_AKA_KEY)){
                    akaArray = sandwichNames.getJSONArray(SANDWICH_AKA_KEY);
                    for (int i = 0; i < akaArray.length(); i++) {
                        alsoKnownAs.add(akaArray.getString(i));
                    }
                }
            }

            if(jsonSandwich.has(SANDWICH_ORIGIN_KEY)){
                placeOfOrigin = jsonSandwich.getString(SANDWICH_ORIGIN_KEY);
            }

            if(jsonSandwich.has(SANDWICH_DESCRIPTION_KEY)){
                description = jsonSandwich.getString(SANDWICH_DESCRIPTION_KEY);
            }

            if(jsonSandwich.has(SANDWICH_IMAGE_KEY)){
                image = jsonSandwich.getString(SANDWICH_IMAGE_KEY);
            }

            if(jsonSandwich.has(SANDWICH_INGREDIENTS_KEY)){
                ingredientsArray = jsonSandwich.getJSONArray(SANDWICH_INGREDIENTS_KEY);
                for (int i = 0; i < ingredientsArray.length(); i++) {
                    ingredients.add(ingredientsArray.getString(i));
                }
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return null;
    }
}
