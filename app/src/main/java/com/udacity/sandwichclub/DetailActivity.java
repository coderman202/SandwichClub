package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private static final String LOG_TAG = DetailActivity.class.getSimpleName();

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    // All views which display Sandwich object details
    @BindView(R.id.also_known_tv) TextView alsoKnownAsView;
    @BindView(R.id.origin_tv) TextView originView;
    @BindView(R.id.description_tv) TextView descriptionView;
    @BindView(R.id.ingredients_tv) TextView ingredientsView;
    @BindView(R.id.image_iv) ImageView sandwichImageView;

    Sandwich sandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        // Get position variable passed through intent which is used to get correct Sandwich data
        // via the array
        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
       sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    /*
    * Get data from the Sandwich object and populate the views in the activity_detail layout
    */
    private void populateUI() {
        String akaNames = sandwich.getAlsoKnownAs().toString();

        // Remove the square brackets from the JSON array
        if(akaNames != null || !akaNames.equals("")){
            akaNames = akaNames.replace("[", "");
            akaNames = akaNames.replace("]", "");
        }
        
        alsoKnownAsView.setText(akaNames);
        descriptionView.setText(sandwich.getDescription());
        originView.setText(sandwich.getPlaceOfOrigin());

        String ingredients = sandwich.getIngredients().toString();

        // Remove the square brackets from the JSON array
        if(ingredients != null || !ingredients.equals("")){
            ingredients = ingredients.replace("[", "");
            ingredients = ingredients.replace("]", "");
        }
        ingredientsView.setText(ingredients);

        Picasso.with(this)
                .load(sandwich.getImage())
                .into(sandwichImageView);

        setTitle(sandwich.getMainName());

    }
}