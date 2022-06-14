package off.team.miyu.cheese;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.util.Base64;
import android.util.Log;
import android.app.AlertDialog;

public class MainActivity extends Activity { 
    private EditText a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);
        Button b=findViewById(R.id.b);
        Button c=findViewById(R.id.c);
        a=findViewById(R.id.a);
        b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    String d = new String(Base64.encode(a.getText().toString().getBytes(), Base64.DEFAULT));
                    Log.i("Test", "encode >>>" + d);
                    Toast.makeText(MainActivity.this,"加密结果为:"+d+"\n结果已复制",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String d = new String(Base64.decode(a.getText().toString().getBytes(), Base64.DEFAULT));
                    Log.i("Test", "decode >>>" + new String(Base64.decode(d.getBytes(), Base64.DEFAULT)));
                    Toast.makeText(MainActivity.this,"解密结果为:"+d+"\n结果已复制",Toast.LENGTH_SHORT).show();
                }
            });
        c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  new AlertDialog.Builder(MainActivity.this).setMessage("单击转换可以解密,长按转换可以加密,作者Cheese,QQ854675824,该项目已在GitHub上开源").show();  
                }
            });
    }
}
