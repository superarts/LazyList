package com.fedorvlasov.lazylist;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private String[] data;
    private String[] names;
    private String[] descs;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
    
    public LazyAdapter(Activity a, String[] n, String[] d, String[] u) {
        activity = a;
        data = u;
        names = n;
        descs = d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.lazylist_item, null);

        //	Log.v("mpire", names[position]);
        TextView text = (TextView)vi.findViewById(R.id.text);
        TextView desc = (TextView)vi.findViewById(R.id.text_description);
        ImageView image=(ImageView)vi.findViewById(R.id.image);
        text.setText(names[position]);
        desc.setText(descs[position]);
        imageLoader.DisplayImage(data[position], image);
        return vi;
    }
}