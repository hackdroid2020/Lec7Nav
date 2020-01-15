package edu.tomerbu.lec7nav;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseRecipeFragment extends Fragment {

    private EditText etRecipe;
    private Button btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_choose_recipe, container, false);

        etRecipe = v.findViewById(R.id.edit_recipe);
        btnNext = v.findViewById(R.id.button_next);

        btnNext.setOnClickListener((btn)->{
            //find the Navigation Controller for this fragment:
            NavController navController = Navigation.findNavController(v);

            //pass the text from the edit text:
            String recipe = etRecipe.getText().toString();

            Bundle args = new Bundle();
            args.putString(Constants.ARG_RECIPE, recipe);

            //do the navigation (we use the action defined in our app_graph.xml file)
            navController.navigate(R.id.action_chooseRecipeFragment_to_specifyAmountFragment, args);
        });
        return v;
    }
}
