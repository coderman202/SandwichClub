package com.udacity.sandwichclub.model;

import java.util.List;

/**
 * The type Sandwich.
 */
public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    /**
     * Instantiates a new Sandwich.
     *
     * @param mainName      the main name
     * @param alsoKnownAs   the also known as
     * @param placeOfOrigin the place of origin
     * @param description   the description
     * @param image         the image
     * @param ingredients   the ingredients
     */
    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    /**
     * Gets main name.
     *
     * @return the main name
     */
    public String getMainName() {
        return mainName;
    }

    /**
     * Sets main name.
     *
     * @param mainName the main name
     */
    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    /**
     * Gets also known as.
     *
     * @return the also known as
     */
    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    /**
     * Sets also known as.
     *
     * @param alsoKnownAs the also known as
     */
    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    /**
     * Gets place of origin.
     *
     * @return the place of origin
     */
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    /**
     * Sets place of origin.
     *
     * @param placeOfOrigin the place of origin
     */
    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets ingredients.
     *
     * @return the ingredients
     */
    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * Sets ingredients.
     *
     * @param ingredients the ingredients
     */
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
