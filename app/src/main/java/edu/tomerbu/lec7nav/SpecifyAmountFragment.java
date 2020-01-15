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

public class SpecifyAmountFragment extends Fragment {
    private Button btnNext;
    private EditText etAmount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_specify_amount, container, false);

        etAmount = v.findViewById(R.id.edit_amount);
        btnNext = v.findViewById(R.id.button_next);

        btnNext.setOnClickListener(btn -> {
            NavController navController = Navigation.findNavController(v);

            String text = etAmount.getText().toString();
            //get the arguments from the previous screen
            Bundle args = getArguments();
            //if we didn't receive arguments -> args = new Bundle()
            if (args == null)
                args = new Bundle();

            //add our amount to the bundle:
            args.putString(Constants.ARG_AMOUNT, text);

            //show the next screen, passing the arguments:
            navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, args);
        });
        return v;
    }
}
