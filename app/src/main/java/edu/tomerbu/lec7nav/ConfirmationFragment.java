package edu.tomerbu.lec7nav;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_confirmation, container, false);

        TextView tvSummary = v.findViewById(R.id.text_summary);

        Bundle args = getArguments();

        if (args != null) {
            String amount = args.getString(Constants.ARG_AMOUNT);
            String recipe = args.getString(Constants.ARG_RECIPE);

            tvSummary.setText(amount + " " + recipe);
        }

        return v;
    }
}
