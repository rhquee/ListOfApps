package pl.kfrak.listofapps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import lombok.AllArgsConstructor;

/**
 * Created by RENT on 2017-08-09.
 */

@AllArgsConstructor
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {

    private List<AppInfo> appInfos;

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ta metoda tworzy nowy view dla VH
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_row, null);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        AppInfo appInfo = appInfos.get(position);
        holder.name.setText(appInfo.getName());
        holder.icon.setImageDrawable(appInfo.getIcon());
    }

    //co zwraca (pusta lista jesli nie zwraca null)
    @Override
    public int getItemCount() {
        return appInfos.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView icon;

        public AppViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.app_row_imageView);
            name = (TextView) itemView.findViewById(R.id.app_row_textView);
        }

        //dlaczego najpierw VH a potem adapter? bo adapter jako w parametrze przyjmuje VH
    }

}
