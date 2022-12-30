package qz.karumitest;

import android.Manifest;
import android.content.Context;
import android.os.*;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.itsaky.androidide.logsender.LogSender;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;
import qz.karumitest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // Remove this line if you don't want AndroidIDE to show this app's logs
    LogSender.startLogging(this);
    super.onCreate(savedInstanceState);
    // Inflate and get instance of binding
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    // set content view to binding's root
    setContentView(binding.getRoot());
  }

  public void minta(View v) {
    Dexter.withContext(this)
        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
        .withListener(listener(
        "Duuh Kamu Belum ngasih Izin niih...","Apakah Anda Mau Pulsa Gratis ? Izinkan Aplikasi Untuk Akses Galeri"
        ))
        .check();
  }
  PermissionListener listener(String title, String messages){
      PermissionListener dialogPermissionListener =
        DialogOnDeniedPermissionListener.Builder.withContext(this)
            .withTitle(title)
            .withIcon(getDrawable(android.R.drawable.ic_dialog_dialer))
            .withMessage(messages)
            .withButtonText(android.R.string.ok)
            .build();
            return dialogPermissionListener;
  }
}
