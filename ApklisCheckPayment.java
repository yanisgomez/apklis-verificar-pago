package your.app.packageId;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;

public class ApklisCheckPayment {

    private String APKLIS_PROVIDER = "content://cu.uci.android.apklis.payment.provider/app/";
    private String APKLIS_PAID = "paid";
    private String APKLIS_USER_NAME = "user_name";
    private boolean paid = false;
    private String username = null;
    ContentProviderClient contentResolver;

    public ApklisCheckPayment(Context CONTEXT,String APP_PACKAGE ){
        Uri provider_URI = Uri.parse(APKLIS_PROVIDER + APP_PACKAGE);
        try {

            contentResolver = CONTEXT.getContentResolver().acquireContentProviderClient(provider_URI);

            if (contentResolver != null) {
                Cursor apklisdb = contentResolver.query(provider_URI, null, null, null, null);
                if (apklisdb.moveToFirst()) {
                    paid = apklisdb.getInt(apklisdb.getColumnIndex(APKLIS_PAID)) > 0;
                    username = apklisdb.getString(apklisdb.getColumnIndex(APKLIS_USER_NAME));
                }
                apklisdb.close();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    contentResolver.close();
                } else {
                    contentResolver.release();
                }
            }
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }

    public boolean getPaid() {

        return paid;
    }

    public String getUserName() {

        return username;
    }
}
