package com.inf3fm.elden.charityconnect;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inf3fm.elden.charityconnect.placeholder.PlaceholderContent.PlaceholderItem;
import com.inf3fm.elden.charityconnect.databinding.FragmentProdutoBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyONGRecyclerViewAdapter extends RecyclerView.Adapter<MyONGRecyclerViewAdapter.ViewHolder> {

    private final List<ONG> mValues;

    public MyONGRecyclerViewAdapter(List<ONG> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentProdutoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mImageView.setImageBitmap(Util.converterByteToBipmap(mValues.get(position).getFoto()));
        holder.mContentView.setText(mValues.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final AppCompatImageView mImageView;
        public final AppCompatTextView mContentView;
        public ONG mItem;

        public ViewHolder(FragmentProdutoBinding binding) {
            super(binding.getRoot());
            mImageView = binding.imagemOng;
            mContentView = binding.nomeOng;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}