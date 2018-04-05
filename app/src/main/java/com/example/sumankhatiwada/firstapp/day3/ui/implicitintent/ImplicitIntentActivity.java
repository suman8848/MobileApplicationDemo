package com.example.sumankhatiwada.firstapp.day3.ui.implicitintent;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.sumankhatiwada.firstapp.R;
import com.example.sumankhatiwada.firstapp.base.BaseActivity;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.OnClick;

public class ImplicitIntentActivity extends BaseActivity {

    @BindView(R.id.edittext_implicit)
    EditText editTextImplicit;


    @BindView(R.id.btn_email)
    Button btnEmail;

    @BindView(R.id.imgiew_camera)
    ImageView imageViewCamera;



    @Override
    protected int getContentView() {
        return R.layout.activity_implicit_intent;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);


    }

    @OnClick(R.id.btn_email)
    public void sendEmail(){
        String subject = editTextImplicit.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    @OnClick(R.id.btn_call)
    public void call() {
        String number = editTextImplicit.getText().toString();
        if(checkCallPermission()) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
            startActivity(intent);
        }
    }

    @OnClick(R.id.btn_camera)
    public void openCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }


    private boolean checkCallPermission()
    {
        String permission = Manifest.permission.CALL_PHONE;
        int res = getApplicationContext().checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageViewCamera.setImageBitmap(imageBitmap);
        }
    }
}
