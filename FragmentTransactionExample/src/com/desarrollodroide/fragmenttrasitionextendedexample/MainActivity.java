package com.desarrollodroide.fragmenttrasitionextendedexample;

// Eclipse Branch
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;



public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{
    private int optionSelected = 0;
    private SlidingListFragmentLeft mFirstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Add first fragment
        mFirstFragment = new SlidingListFragmentLeft();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment_place, mFirstFragment);
        fragmentTransaction.commit();
    }

    public void addTransition(View view) {
        Button button = (Button) findViewById(R.id.button);
        if (getFragmentManager().getBackStackEntryCount()==0) {
            Fragment secondFragment = new SlidingListFragmentRight();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended(this, fragmentTransaction, mFirstFragment, secondFragment, R.id.fragment_place);
            fragmentTransactionExtended.addTransition(optionSelected);
            fragmentTransactionExtended.commit();
            button.setText("Back");
        }else{
            getFragmentManager().popBackStack();
            button.setText("Push");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        optionSelected = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onBackPressed()
    {
        Button button = (Button) findViewById(R.id.button);
        button.setText("Push");
        super.onBackPressed();
    }

}
