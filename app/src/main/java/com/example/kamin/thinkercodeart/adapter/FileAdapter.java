package com.example.kamin.thinkercodeart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamin.thinkercodeart.R;

import java.io.File;

/**
 * Created by Anton on 22.12.2016.
 */

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.MainViewHolder> {
    File[] fileArray;
    Context context;
    private static final int TYPE_DIRECTORY = 0;
    private static final int TYPE_PHOTO = 1;

    public FileAdapter(Context context, File[] fileArray) {
        this.fileArray = fileArray;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0 ? TYPE_DIRECTORY : TYPE_PHOTO);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_DIRECTORY:{

                View v = LayoutInflater.from(context).inflate(R.layout.item_dir, parent, false);
                v.setMinimumHeight(100);
                return new DirectoryHolder(v);}
            case TYPE_PHOTO: {
                View vp = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
                vp.setMinimumHeight(100);
                return new PhotoHolder(vp);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_DIRECTORY) {
            DirectoryHolder dirHolder = (DirectoryHolder) holder;
            dirHolder.ivDir.setImageDrawable(context.getResources().getDrawable(R.mipmap.folder));
            dirHolder.tvDirName.setText("Nameameame");
        }
        if (holder.getItemViewType() == TYPE_PHOTO) {
            PhotoHolder fileHolder = (PhotoHolder) holder;
            fileHolder.ivIcon.setImageDrawable(context.getResources().getDrawable(R.mipmap.empty_avatar));
        }
    }

    @Override
    public int getItemCount() {
        return fileArray.length;
    }


    public class PhotoHolder extends MainViewHolder {
        ImageView ivIcon;

        public PhotoHolder(View v) {
            super(v);
            ViewGroup.LayoutParams params=v.getLayoutParams();
            //Log.d(TAG,"v.getLayoutParams().width "+v.getWidth());
            params.width=240;
            params.height=240;
            v.setLayoutParams(params);
            this.ivIcon = (ImageView) v.findViewById(R.id.ivIcon);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Redraw the old selection and the new
                }
            });
        }
    }

    public class DirectoryHolder extends MainViewHolder {
        TextView tvDirName;
        ImageView ivDir;

        public DirectoryHolder(View v) {
            super(v);
            ViewGroup.LayoutParams params=v.getLayoutParams();
            params.width=240;
            params.height=240;
            v.setLayoutParams(params);
            this.tvDirName = (TextView) v.findViewById(R.id.tvDirName);
            this.ivDir = (ImageView) v.findViewById(R.id.ivDir);

        }
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(View v) {
            super(v);
        }
    }

}