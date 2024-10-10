package com.inf3fm.elden.charityconnect.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.inf3fm.elden.charityconnect.R;
import com.inf3fm.elden.charityconnect.models.HomeItem;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<HomeItem> homeItems;
    private Context context;

    public HomeAdapter(List<HomeItem> homeItems, Context context) {
        this.homeItems = homeItems;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeItem homeItem = homeItems.get(position);
        holder.imageView.setImageResource(homeItem.getImageResId());
        holder.textViewTitle.setText(homeItem.getTitle());
        holder.textViewDescription.setText(homeItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDescription;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
