package com.example.sumankhatiwada.firstapp.day3.ui.dashboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumankhatiwada.firstapp.R;

/**
 * Created by sumankhatiwada on 4/4/18.
 */

public class DashBoardItemAdapter extends BaseAdapter {

    LayoutInflater inflter;
    Context context;
    int prodcuts[] = {};
    String productName[] = {};
    public DashBoardItemAdapter(Context applicationContext, int[] products, String[] productName) {
        this.context=applicationContext;
        this.prodcuts = products;
        this.productName = productName;
        this.inflter = LayoutInflater.from(applicationContext);
        Log.e("Productsimage",products.length+"");
    }

    @Override
    public int getCount() {
        return prodcuts.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.product_item, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.imageview_product); // get the reference of ImageView
        TextView textView = (TextView) view.findViewById(R.id.textview_product_ame); // get the reference of TextView
        icon.setImageResource(prodcuts[i]);
        textView.setText(productName[i]);

        return view;
    }
}
