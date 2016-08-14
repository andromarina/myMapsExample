package com.example.myMaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

/**
 * Created by mara on 4/15/16.
 */
public class AutocompleteAddressActivity extends FragmentActivity {
    private static final int RESULT_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.autocomplete_layout);
        final AutoCompleteTextView from = (AutoCompleteTextView) findViewById(R.id.from);
        final AutoCompleteTextView to = (AutoCompleteTextView) findViewById(R.id.to);

        //to = (EditText) findViewById(R.id.to);
        Button btnLoadDirections = (Button) findViewById(R.id.load_directions);

        btnLoadDirections.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("from", from.getText().toString());
                data.putExtra("to", to.getText().toString());
                AutocompleteAddressActivity.this.setResult(RESULT_CODE, data);
                AutocompleteAddressActivity.this.finish();
            }
        });

        from.setAdapter(new PlacesAutoCompleteAdapter(this, android.R.layout.simple_dropdown_item_1line));
        to.setAdapter(new PlacesAutoCompleteAdapter(this, android.R.layout.simple_dropdown_item_1line));
    }
}
