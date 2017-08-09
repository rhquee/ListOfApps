package pl.kfrak.listofapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //layout manager - mówi ze elementy maja byc pod sobą (góra-dół); aleternatywa = grid manager - ustawia elementy w kostkę;

        //dane testowe:
       // ArrayList<AppInfo> appInfos = new ArrayList<>();
        //appInfos.add(new AppInfo(0, "Test", new Drawable.createFromXml(R.mipmap.ic_launcher))); //nie dziala
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayout.HORIZONTAL, true)); //true - reverse layout (z prawej do lewej)

        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        //z ApplicationInfo do AppInfo:
        List<AppInfo> appInfos = new ArrayList<>();
        for(ApplicationInfo applicationInfo : apps){
            appInfos.add(new AppInfo(
                    applicationInfo.uid,
                    applicationInfo.loadLabel(packageManager).toString(),
                    applicationInfo.loadIcon(packageManager)
            ));
        }

//        AppAdapter appAdapter = new AppAdapter(appInfos);
//        recyclerView.setAdapter(appAdapter);
//
//        progressBar.setVisibility(View.GONE);
        return new AppAdapter(appInfos);
    }

    private class InstalledAppsAsyncTask extends AsyncTask<Void, Void, AppAdapter>{ //Void bo nie wrzucamy zadnych parametrów


        @Override
        protected void onPostExecute(AppAdapter appAdapter) {
            super.onPostExecute(appAdapter);
        }

        @Override
        protected AppAdapter doInBackground(Void... voids) {
            return null;
        }

    }
}
