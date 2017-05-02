//Mohamed Nasrallah
//CIS 436 - Mobile Application Development
//University of Michigan - Dearborn
//Prof. John P. Baugh
//Project 1 - Temperature Converter
// LAST UPDATED: 2/17/2017

package mn.temperatureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.sql.Types.NULL;
import static mn.temperatureapp.R.id.temperatureEditText;

public class MainActivity extends AppCompatActivity {

    EditText temp;
    RadioButton toC;
    RadioButton toF;

    List<String> fiveEntries = Arrays.asList("Dropdown for Next 5 Degrees Higher", "+2 = ?", "+3 = ?", "+4 = ?", "+5 = ?");
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (EditText) findViewById(temperatureEditText);
        toC = (RadioButton) findViewById(R.id.toCelsiusRadioButton);
        toF = (RadioButton) findViewById(R.id.toFahrenheitRadioButton);
        Spinner sp = (Spinner) findViewById(R.id.SpinAdd5);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fiveEntries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

    }

    public void convert(View v) {
        double value = new Double(temp.getText().toString());
        double backupNum = new Double(temp.getText().toString());

        if (toC.isChecked())
            value = UnitConverter.Fahrenheit2Celsius(value);    //when this radio button is checked, return the appropriate calculation result

        if (toF.isChecked())
            value = UnitConverter.Celsius2Fahrenheit(value);

        temp.setText(String.format("%.2f", new Double(value)).toString());//sends result back into a decimal format with two decimal spaces

        if (toC.isChecked()) //When the button Fahrenheit to Celsius is checked, preview the next 5 inputs
        {

            for (int i = 1; i < 6; i++)
            {
                fiveEntries.set(i-1, (String.format("%.2fF = %.2fC", backupNum+i, UnitConverter.Fahrenheit2Celsius(backupNum+i))));
            }

        }

        if (toF.isChecked()) //When the button Celsius to Fahrenheit is checked, preview the next 5 inputs
        {
            for (int i = 1; i < 6; i++)
            {
                fiveEntries.set(i-1, (String.format("%.2fC = %.2fF", backupNum+i, UnitConverter.Celsius2Fahrenheit(backupNum+i))));
            }
        }

        adapter.notifyDataSetChanged();
    }
}
