package com.yishai.baseconverteractivity;
/**
 * Created by Yishai 308396761
 */
        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.view.View;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.widget.Toast;
public class ConverterBaseActivity extends Activity implements TextWatcher,View.OnClickListener
{
    EditText txtDecimal,txtBase;
    TextView txtResult;
    Button btn;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_base);
        txtDecimal=(EditText)findViewById(R.id.txtDecimal);
        txtBase=(EditText)findViewById(R.id.txtBase);
        txtResult=(TextView)findViewById(R.id.txtResult);
        txtDecimal.addTextChangedListener(this);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }
    public void beforeTextChanged(CharSequence sequence,int start,int count,int after)
    {
    }
    public void afterTextChanged(Editable editable)
    {
    }
    public void onTextChanged(CharSequence sequence,int start,int before,int count)
    {
    }
    public void onClick(View view) {
        if (txtDecimal.getText().toString().trim().length() == 0) { // empty decimal
            Toast.makeText(getApplicationContext(),
                    "Empty decimal!", Toast.LENGTH_LONG).show();
            return;
        }
        if (txtBase.getText().toString().trim().length() == 0) { // empty base
            Toast.makeText(getApplicationContext(),
                    "Empty base!", Toast.LENGTH_LONG).show();
            return;
        }
        int decimal = Integer.parseInt(txtDecimal.getText().toString());
        int base = Integer.parseInt(txtBase.getText().toString());
        if (base < 2 || base > 36){
            Toast.makeText(getApplicationContext(),  // error base num
                    "Error base!", Toast.LENGTH_LONG).show();
        return;
    }

        String s = BaseConverter.convertFrom10(decimal, base); // base converter methood

        txtResult.setText(s);   //Displays the conversion result in the label under the button.
    }
}