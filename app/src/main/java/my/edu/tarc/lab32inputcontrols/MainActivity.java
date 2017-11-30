package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //Create an adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.age_group,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int position;
        double fee = 0, premiumFee = 0, smokerFee = 0, totalFee = 0;

        //String renminbi = Currency.getInstance(Locale.CHINA).getSymbol();

        position = spinnerAge.getSelectedItemPosition();

        switch (position){
            case 0:
                fee = 50.00;
                break;
            case 1:
                fee = 55.00;
                break;
            case 2:
                fee = 60.00;
                break;
            case 3:
                fee = 70.00;
                break;
            case 4:
                fee = 120.00;
                break;
            case 5:
                fee = 160.00;
                break;
            case 6:
                fee = 200.00;
                break;
            case 7:
                fee = 250.00;
                break;
            default:
                break;
        }

        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();

        if(indexGender == R.id.radioButtonMale){
            //TODO: calculate premium for male

            switch (position){
                case 0:
                    premiumFee = 0;
                    break;
                case 1:
                    premiumFee = 0;
                    break;
                case 2:
                    premiumFee = 50.00;
                    break;
                case 3:
                    premiumFee = 100.00;
                    break;
                case 4:
                    premiumFee = 100.00;
                    break;
                case 5:
                    premiumFee = 50.00;
                    break;
                case 6:
                    premiumFee = 0;
                    break;
                case 7:
                    premiumFee = 0;
                    break;
                default:
                    break;
            }
        }

        if(checkBoxSmoker.isChecked()){
            //TODO: calculate premium for smoker

            switch (position){
                case 0:
                    smokerFee = 0;
                    break;
                case 1:
                    smokerFee = 0;
                    break;
                case 2:
                    smokerFee = 0;
                    break;
                case 3:
                    smokerFee = 100.00;
                    break;
                case 4:
                    smokerFee = 150.00;
                    break;
                case 5:
                    smokerFee = 150.00;
                    break;
                case 6:
                    smokerFee = 250.00;
                    break;
                case 7:
                    smokerFee = 250.00;
                    break;
                default:
                    break;
            }
        }

        totalFee = fee + premiumFee + smokerFee;
        Locale locale = Locale.getDefault();
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String currencyText = fmt.format(totalFee);

        //dont hardcode "Premium", follow the country code
        textViewPremium.setText(getString(R.string.premium) + currencyText);
    }

    public void resetPremium(View view){

    }
}
